package com.cinema.patrons.observateur;

import com.cinema.modele.Reservation;

public interface BookingSubject {
    void registerObserver(BookingObserver observer);
    void removeObserver(BookingObserver observer);
    void notifyObservers(Reservation reservation, String eventType);
}

