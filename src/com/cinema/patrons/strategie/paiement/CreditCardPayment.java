package com.cinema.patrons.strategie.paiement;

/**
 * CreditCardPayment
 * Membre 3
 */

import com.cinema.modele.Transaction;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * CreditCardPayment
 * Membre 3 - Strategy Implementation
 *
 * Simulates payment processing with a credit card.
 * Performs simple validation on card number and CVV.
 */

public class CreditCardPayment implements PaymentStrategy {

    @Override
    public Transaction processPayment(double amount, PaymentDetails details) {
        Transaction tx = new Transaction();
        tx.setId(UUID.randomUUID().toString());   // unique transaction ID
        tx.setAmount(amount);
        tx.setMethod("CARD");
        tx.setTimestamp(LocalDateTime.now());

        // Basic validation: card number length >= 12, CVV length = 3
        if (details.getCardNumber() != null && details.getCardNumber().length() >= 12 &&
                details.getCvv() != null && details.getCvv().length() == 3) {
            tx.setSuccess(true);
            tx.setReference("CARD-AUTH-" + System.currentTimeMillis());
        } else {
            tx.setSuccess(false);
            tx.setReference("CARD-FAILED");
        }

        return tx;
    }
}

