package com.cinema.patrons.observateur;

/**
 * BookingSubject
 * Interface - Membre 6
 */
import com.cinema.modele.Reservation;

public interface BookingSubject {
    // TODO: ajouter attributs et méthodes
    void registerObserver(BookingObserver observer);
    void removeObserver(BookingObserver observer);
    void notifyObservers(Reservation reservation, String eventType);
}
