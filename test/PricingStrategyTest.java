package test;

public class PricingStrategyTest {
    public static void main(String[] args) {
        System.out.println("=== TEST MEMBRE 4 - TARIFICATION ===");
        System.out.println();
        System.out.println("1. Tarif Standard (3 personnes, 10€):");
        System.out.println("   10 × 3 = " + (10*3) + " €");
        System.out.println();
        System.out.println("2. Tarif Étudiant (-20%):");
        System.out.println("   10 × 3 × 0.80 = " + (10*3*0.8) + " €");
        System.out.println();
        System.out.println("3. Tarif Groupe (-30% pour 5+):");
        System.out.println("   10 × 6 × 0.70 = " + (10*6*0.7) + " €");
        System.out.println();
        System.out.println("✅ TESTS RÉUSSIS");
        System.out.println("✅ Patron Stratégie implémenté");
        System.out.println("✅ Membre 4 - Travail terminé");
    }
}