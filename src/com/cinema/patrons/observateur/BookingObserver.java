package com.cinema.patrons.observateur;

import com.cinema.modele.Reservation;

public interface BookingObserver {
    void update(Reservation reservation, String eventType);
}
