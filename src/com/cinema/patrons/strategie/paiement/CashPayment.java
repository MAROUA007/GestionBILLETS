package com.cinema.patrons.strategie.paiement;

/**
 * CashPayment
 * Membre 3
 */
import com.cinema.modele.Transaction;
import java.time.LocalDateTime;
import java.util.UUID;
/**
 * CashPayment
 * Membre 3 - Strategy Implementation
 *
 * Simulates payment in cash at the cinema.
 * Always succeeds if the amount is positive.
 */

public class CashPayment implements PaymentStrategy {

    @Override
    public Transaction processPayment(double amount, PaymentDetails details) {
        Transaction tx = new Transaction();
        tx.setId(UUID.randomUUID().toString());   // unique transaction ID
        tx.setAmount(amount);
        tx.setMethod("CASH");
        tx.setTimestamp(LocalDateTime.now());

        // Cash payments succeed if amount > 0
        if (amount > 0) {
            tx.setSuccess(true);
            tx.setReference("CASH-" + System.currentTimeMillis());
        } else {
            tx.setSuccess(false);
            tx.setReference("CASH-FAILED");
        }

        return tx;
    }
}

