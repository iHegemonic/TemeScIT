package org.Tema4;

public class Contact {

    private String id;
    private String phoneNumber;
    private String firstName;
    private String lastName;


    public Contact(String phoneNumber, String firstName, String lastName) {
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
