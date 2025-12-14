package patrons.strategie.tarification;

public class StudentPricing implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice, int attendeeCount) {
        // 20% de réduction
        return basePrice * attendeeCount * 0.80;
    }
}