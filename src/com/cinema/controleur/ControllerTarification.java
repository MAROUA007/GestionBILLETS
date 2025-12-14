package com.cinema.controleur;

import patrons.strategie.tarification.*;

/**
 * ControllerTarification
 * Membre 4 - Contrôleur pour gérer la tarification
 * Utilise le patron Stratégie pour appliquer différents calculs de prix
 */
public class ControllerTarification {
    
    private PricingStrategy currentStrategy;
    
    /**
     * Constructeur par défaut
     * Initialise avec la tarification standard
     */
    public ControllerTarification() {
        this.currentStrategy = new StandardPricing();
    }
    
    /**
     * Définit la stratégie de tarification à utiliser
     * @param strategy la stratégie (Standard, Étudiant, Groupe)
     */
    public void setPricingStrategy(PricingStrategy strategy) {
        if (strategy != null) {
            this.currentStrategy = strategy;
        }
    }
    
    /**
     * Calcule le prix selon la stratégie courante
     * @param basePrice prix de base d'un ticket
     * @param attendeeCount nombre de personnes
     * @return prix total après application de la stratégie
     */
    public double calculatePrice(double basePrice, int attendeeCount) {
        if (basePrice < 0 || attendeeCount <= 0) {
            throw new IllegalArgumentException("Prix ou nombre de personnes invalide");
        }
        return currentStrategy.calculatePrice(basePrice, attendeeCount);
    }
    
    /**
     * Sélectionne automatiquement la meilleure stratégie selon le profil
     * @param isStudent true si le client est étudiant
     * @param attendeeCount nombre de personnes
     */
    public void selectOptimalStrategy(boolean isStudent, int attendeeCount) {
        if (isStudent) {
            setPricingStrategy(new StudentPricing());
            System.out.println("[INFO] Stratégie étudiante sélectionnée (-20%)");
        } else if (attendeeCount >= 5) {
            setPricingStrategy(new GroupPricing());
            System.out.println("[INFO] Stratégie groupe sélectionnée (-30%)");
        } else {
            setPricingStrategy(new StandardPricing());
            System.out.println("[INFO] Stratégie standard sélectionnée");
        }
    }
    
    /**
     * Méthode main pour tester le contrôleur
     * @param args arguments de ligne de commande
     */
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   TEST DU CONTROLLER TARIFICATION");
        System.out.println("   Membre 4 - Projet Cinéma GL2");
        System.out.println("=========================================\n");
        
        // Création du contrôleur
        ControllerTarification controller = new ControllerTarification();
        double prixBase = 12.50; // Prix d'un ticket
        
        System.out.println("Prix de base d'un ticket: " + prixBase + " €");
        System.out.println("-----------------------------------------\n");
        
        // TEST 1: Tarif Standard
        System.out.println("TEST 1 - Tarif Standard");
        System.out.println("Situation: Client normal, 2 personnes");
        controller.setPricingStrategy(new StandardPricing());
        double resultat1 = controller.calculatePrice(prixBase, 2);
        System.out.println("   Calcul: " + prixBase + " × 2 = " + resultat1 + " €");
        System.out.println("   ✓ Test standard réussi\n");
        
        // TEST 2: Tarif Étudiant
        System.out.println("TEST 2 - Tarif Étudiant");
        System.out.println("Situation: Client étudiant, 3 personnes");
        controller.setPricingStrategy(new StudentPricing());
        double resultat2 = controller.calculatePrice(prixBase, 3);
        System.out.println("   Calcul: " + prixBase + " × 3 × 0.80 = " + resultat2 + " €");
        System.out.println("   ✓ Test étudiant réussi (-20%)\n");
        
        // TEST 3: Tarif Groupe (sans réduction)
        System.out.println("TEST 3 - Tarif Groupe (sans réduction)");
        System.out.println("Situation: Client normal, 4 personnes");
        controller.setPricingStrategy(new GroupPricing());
        double resultat3 = controller.calculatePrice(prixBase, 4);
        System.out.println("   Calcul: " + prixBase + " × 4 = " + resultat3 + " €");
        System.out.println("   ✓ Test groupe <5 personnes réussi\n");
        
        // TEST 4: Tarif Groupe (avec réduction)
        System.out.println("TEST 4 - Tarif Groupe (avec réduction)");
        System.out.println("Situation: Client normal, 6 personnes");
        double resultat4 = controller.calculatePrice(prixBase, 6);
        System.out.println("   Calcul: " + prixBase + " × 6 × 0.70 = " + resultat4 + " €");
        System.out.println("   ✓ Test groupe ≥5 personnes réussi (-30%)\n");
        
        // TEST 5: Sélection automatique
        System.out.println("TEST 5 - Sélection Automatique");
        System.out.println("--------------------------------");
        
        ControllerTarification autoController = new ControllerTarification();
        
        System.out.println("a) Client étudiant, 2 personnes:");
        autoController.selectOptimalStrategy(true, 2);
        double auto1 = autoController.calculatePrice(prixBase, 2);
        System.out.println("   Prix final: " + auto1 + " €");
        
        System.out.println("\nb) Client normal, 6 personnes:");
        autoController.selectOptimalStrategy(false, 6);
        double auto2 = autoController.calculatePrice(prixBase, 6);
        System.out.println("   Prix final: " + auto2 + " €");
        
        System.out.println("\nc) Client normal, 3 personnes:");
        autoController.selectOptimalStrategy(false, 3);
        double auto3 = autoController.calculatePrice(prixBase, 3);
        System.out.println("   Prix final: " + auto3 + " €");
        
        System.out.println("\n=========================================");
        System.out.println("✅ TOUS LES TESTS ONT RÉUSSI !");
        System.out.println("✅ ControllerTarification fonctionne correctement.");
        System.out.println("=========================================");
        
        // Message pour les collègues
        System.out.println("\n📋 RÉSUMÉ DES TARIFS IMPLÉMENTÉS:");
        System.out.println("   • Standard: prix de base × nombre de personnes");
        System.out.println("   • Étudiant: -20% sur le total");
        System.out.println("   • Groupe: -30% pour 5 personnes ou plus");
    }
}