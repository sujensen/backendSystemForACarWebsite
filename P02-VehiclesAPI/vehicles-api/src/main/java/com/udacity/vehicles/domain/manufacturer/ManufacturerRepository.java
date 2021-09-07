package com.udacity.vehicles.domain.manufacturer;

import com.udacity.vehicles.domain.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {

    public static final String FIND_MANUFACTURER = "SELECT * FROM manufacturer WHERE code = :code AND name = :name";

    @Query(value=FIND_MANUFACTURER, nativeQuery = true)
    Manufacturer findManufacturer(Integer code, String name);

}
