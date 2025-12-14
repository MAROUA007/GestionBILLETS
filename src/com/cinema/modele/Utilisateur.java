package com.cinema.modele;




public class Utilisateur {
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
    