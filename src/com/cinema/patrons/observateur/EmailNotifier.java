package com.cinema.patrons.observateur;

<<<<<<< HEAD
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
=======
/**
 * EmailNotifier
 * Membre 6
 */
import com.cinema.modele.Reservation;

public class EmailNotifier implements BookingObserver{

    @Override
    public void update(Reservation reservation, String eventType) {
        System.out.println("📧 Email : Réservation n°" + reservation.getId() + " | Événement : " + eventType );
>>>>>>> 94980ff7fd64e952ad36023a89fb569a76ed5df2
    }
}
