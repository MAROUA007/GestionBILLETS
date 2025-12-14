package patrons.strategie.tarification;

public class GroupPricing implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice, int attendeeCount) {
        double total = basePrice * attendeeCount;
        
        // 30% de réduction pour 5+ personnes
        if (attendeeCount >= 5) {
            return total * 0.70;
        }
        return total;
    }
}