package com.cinema.patrons.observateur;

import com.cinema.modele.Reservation;

public class EmailNotifier implements BookingObserver {

    @Override
    public void update(Reservation reservation, String eventType) {
        System.out.println("📧 Email envoyé | Réservation "
                + reservation.getId() + " | " + eventType);
    }
}
