package org.Tema4;

public interface PhoneOperations {

    void addContact(String id, String phoneNumber, String firstName, String lastName);

    Contact getFirstContact();

    Contact getLastContact();

    void sendSMS(String phoneNumber, String message);

    String getFirstMessage(String phoneNumber);

    String getSecondMessage(String phoneNumber);

    void call(String phoneNumber);

    void viewHistory();
}
