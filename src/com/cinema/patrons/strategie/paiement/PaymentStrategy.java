package com.cinema.patrons.strategie.paiement;

/**
 * PaymentStrategy
 * Interface - Membre 3
 */

import com.cinema.modele.Transaction;

/**
 * PaymentStrategy
 * Membre 3 - Strategy Interface
 *
 * Defines the contract for all payment methods.
 * Each implementation (CreditCardPayment, PayPalPayment, CashPayment)
 * must process a payment and return a Transaction.
 */

public class PaymentStrategy {
    /**
     * Process a payment attempt.
     *
     * @param amount  The amount to charge
     * @param details The payment details collected from the view
     * @return Transaction object with outcome (success/failure, reference, etc.)
     */
    Transaction processPayment(double amount, PaymentDetails details);

}
