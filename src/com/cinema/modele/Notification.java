package com.cinema.modele;

public class Notification {

    private String message;
    private String type; // EMAIL ou SMS

    public Notification(String message, String type) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }
}

