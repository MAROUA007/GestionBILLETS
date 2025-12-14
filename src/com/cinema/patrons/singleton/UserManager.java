package com.cinema.patrons.singleton;
import java.util.ArrayList;
import java.util.List;
import com.cinema.modele.Utilisateur;
/**
 * UserManager
 * Singleton - Membre 2
 */
public class UserManager {
        // Instance unique (Singleton)
        private static UserManager instance;

        // Liste des utilisateurs
        private List<Utilisateur> users;

        // Utilisateur actuellement connecté
        private Utilisateur currentUser;

        // Constructeur privé (empêche new UserManager())
        private UserManager() {
            users = new ArrayList<>();
        }

        // Méthode d'accès à l'instance unique
        public static UserManager getInstance() {
            if (instance == null) {
                instance = new UserManager();
            }
            return instance;
        }

        // Ajouter un utilisateur
        public void addUser(Utilisateur user) {
            users.add(user);
        }

        // Récupérer tous les utilisateurs
        public List<Utilisateur> getUsers() {
            return users;
        }

        // Connexion
        public void login(String username, String password) {
            for (Utilisateur u : users) {
                if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                    currentUser = u;
                    System.out.println("Connexion réussie : " + u);
                    return;
                }
            }
            System.out.println("Échec de connexion : identifiants invalides");
        }

        // Récupérer l'utilisateur connecté
        public Utilisateur getCurrentUser() {
            return currentUser;
        }

        // Déconnexion
        public void logout() {
            currentUser = null;
            System.out.println("Utilisateur déconnecté.");
        }
    }
