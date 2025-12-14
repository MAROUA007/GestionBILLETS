package com.cinema.modele;


import com.cinema.patrons.composition.TicketComponent;

/**
 * Reservation
 * Membre 5 - Couche Modèle
 */

public class Reservation {

    public String getId() {
    }

    private String reservationId;
    private Utilisateur utilisateur;
    private TicketComponent ticketComponent;
    private String dateReservation;
    private String status;

    public Reservation(String reservationId, Utilisateur utilisateur,
                       TicketComponent ticketComponent, String dateReservation) {
        this.reservationId = reservationId;
        this.utilisateur = utilisateur;
        this.ticketComponent = ticketComponent;
        this.dateReservation = dateReservation;
        this.status = "CONFIRME";
    }


    public double getTotalPrice() {
        return ticketComponent.getPrice();
    }


    public void afficherDetails() {
        System.out.println("=== Réservation N°" + reservationId + " ===");
        System.out.println("Client: " + utilisateur.getNomComplet());
        System.out.println("Date: " + dateReservation);
        System.out.println("Statut: " + statut);
        System.out.println("--- Contenu ---");
        ticketComponent.display();
        System.out.println("Total: " + getPrixTotal() + "DZD");
        System.out.println("================");
    }

    public String getReservationId() { return reservationId; }
    public Utilisateur getUtilisateur() { return utilisateur; }
    public TicketComponent getTicketComponent() { return ticketComponent; }
    public String getDateReservation() { return dateReservation; }
    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
}