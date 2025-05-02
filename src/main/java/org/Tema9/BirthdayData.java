package org.Tema9;

import java.time.LocalDate;

public class BirthdayData {

    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;

    public BirthdayData(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
