package org.Tema4;

public abstract class Apple extends Phone {
    public Apple(String model, int batteryLife, String color, String material, String IMEI) {
        super("Apple", model, batteryLife, color, material, IMEI);
    }

    @Override
    public void sendSMS(String phoneNumber, String message) {
        super.sendSMS(phoneNumber, message);
    }

}
