package com.udacity.vehicles.domain;

import com.udacity.vehicles.validation.OnCreateOrUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * Stores information about a given location.
 * Latitude and longitude must be provided, while other
 * location information must be gathered each time from
 * the maps API.
 */
@Embeddable
public class Location {

    @NotNull
    @ApiModelProperty(example = "40.73061")
    private Double lat;

    @NotNull
    @ApiModelProperty(example = "-73.935242")
    private Double lon;

    @Transient
    @Null(groups = OnCreateOrUpdate.class)
    @ApiModelProperty(hidden = true)
    private String address;

    @Transient
    @Null(groups = OnCreateOrUpdate.class)
    @ApiModelProperty(hidden = true)
    private String city;

    @Transient
    @Null(groups = OnCreateOrUpdate.class)
    @ApiModelProperty(hidden = true)
    private String state;

    @Transient
    @Null(groups = OnCreateOrUpdate.class)
    @ApiModelProperty(hidden = true)
    private String zip;

    public Location() {
    }

    public Location(Double lat, Double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
