package com.cinema.controleur;

import com.cinema.modele.Reservation;
import com.cinema.vue.VueNotification;
import com.cinema.patrons.observateur.*;

public class ControleurNotification {

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

