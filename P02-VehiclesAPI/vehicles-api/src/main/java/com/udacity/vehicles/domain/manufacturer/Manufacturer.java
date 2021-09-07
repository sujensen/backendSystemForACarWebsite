package com.udacity.vehicles.domain.manufacturer;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Declares class to hold car manufacturer information.
 */
@Entity
public class Manufacturer {

    @Id
    @ApiModelProperty(required = true, example="101", allowableValues = "100, 101, 102, 103, 104", value = "Accepted code/name pairs are 100/Audi, 101/Chevrolet, 102/Ford, 103/BMW, and 104/Dodge")
    private Integer code;

    @ApiModelProperty(required = true, example="Chevrolet", allowableValues = "Audi, Chevrolet, Ford, BMW, Dodge", value = "Accepted code/name pairs are 100/Audi, 101/Chevrolet, 102/Ford, 103/BMW, and 104/Dodge")
    private String name;

    public Manufacturer() { }

    public Manufacturer(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
