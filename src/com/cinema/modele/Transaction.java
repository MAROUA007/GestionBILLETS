package com.cinema.modele;
/**
 * Transaction
 * Membre 3 - Couche Modèle
 */

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Transaction represents a single payment attempt/result in the system.
 * It links the payment to the user (userId) and the reservation (reservationId),
 * and records outcome details (amount, method, success, timestamp).
 *
 * This is a Model class (MVC: M), so it contains data and simple validation,
 * but no UI or controller logic.
 */




public class Transaction {
    // ------------------------
    // Core identifiers & context
    // ------------------------

    /**
     * Unique identifier for THIS transaction (receipt-like).
     * Generated when processing the payment (e.g., UUID or a formatted string).
     * Example: "TX-2025-00123".
     */
    private String id;
    /**
     * The user who initiated the payment.
     * Comes from Member 2's UserManager / Utilisateur model (e.g., currentUser.getId()).
     * Example: "USR-42".
     */
    private String userId;
    /**
     * The reservation this payment applies to.
     * Comes from Member 5's Reservation model (e.g., reservation.getId()).
     * Example: "RES-88".
     */
    private String reservationId;

    // ------------------------
    // Payment details
    // ------------------------
    /**
     * Final amount to charge.
     * Provided by Member 4's tarification (PricingStrategy via ControleurTarification).
     */
    private double amount;
    /**
     * Payment method used: "CARD", "PAYPAL", or "CASH".
     * Selected in the payment view/controller, mapped to a PaymentStrategy implementation.
     */
    private String method;

    /**
     * Outcome flag: true if payment succeeded, false otherwise.
     * Set by the PaymentStrategy after processing.
     */
    private boolean success;

    /**
     * When the transaction was recorded (system time).
     * Set when the controller finishes processing (post-strategy).
     */
    private LocalDateTime timestamp;

    /**
     * Optional reference/authorization code from the strategy (for logs/receipts).
     * Example: "AUTH-1734165920" or "PP-1734165920".
     */
    private String reference;
// ------------------------
    // Constructors
    // ------------------------

    /**
     * No-arg constructor keeps frameworks/serializers happy.
     * Use setters to fill fields after payment.
     */
    public Transaction() {
    }
    /**
     * Convenience constructor to set the most critical fields at creation time.
     * You can extend this as needed.
     */
    public Transaction(String id, String userId, String reservationId,
                       double amount, String method, boolean success,
                       LocalDateTime timestamp, String reference) {
        this.id = id;
        this.userId = userId;
        this.reservationId = reservationId;
        this.amount = amount;
        this.method = method;
        this.success = success;
        this.timestamp = timestamp;
        this.reference = reference;
    }

// ------------------------
    // Getters and setters (encapsulation)
    // ------------------------

    /** Unique transaction id (receipt) */
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    /** User id (who pays) */
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /** Reservation id (what is being paid) */
    public String getReservationId() {
        return reservationId;
    }
    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    /** Final price charged */
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /** Method used: "CARD", "PAYPAL", "CASH" */
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    /** Outcome of the payment */
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /** When the transaction was created/recorded */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    /** Optional external reference for audits */
    public String getReference() {
        return reference;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }

// ------------------------
    // Utility methods (optional but useful)
    // ------------------------

    /**
     * For readable logs and debugging in console outputs.
     */
    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", reservationId='" + reservationId + '\'' +
                ", amount=" + amount +
                ", method='" + method + '\'' +
                ", success=" + success +
                ", timestamp=" + timestamp +
                ", reference='" + reference + '\'' +
                '}';
    }
    /**
     * Equality based on transaction id (typical for entities with unique ids).
     * Adjust if you need stronger equality rules.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }




}
