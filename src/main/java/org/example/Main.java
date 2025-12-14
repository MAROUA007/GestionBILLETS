package main.java.org.example;

import com.cinema.controleur.ControleurNotification;


import com.cinema.controleur.ControleurReservation;
import com.cinema.modele.Utilisateur;
import com.cinema.modele.Reservation;
import com.cinema.patrons.composition.SingleTicket;
import com.cinema.patrons.composition.TicketPackage;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== TEST DU MODULE COMPOSITION ===\n");

        Utilisateur utilisateur = new Utilisateur("client123", "Jean Dupont");

        ControleurReservation controleur = new ControleurReservation();



        // Simulation
        ControleurNotification notifController = new ControleurNotification();
        Reservation reservation = new Reservation();

        System.out.println("--- Test 1 : Billet simple ---");
        Reservation reservationSimple = controleur.creerReservationSimple(
                utilisateur,
                "Avengers: Endgame",
                "A12",
                12.5,
                "2025-04-15 20:00"
        );
        reservationSimple.afficherDetails();


        notifController.envoyerNotification(reservation, "CONFIRMED");

        System.out.println("\n--- Test 2 : Forfait famille ---");
        Reservation reservationForfait = controleur.creerReservationForfait(
                utilisateur,
                "Forfait Famille",
                0.15
        );


        controleur.ajouterTicketAuForfait(
                reservationForfait.getReservationId(),
                new SingleTicket("Film A", "B1", 10, "2025-04-16 18:00")
        );

        reservationForfait.afficherDetails();

        System.out.println("\n=== TESTS TERMINÉS ===");
    }

}



