package com.cinema.controleur;

/**
 * ControleurPaiement
 * Membre 3 - Contrôleur
 */

import com.cinema.modele.Transaction;
import com.cinema.patrons.strategie.paiement.PaymentDetails;
import com.cinema.patrons.strategie.paiement.PaymentStrategy;
import com.cinema.patrons.strategie.paiement.CreditCardPayment;
import com.cinema.patrons.strategie.paiement.PayPalPayment;
import com.cinema.patrons.strategie.paiement.CashPayment;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
/**
 * ControleurPaiement
 * Membre 3 - Controller
 *
 * Responsibilities:
 * - Selects the correct PaymentStrategy based on method
 * - Executes payment
 * - Builds Transaction with context (user, reservation, timestamp)
 * - Delegates notifications and reservation updates (future steps)
 */

public class ControleurPaiement {

    // Map of available strategies
    private final Map<String, PaymentStrategy> strategies = new HashMap<>();

    public ControleurPaiement() {
        // Register strategies
        strategies.put("CARD", new CreditCardPayment());
        strategies.put("PAYPAL", new PayPalPayment());
        strategies.put("CASH", new CashPayment());
    }
/**
 * Main method called by VuePaiement.
 * @param amount        Final amount to charge
 * @param details       PaymentDetails collected from the view
 * @param reservationId Reservation being paid
 * @param userId        User making the payment
 * @return Transaction object with outcome
 */
public Transaction payer(double amount, PaymentDetails details, String reservationId, String userId) {
    // Pick strategy based on method
    PaymentStrategy strategy = strategies.get(details.getMethod());

    Transaction tx;
    if (strategy == null) {
        // Fallback if method not found
        tx = new Transaction();
        tx.setId(UUID.randomUUID().toString());
        tx.setAmount(amount);
        tx.setMethod(details.getMethod());
        tx.setReservationId(reservationId);
        tx.setUserId(userId);
        tx.setSuccess(false);
        tx.setTimestamp(LocalDateTime.now());
        tx.setReference("NO-STRATEGY");
        return tx;
    }
    // Execute strategy
    tx = strategy.processPayment(amount, details);

    // Fill context
    tx.setReservationId(reservationId);
    tx.setUserId(userId);
    tx.setTimestamp(LocalDateTime.now());

    // Ensure transaction has an ID
    if (tx.getId() == null) {
        tx.setId(UUID.randomUUID().toString());
    }

    // TODO: Notify observers (Member 6)
    // TODO: Update reservation status (Member 5)

    return tx;
}
}

