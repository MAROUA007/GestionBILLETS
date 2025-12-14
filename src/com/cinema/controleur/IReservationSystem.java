
package com.cinema.controleur;

import com.cinema.modele.Reservation;
import com.cinema.modele.Utilisateur;
import com.cinema.patrons.composition.TicketComponent;

public interface IReservationSystem {
    Reservation creerReservation(Utilisateur utilisateur, TicketComponent ticket);
    double calculerTotal(Reservation reservation);
    void annulerReservation(String reservationId);
    Reservation getReservation(String reservationId);
}