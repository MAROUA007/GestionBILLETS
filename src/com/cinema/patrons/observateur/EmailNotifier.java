package com.cinema.patrons.observateur;

/**
 * EmailNotifier
 * Membre 6
 */
import com.cinema.modele.Reservation;

public class EmailNotifier implements BookingObserver{

    @Override
    public void update(Reservation reservation, String eventType) {
        System.out.println("📧 Email : Réservation n°" + reservation.getId() + " | Événement : " + eventType );
    }
}
