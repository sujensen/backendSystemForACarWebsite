package com.udacity.pricing.repository;

import com.udacity.pricing.entity.Car;
import org.springframework.data.repository.CrudRepository;

/*
Spring will create an implementation of this interface, whenever the application runs.
CrudRepository will, behind the scenes, create the typical crud methods for this entity.
 */
public interface CarRepository extends CrudRepository<Car, Long> {
}
