package org.Tema4;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Phone phone = new SamsungGalaxyS6();

        phone.addContact("1", "phone number", "first name", "last name");

        phone.addContact("2", "second phone number", "second first name", "second last name");

        phone.getFirstContact();

        phone.getLastContact();

// send a message to the first contact from the previously listed

// max number of characters - 100

        phone.sendSMS("phone number", "message content");

        phone.getFirstMessage("phone number");

        phone.getSecondMessage("phone number");

// make a call to the second contact from the previously listed

        phone.call("second phone number");

        phone.viewHistory();

    }
}