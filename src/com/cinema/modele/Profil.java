package com.cinema.modele;

/**
 * Profil
 * Membre 2 - Couche Modèle
 */
public class Profil {
        private String nomComplet;
        private String email;
        private String type; // exemple: "Etudiant", "Professeur", "Admin"

        public Profil(String nomComplet, String email, String type) {
            this.nomComplet = nomComplet;
            this.email = email;
            this.type = type;
        }

        public String getNomComplet() {
            return nomComplet;
        }

        public String getEmail() {
            return email;
        }

        public String getType() {
            return type;
        }

        @Override
        public String toString() {
            return "Profil{" +
                    "nomComplet='" + nomComplet + '\'' +
                    ", email='" + email + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }
    }
