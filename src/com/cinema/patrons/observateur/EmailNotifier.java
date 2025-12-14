package com.cinema.patrons.observateur;

import com.cinema.modele.Reservation;
import org.jetbrains.annotations.NotNull;

public class EmailNotifier implements BookingObserver {

    public void update() {
        update(null, null);
    }

    @Override
    public void update(@NotNull Reservation reservation, String eventType) {
        System.out.println("📧 Email envoyé | Réservation "
                + reservation.getId() + " | " + eventType);
    }
}
