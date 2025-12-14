package com.cinema.modele;

<<<<<<< HEAD
public class Utilisateur {
        private String username;
        private String password;
        private Profil profil;

        // Constructeur
        public Utilisateur(String username, String password, Profil profil) {
            this.username = username;
            this.password = password;
            this.profil = profil;
        }

        // Getters
        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public Profil getProfil() {
            return profil;
        }

        // Affichage lisible
        @Override
        public String toString() {
            return "Utilisateur{" +
                    "username='" + username + '\'' +
                    ", profil=" + profil +
                    '}';
        }
    }

