package org.Tema5;

public class Address {

   final private String street;
    final private Country country;

    public Address(String street, Country country) {
        this.street = street;
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return street + ", " + country.getName();
    }
}
