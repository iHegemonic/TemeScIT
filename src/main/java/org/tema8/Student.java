package org.tema8;

import java.time.LocalDate;
import java.time.Period;

public class Student {

    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    private final String gender;
    private final String id;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, String gender, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.id = id;

        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("You must have a first name.");
        }

        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("You must have a last name.");
        }

        int currentYear = LocalDate.now().getYear();
        int maxYear = currentYear - 18;
        if (dateOfBirth.getYear() < 1900 || dateOfBirth.getYear() > maxYear) {
            throw new IllegalArgumentException("Date of birth must be between 1900 and " + maxYear);
        }

        if (gender == null || (!gender.equalsIgnoreCase("male")
                && !gender.equalsIgnoreCase("female"))) {
            throw new IllegalArgumentException("Gender must be either male or female.");
        }

        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be empty.");

        }
    }

    public String getId() {
        return id;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Age='" + getAge() + '\'' +
                ", gender='" + gender + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
