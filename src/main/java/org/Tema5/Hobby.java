package org.Tema5;

import java.util.List;

public class Hobby {

    final private String name;
    final private int frequency;
    final private List<Address> locations;

    public Hobby(String name, int frequency, List<Address> locations) {
        this.name = name;
        this.frequency = frequency;
        this.locations = locations;
    }

    public String getName() {
        return name;
    }


    public List<Address> getLocations() {
        return locations;
    }

    @Override
    public String toString() {
        return name + " (" + frequency + " times a week)";
    }
}
