package org.Tema4;

public class Message {
    private String phoneNumber;
    private String content;

    public Message(String content, String phoneNumber) {
        this.content = content;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "To: " + phoneNumber + " - " + content;
    }
}
