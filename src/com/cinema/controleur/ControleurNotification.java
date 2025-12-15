package com.cinema.controleur;

<<<<<<< HEAD
=======
/**
 * ControleurNotification
 * Membre 6 - Contrôleur
 */
>>>>>>> 94980ff7fd64e952ad36023a89fb569a76ed5df2
import com.cinema.modele.Reservation;
import com.cinema.vue.VueNotification;
import com.cinema.patrons.observateur.*;

public class ControleurNotification {

<<<<<<< HEAD
    private NotificationManager manager;
    private VueNotification vue;

    public ControleurNotification() {
        manager = new NotificationManager();
        vue = new VueNotification();

        manager.registerObserver(new EmailNotifier());
        manager.registerObserver(new SMSNotifier());
    }

    public void envoyerNotification(Reservation reservation, String eventType) {
        manager.notifyObservers(reservation, eventType);
        vue.afficherNotification(
                "Notification envoyée pour l’événement : " + eventType
        );
    }
}

=======
    private NotificationManager notificationManager;
    private VueNotification vue;

    public ControleurNotification() {
        notificationManager = new NotificationManager();
        vue = new VueNotification();

        notificationManager.registerObserver(new EmailNotifier());
        notificationManager.registerObserver(new SMSNotifier());

    }
    public void envoyerNotification(Reservation reservation, String eventType) {
        notificationManager.notifyObservers(reservation, eventType);
        vue.afficherNotification("Notification envoyée pour l’événement : " + eventType);
    }
}
>>>>>>> 94980ff7fd64e952ad36023a89fb569a76ed5df2
