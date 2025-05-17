package org.FinalTest1;

import java.time.LocalDate;

public class Package {

    private String location;
    private int distance;
    private double value;
    private LocalDate deliveryDate;

    public Package(String location, int distance, double value, LocalDate deliveryDate) {
        this.location = location;
        this.distance = distance;
        this.value = value;
        this.deliveryDate = deliveryDate;
    }

    public String getLocation() {
        return location;
    }

    public int getDistance() {
        return distance;
    }

    public double getValue() {
        return value;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }



}
