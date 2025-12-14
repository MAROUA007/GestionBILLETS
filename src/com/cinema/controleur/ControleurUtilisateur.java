package com.cinema.controleur;
import com.cinema.modele.Profil;
import com.cinema.patrons.singleton.UserManager;
import com.cinema.modele.Utilisateur;
/**
 * ControleurUtilisateur
 * Membre 2 - Contrôleur
 */
public class ControleurUtilisateur {
        public static void main(String[] args) {
            // Création de profils
            Profil profil1 = new Profil("A", "a@mail.com", "Etudiant");
            Profil profil2 = new Profil("Bn", "bob@mail.com", "Professeur");

            // Création d'utilisateurs
            Utilisateur user1 = new Utilisateur("a", "1234", profil1);
            Utilisateur user2 = new Utilisateur("b", "abcd", profil2);

            // Récupération du Singleton UserManager
            UserManager manager = UserManager.getInstance();

            // Ajout des utilisateurs
            manager.addUser(user1);
            manager.addUser(user2);

            // Tests de connexion
            manager.login("a", "1234");   // succès
            manager.login("b", "wrong");    // échec

            // Affichage de l'utilisateur courant
            System.out.println("Utilisateur connecté: " + manager.getCurrentUser());

            // Déconnexion
            manager.logout();
        }
    }
