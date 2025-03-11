package org.Tema4;

import java.util.ArrayList;
import java.util.List;

public abstract class Phone implements PhoneOperations {

    private String manufacturer;
    private String model;
    private final int batteryLife;
    private int currentBattery;
    private String color;
    private String material;
    private String IMEI;

    private List<Contact> contacts;
    private List<Message> messages;
    private List<String> callHistory;

    public Phone(String manufacturer, String model, int batteryLife, String color, String material, String IMEI) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.batteryLife = batteryLife;
        this.color = color;
        this.material = material;
        this.IMEI = IMEI;
        this.contacts = new ArrayList<>();
        this.messages = new ArrayList<>();
        this.callHistory = new ArrayList<>();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public int getCurrentBattery() {
        return currentBattery;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    public String getIMEI() {
        return IMEI;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public List<String> getCallHistory() {
        return callHistory;
    }

    private void reduceBattery(int amount) {
        if (batteryLife >= amount) {
            currentBattery -= amount;
        } else {
            System.out.println("Battery low");
        }
    }

    @Override
    public void addContact(String id, String phoneNumber, String firstName, String lastName) {
        Contact contact = new Contact(id, phoneNumber, firstName, lastName);
        contacts.add(contact);
        System.out.println("Added Contact: " + contact);
    }

    @Override
    public Contact getLastContact() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return null;
        }
        Contact lastContact = contacts.get(contacts.size() - 1);
        System.out.println("Last contact: " + lastContact);
        return lastContact;
    }

    @Override
    public Contact getFirstContact(){
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return null;
        }
        Contact firstContact = contacts.get(0);
        System.out.println("First contact: " + firstContact);
        return firstContact;
    }

    public void sendSMS(String phoneNumber, String message) {
        if (message.length() > 500) {
            System.out.println("Could not send: Message exceeds 500 characters.");
        }
        if (currentBattery < 1) {
            System.out.println("Error: Not enough battery to send a message.");
        }

        boolean contactOnList = false;
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                contactOnList = true;
                break;
            }
        }

        if (!contactOnList) {
            System.out.println("Contact couldn't be found.");
        }

        reduceBattery(1);
        messages.add(new Message(phoneNumber, message));
        System.out.println("Message sent to " + phoneNumber + ": " + message);

    }

    private String getMessageByIndex(String phoneNumber, int index) {
        List<Message> filteredMessages = new ArrayList<>();
        for (Message msg : messages) {
            if (msg.getPhoneNumber().equals(phoneNumber)) {
                filteredMessages.add(msg);
            }
        }
       if (filteredMessages.size() > index) {
           return filteredMessages.get(index).getContent();
       } else {
           return "No message found";
       }
    }

    @Override
    public String getFirstMessage(String phoneNumber) {
        return getMessageByIndex(phoneNumber, 0);
    }

    @Override
    public String getSecondMessage(String phoneNumber) {
        return getMessageByIndex(phoneNumber, 1);
    }

    @Override
    public void call(String phoneNumber) {
        if (currentBattery < 2) {
            System.out.println("Error: Not enough battery to make a call.");
        }
        reduceBattery(2);
        callHistory.add("Call made to " + phoneNumber);
        System.out.println("Calling " + phoneNumber + "...");
    }

    @Override
    public void viewHistory() {
        System.out.println("Call History:");
        for (String call : callHistory) {
            System.out.println(call);
        }
    }

@Override
    public String toString() {
        return manufacturer + " " + model + " (IMEI: " + IMEI + ", Battery: " + currentBattery + "/"
                + batteryLife + " hrs, Color: " + color + ", Material: " + material + ")";
}

    }

