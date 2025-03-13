package org.Tema4;

public abstract class Samsung extends Phone {
    public Samsung(String model, int batteryLife, String color, String material, String IMEI) {
        super("Samsung", model, batteryLife, color, material, IMEI);
    }

    @Override
    public void sendSMS(String phoneNumber, String message) {
        super.sendSMS(phoneNumber, message);
    }
}
