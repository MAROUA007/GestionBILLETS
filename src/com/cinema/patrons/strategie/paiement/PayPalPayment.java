package com.cinema.patrons.strategie.paiement;

/**
 * PayPalPayment
 * Membre 3
 */

import com.cinema.modele.Transaction;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * PayPalPayment
 * Membre 3 - Strategy Implementation
 *
 * Simulates payment processing with PayPal.
 * Performs simple validation on the email address.
 */

public class PayPalPayment implements PaymentStrategy {

    @Override
    public Transaction processPayment(double amount, PaymentDetails details) {
        Transaction tx = new Transaction();
        tx.setId(UUID.randomUUID().toString());   // unique transaction ID
        tx.setAmount(amount);
        tx.setMethod("PAYPAL");
        tx.setTimestamp(LocalDateTime.now());

        // Basic validation: email must contain '@'
        if (details.getPaypalEmail() != null && details.getPaypalEmail().contains("@")) {
            tx.setSuccess(true);
            tx.setReference("PAYPAL-AUTH-" + System.currentTimeMillis());
        } else {
            tx.setSuccess(false);
            tx.setReference("PAYPAL-FAILED");
        }

        return tx;
    }
}

