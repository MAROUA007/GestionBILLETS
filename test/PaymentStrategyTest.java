package test;

/**
 * PaymentStrategyTest
 * Test - Membre 3
 */

import com.cinema.modele.Transaction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * PaymentStrategyTest
 * Membre 3 - Unit Tests
 *
 * Tests the three payment strategies: CreditCard, PayPal, Cash.
 */

public class PaymentStrategyTest {

    @Test
    public void testCreditCardPaymentSuccess() {
        PaymentDetails details = new PaymentDetails();
        details.setCardNumber("123456789012"); // valid length
        details.setCvv("123");                 // valid CVV

        CreditCardPayment strategy = new CreditCardPayment();
        Transaction tx = strategy.processPayment(1000.0, details);

        assertTrue(tx.isSuccess(), "Credit card payment should succeed with valid details");
        assertEquals("CARD", tx.getMethod());
    }

    @Test
    public void testCreditCardPaymentFailure() {
        PaymentDetails details = new PaymentDetails();
        details.setCardNumber("123"); // too short
        details.setCvv("12");         // invalid CVV

        CreditCardPayment strategy = new CreditCardPayment();
        Transaction tx = strategy.processPayment(1000.0, details);
        assertFalse(tx.isSuccess(), "Credit card payment should fail with invalid details");
    }

    @Test
    public void testPayPalPaymentSuccess() {
        PaymentDetails details = new PaymentDetails();
        details.setPaypalEmail("user@example.com");

        PayPalPayment strategy = new PayPalPayment();
        Transaction tx = strategy.processPayment(500.0, details);

        assertTrue(tx.isSuccess(), "PayPal payment should succeed with valid email");
        assertEquals("PAYPAL", tx.getMethod());
    }

    @Test
    public void testPayPalPaymentFailure() {
        PaymentDetails details = new PaymentDetails();
        details.setPaypalEmail("invalidEmail"); // no '@'

        PayPalPayment strategy = new PayPalPayment();
        Transaction tx = strategy.processPayment(500.0, details);

        assertFalse(tx.isSuccess(), "PayPal payment should fail with invalid email");
    }
    @Test
    public void testCashPaymentSuccess() {
        PaymentDetails details = new PaymentDetails();

        CashPayment strategy = new CashPayment();
        Transaction tx = strategy.processPayment(200.0, details);

        assertTrue(tx.isSuccess(), "Cash payment should succeed if amount > 0");
        assertEquals("CASH", tx.getMethod());
    }

    @Test
    public void testCashPaymentFailure() {
        PaymentDetails details = new PaymentDetails();

        CashPayment strategy = new CashPayment();
        Transaction tx = strategy.processPayment(0.0, details);

        assertFalse(tx.isSuccess(), "Cash payment should fail if amount <= 0");
    }
}

