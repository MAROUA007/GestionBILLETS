package com.cinema.modele;

/**
 * Utilisateur
 * Membre 2 - Couche Modèle
 */



public class Utilisateur {
    // TODO: ajouter attributs et méthodes
}
    private String nomUtilisateur;
    private String nomComplet;

    public Utilisateur(String nomUtilisateur, String nomComplet) {
        this.nomUtilisateur = nomUtilisateur;
        this.nomComplet = nomComplet;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public String getNomComplet() {
        return nomComplet;
