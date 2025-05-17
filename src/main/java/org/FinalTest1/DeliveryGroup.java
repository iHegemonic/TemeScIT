package org.FinalTest1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class DeliveryGroup implements Runnable {

    private String location;
    private LocalDate date;
    private List<Package> packages;

    public DeliveryGroup(String location, LocalDate date, List<Package> packages) {
        this.location = location;
        this.date = date;
        this.packages = packages;
    }

    public double getGroupValue() {
        return packages.stream().mapToDouble(Package::getValue).sum();

    }

    public double getRevenue() {
        return packages.get(0).getDistance();
    }

    @Override
    public void run () {
        int distance = packages.get(0).getDistance();
        try {
            System.out.printf("Time: %s - Delivering for \"%s\" on %s in \"%d\" seconds.%n", LocalTime.now(), location,
            date, distance);
            Thread.sleep(distance * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
