package com.udacity.vehicles.service;

import com.udacity.vehicles.domain.car.Car;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Manufacturer not found, must use an existing manufacturer code/name pair with this API.")
public class ManufacturerNotFoundException extends RuntimeException {

    public ManufacturerNotFoundException() {
    }

    public ManufacturerNotFoundException(String message) {
        super(message);
    }
}
