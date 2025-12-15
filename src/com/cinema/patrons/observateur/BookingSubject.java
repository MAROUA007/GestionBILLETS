package com.cinema.patrons.observateur;

<<<<<<< HEAD
import com.cinema.modele.Reservation;

public interface BookingSubject {
=======
/**
 * BookingSubject
 * Interface - Membre 6
 */
import com.cinema.modele.Reservation;

public interface BookingSubject {
    // TODO: ajouter attributs et méthodes
>>>>>>> 94980ff7fd64e952ad36023a89fb569a76ed5df2
    void registerObserver(BookingObserver observer);
    void removeObserver(BookingObserver observer);
    void notifyObservers(Reservation reservation, String eventType);
}
