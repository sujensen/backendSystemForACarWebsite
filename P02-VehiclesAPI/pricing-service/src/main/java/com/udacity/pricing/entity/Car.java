package com.udacity.pricing.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/*
Entity annotation is for a Java class that maps to the contents of a database table.
 */
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String currency;
    private BigDecimal price;
    private Long vehicleid;

    public Car() {
    }

    public Car(Long id, String currency, BigDecimal price, Long vehicleid) {
        this.id = id;
        this.currency = currency;
        this.price = price;
        this.vehicleid = vehicleid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getVehicleid() {
        return vehicleid;
    }

    public void setVehicleid(Long vehicleid) {
        this.vehicleid = vehicleid;
    }
}
