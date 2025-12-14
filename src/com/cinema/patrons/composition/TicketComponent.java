package com.cinema.patrons.composition;



public class TicketComponent {
    // TODO: ajouter attributs et méthodes

public abstract class TicketComponent {
    public abstract double getPrice();
    public abstract String getDescription();
    public abstract String getType();

    public void display() {
        System.out.println(getDescription() + " | Prix : " + getPrice() + "DZD");
    }
}
}

