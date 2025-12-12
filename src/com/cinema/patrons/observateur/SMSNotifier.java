package com.cinema.patrons.observateur;

/**
 * SMSNotifier
 * Membre 6
 */
import com.cinema.modele.Reservation;

public class SMSNotifier implements BookingObserver{

    @Override
    public void update(Reservation reservation, String eventType) {
        System.out.println("📱 SMS : Réservation n°" + reservation.getId() + " | Événement : " + eventType);
    }
}
