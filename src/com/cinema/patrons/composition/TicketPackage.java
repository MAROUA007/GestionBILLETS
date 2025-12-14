package com.cinema.patrons.composition;
import java.util.ArrayList;
import java.util.List;


public class TicketPackage extends TicketComponent {
    private String packageName;
    private List<TicketComponent> components;
    private double discount;


    public TicketPackage(String packageName, double discount) {
        this.packageName = packageName;
        this.discount = discount;
        this.components = new ArrayList<>();
    }

    public void addComponent(TicketComponent component) {
        components.add(component); //
    }

    public void removeComponent(TicketComponent component) {
        components.remove(component);
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (TicketComponent comp : components) {
            total += comp.getPrice();
        }
        return total * (1 - discount);
    }

    @Override
    public String getDescription() {
        return "Forfait: " + packageName +
                " (" + components.size() + " éléments) | " +
                "Réduction: " + (discount * 100) + "%";
    }

    @Override
    public String getType() {
        return "PACKAGE";
    }

    public List<TicketComponent> getComponents() { return new ArrayList<>(components); }
    public String getPackageName() { return packageName; }
    public double getDiscount() { return discount; }
}

