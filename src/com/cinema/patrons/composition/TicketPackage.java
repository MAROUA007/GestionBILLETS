package com.cinema.patrons.composition;

public class TicketPackage extends TicketComponent {
    private String packageName;
    private List<TicketComponent> components;
    private double discount;


    public TicketPackage(String packageName, double discount) {
        this.packageName = packageName;
        this.discount = discount;
        this.components = new ArrayList<>();
    }
