package com.cinema.patrons.observateur;

/**
 * BookingObserver
 * Interface - Membre 6
 */
import com.cinema.modele.Reservation ;

public interface BookingObserver {
   void update(Reservation reservation , String eventType); // TODO: ajouter attributs et méthodes
}
