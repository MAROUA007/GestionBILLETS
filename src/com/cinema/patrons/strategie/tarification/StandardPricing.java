package patrons.strategie.tarification;

public class StandardPricing implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice, int attendeeCount) {
        return basePrice * attendeeCount;
    }
}