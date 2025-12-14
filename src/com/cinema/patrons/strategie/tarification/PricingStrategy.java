package patrons.strategie.tarification;

public interface PricingStrategy {
    double calculatePrice(double basePrice, int attendeeCount);
}