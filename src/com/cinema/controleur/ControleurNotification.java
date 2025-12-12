package com.cinema.controleur;

/**
 * ControleurNotification
 * Membre 6 - Contrôleur
 */
import com.cinema.modele.Reservation;
import com.cinema.vue.VueNotification;
import com.cinema.patrons.observateur.*;

public class ControleurNotification {

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
