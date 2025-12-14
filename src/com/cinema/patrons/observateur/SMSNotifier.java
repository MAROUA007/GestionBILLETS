package com.cinema.patrons.observateur;

import com.cinema.modele.Reservation;

public class SMSNotifier implements BookingObserver {

    @Override
    public void update(Reservation reservation, String eventType) {
        System.out.println("📱 SMS envoyé | Réservation "
                + reservation.getId() + " | " + eventType);
    }
}
