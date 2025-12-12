package com.cinema.patrons.observateur;

/**
 * NotificationManager
 * Membre 6
 */
import com.cinema.modele.Reservation;
import java.util.ArrayList;
import java.util.List;

public class NotificationManager implements BookingSubject{
    // TODO: ajouter attributs et méthodes
    private List<BookingObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(BookingObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(BookingObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Reservation reservation, String eventType) {
        for (BookingObserver observer : observers) {
            observer.update(reservation, eventType);
        }
    }
}
