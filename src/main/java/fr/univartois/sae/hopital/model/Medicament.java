package fr.univartois.sae.hopital.model;

public class Medicament {
    private String nom;
    private int nombreJours;
    private int posologie;

    public Medicament(String nom, int nombreJours, int posologie) {
        this.nom = nom;
        this.nombreJours = nombreJours;
        this.posologie = posologie;
    }

    @Override
    public String toString() {
        return nom + " : " + nombreJours + ", " + posologie + " par jour.";
    }

    public String getNom() {
        return nom;
    }

    public int getNombreJours() {
        return nombreJours;
    }

    public int getPosologie() {
        return posologie;
    }
}
