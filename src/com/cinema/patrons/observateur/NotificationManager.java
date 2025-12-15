package com.cinema.patrons.observateur;

<<<<<<< HEAD
=======
/**
 * NotificationManager
 * Membre 6
 */
>>>>>>> 94980ff7fd64e952ad36023a89fb569a76ed5df2
import com.cinema.modele.Reservation;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
public class NotificationManager implements BookingSubject {

=======
public class NotificationManager implements BookingSubject{
    // TODO: ajouter attributs et méthodes
>>>>>>> 94980ff7fd64e952ad36023a89fb569a76ed5df2
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
<<<<<<< HEAD
        for (BookingObserver obs : observers) {
            obs.update(reservation, eventType);
=======
        for (BookingObserver observer : observers) {
            observer.update(reservation, eventType);
>>>>>>> 94980ff7fd64e952ad36023a89fb569a76ed5df2
        }
    }
}
