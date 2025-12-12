package com.cinema.patrons.observateur;

import com.cinema.modele.Reservation;
import java.util.ArrayList;
import java.util.List;

public class NotificationManager implements BookingSubject {

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
        for (BookingObserver obs : observers) {
            obs.update(reservation, eventType);
        }
    }
}
