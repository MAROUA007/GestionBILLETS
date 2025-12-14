package com.cinema.vue;
import com.cinema.modele.Profil;
import com.cinema.modele.Utilisateur;
import com.cinema.patrons.singleton.UserManager;

import java.util.Scanner;
/**
 * VueUtilisateur
 * Membre 2 - Vue
 */
public class VueUtilisateur {

        private UserManager manager;

        public VueUtilisateur() {
            manager = UserManager.getInstance();
        }

        public void afficherMenu() {
            Scanner scanner = new Scanner(System.in);
            int choix;

            do {
                System.out.println("\n=== Menu Utilisateur ===");
                System.out.println("1. Créer un utilisateur");
                System.out.println("2. Se connecter");
                System.out.println("3. Voir utilisateur courant");
                System.out.println("4. Se déconnecter");
                System.out.println("0. Quitter");
                System.out.print("Votre choix: ");
                choix = scanner.nextInt();
                scanner.nextLine(); // consommer le retour

                switch (choix) {
                    case 1 -> creerUtilisateur(scanner);
                    case 2 -> login(scanner);
                    case 3 -> afficherUtilisateurCourant();
                    case 4 -> manager.logout();
                    case 0 -> System.out.println("Au revoir !");
                    default -> System.out.println("Choix invalide.");
                }
            } while (choix != 0);
        }

        private void creerUtilisateur(Scanner scanner) {
            System.out.print("Nom d'utilisateur: ");
            String username = scanner.nextLine();
            System.out.print("Mot de passe: ");
            String password = scanner.nextLine();
            System.out.print("Nom complet: ");
            String nomComplet = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Type (Etudiant/Professeur/Admin): ");
            String type = scanner.nextLine();

            Profil profil = new Profil(nomComplet, email, type);
            Utilisateur user = new Utilisateur(username, password, profil);
            manager.addUser(user);
            System.out.println("Utilisateur créé avec succès !");
        }

        private void login(Scanner scanner) {
            System.out.print("Nom d'utilisateur: ");
            String username = scanner.nextLine();
            System.out.print("Mot de passe: ");
            String password = scanner.nextLine();
            manager.login(username, password);
        }

        private void afficherUtilisateurCourant() {
            Utilisateur current = manager.getCurrentUser();
            if (current != null) {
                System.out.println("Utilisateur connecté: " + current);
            } else {
                System.out.println("Aucun utilisateur connecté.");
            }
        }

        public static void main(String[] args) {
            VueUtilisateur vue = new VueUtilisateur();
            vue.afficherMenu();
        }
    }
