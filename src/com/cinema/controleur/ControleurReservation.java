package com.cinema.controleur;


public class ControleurReservation {
}


import com.cinema.modele.Reservation;
import com.cinema.modele.Utilisateur;
import com.cinema.patrons.composition.SingleTicket;
import com.cinema.patrons.composition.TicketComponent;
import com.cinema.patrons.composition.TicketPackage;

import java.util.HashMap;
import java.util.Map;

public class ControleurReservation {
    private Map<String, Reservation> reservations = new HashMap<>();

    public Reservation creerReservation(Utilisateur utilisateur, TicketComponent ticket) {
        String reservationId = "RES" + System.currentTimeMillis();
        Reservation reservation = new Reservation(
                reservationId,
                utilisateur,
                ticket,
                java.time.LocalDate.now().toString()
        );
        reservations.put(reservationId, reservation);
        System.out.println("✅ Réservation créée: " + reservationId);
        return reservation;
    }

    public Reservation creerReservationSimple(Utilisateur utilisateur,
                                              String nomEvenement,
                                              String place,
                                              double prix,
                                              String heure) {
        SingleTicket ticket = new SingleTicket(nomEvenement, place, prix, heure);
        return creerReservation(utilisateur, ticket);
    }

    public Reservation creerReservationForfait(Utilisateur utilisateur,
                                               String nomForfait,
                                               double reduction) {
        TicketPackage ticketPackage = new TicketPackage(nomForfait, reduction);
        return creerReservation(utilisateur, ticketPackage);
    }

    public void ajouterTicketAuForfait(String reservationId, TicketComponent ticket) {
        Reservation reservation = reservations.get(reservationId);
        if (reservation != null &&
                reservation.getTicketComponent() instanceof TicketPackage) {
            TicketPackage ticketPackage = (TicketPackage) reservation.getTicketComponent();
            ticketPackage.addComponent(ticket);
            System.out.println(" Ticket ajouté au forfait " + reservationId);
        } else {
            System.out.println("Impossible d'ajouter au forfait");
        }
    }

    public void annulerReservation(String reservationId) {
        Reservation reservation = reservations.get(reservationId);
        if (reservation != null) {
            reservation.setStatut("ANNULEE");
            System.out.println(" Réservation annulée: " + reservationId);
        }
    }

    public Reservation getReservation(String reservationId) {
        return reservations.get(reservationId);
    }

    public double calculerTotal(Reservation reservation) {
        return reservation.getPrixTotal();
    }
}

