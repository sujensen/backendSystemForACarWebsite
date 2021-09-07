package com.udacity.vehicles.validation;

import com.udacity.vehicles.domain.car.Car;
import com.udacity.vehicles.domain.manufacturer.Manufacturer;
import com.udacity.vehicles.domain.manufacturer.ManufacturerRepository;
import com.udacity.vehicles.service.ManufacturerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
public class ValidationService {

    @Autowired
    ManufacturerRepository mRepo;

    @Validated(OnCreateOrUpdate.class)
    public void validateSubmittedManufacturer(@Valid Car car){
        Manufacturer submittedManufacturer = mRepo.findManufacturer(
                car.getDetails().getManufacturer().getCode(),
                car.getDetails().getManufacturer().getName());
        if (submittedManufacturer == null) {
            throw new ManufacturerNotFoundException();
        }
    }
}
