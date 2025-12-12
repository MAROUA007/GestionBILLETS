package com.cinema;

import com.cinema.controleur.ControleurNotification;
import com.cinema.modele.Reservation;
/**
 * Main
 * Point d'entrée principal
 */
public class Main {
    // TODO: ajouter attributs et méthodes
    public static void main(String[] args) {

        // Simulation
        ControleurNotification notifController = new ControleurNotification();
        Reservation reservation = new Reservation();

        notifController.envoyerNotification(reservation, "CONFIRMED");
    }
}
