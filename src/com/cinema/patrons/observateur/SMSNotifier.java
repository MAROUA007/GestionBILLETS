package com.cinema.patrons.observateur;

<<<<<<< HEAD
import com.cinema.modele.Reservation;

public class SMSNotifier implements BookingObserver {

    @Override
    public void update(Reservation reservation, String eventType) {
        System.out.println("📱 SMS envoyé | Réservation "
                + reservation.getId() + " | " + eventType);
=======
/**
 * SMSNotifier
 * Membre 6
 */
import com.cinema.modele.Reservation;

public class SMSNotifier implements BookingObserver{

    @Override
    public void update(Reservation reservation, String eventType) {
        System.out.println("📱 SMS : Réservation n°" + reservation.getId() + " | Événement : " + eventType);
>>>>>>> 94980ff7fd64e952ad36023a89fb569a76ed5df2
    }
}
