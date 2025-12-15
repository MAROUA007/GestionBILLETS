package com.cinema.vue;

/**
 * VuePaiement
 * Membre 3 - Vue
 */
import com.cinema.controleur.ControleurPaiement;
import com.cinema.modele.Transaction;
import com.cinema.patrons.strategie.paiement.PaymentDetails;

import java.util.Scanner;
/**
 * VuePaiement (View) is responsible for:
 * - Asking the user for payment method and details
 * - Delegating the action to ControleurPaiement
 * - Displaying the Transaction result (success/failure, id, amount)
 *
 * It contains no business logic; all processing happens in the controller/strategies.
 */

public class VuePaiement {

    private final ControleurPaiement controleurPaiement;
    private final Scanner scanner;

    public VuePaiement(ControleurPaiement controleurPaiement) {
        this.controleurPaiement = controleurPaiement;
        this.scanner = new Scanner(System.in);

    }

/**
 * Entry point to run the payment interaction from the console.
 * @param reservationId The reservation to pay (provided by Reservation flow).
 * @param userId        The current user id (provided by UserManager/Controller).
 * @param amount        The final amount computed by pricing.
 */

public void afficherEtPayer(String reservationId, String userId, double amount) {
    System.out.println("=== Paiement Reservation " + reservationId + " ===");
    System.out.println("Montant à payer: " + amount + " DZD");
    System.out.println("Choisissez la méthode de paiement:");
    System.out.println("1) Carte (CARD)");
    System.out.println("2) PayPal (PAYPAL)");
    System.out.println("3) Espèces (CASH)");
    System.out.print("Votre choix (1/2/3): ");

    String choix = scanner.nextLine().trim();
    String method = mapChoixToMethod(choix);
    if (method == null) {
        System.out.println("Méthode invalide. Annulation.");
        return;
    }

    PaymentDetails details = collectDetails(method);
    details.setMethod(method);

    // Delegate to the controller
    Transaction tx = controleurPaiement.payer(amount, details, reservationId, userId);

    // Display the result
    afficherResultat(tx);
}

    private String mapChoixToMethod(String choix) {
        switch (choix) {
            case "1": return "CARD";
            case "2": return "PAYPAL";
            case "3": return "CASH";
            default: return null;
        }
    }

    /**
     * Collects method-specific details from the user.
     */
    private PaymentDetails collectDetails(String method) {
        PaymentDetails details = new PaymentDetails();
        if ("CARD".equals(method)) {
            System.out.print("Numéro de carte: ");
            details.setCardNumber(scanner.nextLine().trim());

            System.out.print("Nom du titulaire: ");
            details.setHolderName(scanner.nextLine().trim());

            System.out.print("Mois d'expiration (MM): ");
            details.setExpiryMonth(scanner.nextLine().trim());

            System.out.print("Année d'expiration (YY ou YYYY): ");
            details.setExpiryYear(scanner.nextLine().trim());

            System.out.print("CVV: ");
            details.setCvv(scanner.nextLine().trim());
        } else if ("PAYPAL".equals(method)) {
            System.out.print("Email PayPal: ");
            details.setPaypalEmail(scanner.nextLine().trim());
        } else if ("CASH".equals(method)) {
            System.out.println("Paiement en espèces sélectionné. Aucun détail supplémentaire requis.");
        }
        return details;
    }

    /**
     * Prints a friendly summary of the transaction outcome.
     */
    private void afficherResultat(Transaction tx) {
        System.out.println("\n=== Résultat du Paiement ===");
        System.out.println("Transaction ID: " + tx.getId());
        System.out.println("Méthode: " + tx.getMethod());
        System.out.println("Montant: " + tx.getAmount() + " DZD");
        System.out.println("Réservation: " + tx.getReservationId());
        System.out.println("Utilisateur: " + tx.getUserId());
        System.out.println("Horodatage: " + tx.getTimestamp());
        System.out.println("Référence: " + tx.getReference());
        System.out.println("Statut: " + (tx.isSuccess() ? "SUCCÈS" : "ÉCHEC"));
        System.out.println("============================\n");
    }
}

