package com.udacity.vehicles.domain.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    public static final String FIND_CAR_BY_ID = "SELECT * FROM car WHERE id = :id";

    @Query(value=FIND_CAR_BY_ID, nativeQuery = true)
    Car findCarById(Long id);

}
