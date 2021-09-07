package com.udacity.vehicles.service;

import com.udacity.vehicles.client.maps.MapsClient;
import com.udacity.vehicles.client.prices.PriceClient;
import com.udacity.vehicles.domain.Location;
import com.udacity.vehicles.domain.car.Car;
import com.udacity.vehicles.domain.car.CarRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Implements the car service create, read, update or delete
 * information about vehicles, as well as gather related
 * location and price data when desired.
 */
@Service
public class CarService {

    private final CarRepository repository;
    MapsClient maps;
    PriceClient pricing;

    public CarService(CarRepository repository, @Autowired MapsClient maps, @Autowired PriceClient pricing) {

        // Add the Maps and Pricing Web Clients you create
        // in `VehiclesApiApplication` as arguments and set them here.
        this.repository = repository;
        this.maps = maps;
        this.pricing = pricing;
    }

    /**
     * Gathers a list of all vehicles
     * @return a list of all vehicles in the CarRepository
     */
    public List<Car> list() {
        List<Car> repoList = repository.findAll();

        // Enhance the information on each car in the repo, by finding the
        // price and address as well.
        List<Car> newList = new ArrayList<Car>();
        for (Car repoCar : repoList) {
            Car newCar = findById(repoCar.getId());
            newList.add(newCar);
        }
        return newList;
    }

    /**
     * Gets car information by ID (or throws exception if non-existent)
     * @param id the ID number of the car to gather information on
     * @return the requested car's information, including location and price
     */
    public Car findById(Long id) {

        // Find the car by ID from the `repository` if it exists.
        // If it does not exist, throw a CarNotFoundException
        Optional<Car> optionalCar = Optional.ofNullable(repository.findCarById(id));
        Car car = optionalCar.orElseThrow(CarNotFoundException::new);

        // Use the Pricing Web client you create in `VehiclesApiApplication`
        // to get the price based on the `id` input'.
        // Set the price of the car.
        // Note: The car class file uses @transient, meaning you will need to call
        // the pricing service each time to get the price.

        // There are only 20 prices, so if the id of the vehicle is > 20, use the remainder.
        Long priceId = id;
        if (id > 20) {
            priceId = id % 20;
        }
        String price = pricing.getPrice(priceId);
        car.setPrice(price);


        // Use the Maps Web client you create in `VehiclesApiApplication`
        // to get the address for the vehicle. You should access the location
        // from the car object and feed it to the Maps service.
        // Set the location of the vehicle, including the address information.
        // The Location class file also uses @transient for the address,
        // meaning the Maps service needs to be called each time for the address.
        Location origLocation = car.getLocation();
        Location newLocation = maps.getAddress(origLocation);
        car.setLocation(newLocation);

        return car;
    }

    /**
     * Either creates or updates a vehicle, based on prior existence of car
     * @param car A car object, which can be either new or existing
     * @return the new/updated car is stored in the repository
     */
    public Car save(Car car) {
        if (car.getId() != null) {
            return repository.findById(car.getId())
                    .map(carToBeUpdated -> {
                        carToBeUpdated.setCondition(car.getCondition());
                        carToBeUpdated.setDetails(car.getDetails());
                        carToBeUpdated.setLocation(car.getLocation());
                        return repository.save(carToBeUpdated);
                    }).orElseThrow(CarNotFoundException::new);
        }
        return repository.save(car);
    }

    /**
     * Deletes a given car by ID
     * @param id the ID number of the car to delete
     */
    public void delete(Long id) {

        // Find the car by ID from the `repository` if it exists.
        // If it does not exist, throw a CarNotFoundException
        Optional<Car> optionalCar = Optional.ofNullable(repository.findCarById(id));
        Car car = optionalCar.orElseThrow(CarNotFoundException::new);

        // Delete the car from the repository.
        repository.delete(car);
    }
}
