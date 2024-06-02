package fr.univartois.sae.hopital.model;

public class Medicament {
    /**
     * Le nom du médicament.
     */
    private String nom;

    /**
     * Le nombre de jours pendant lequel le médicament doit être pris.
     */
    private int nombreJours;

    /**
     * La posologie (fréquence de prise) du médicament.
     */
    private int posologie;

    /**
     * Le constructeur du Medicament.
     *
     * @param nom         Le nom du médicament.
     * @param nombreJours Le nombre de jours pendant lequel le médicament doit être pris.
     * @param posologie   La posologie (fréquence de prise) du médicament.
     */
    public Medicament(String nom, int nombreJours, int posologie) {
        this.nom = nom;
        this.nombreJours = nombreJours;
        this.posologie = posologie;
    }

    /**
     * Retourne une représentation en chaîne du médicament.
     *
     * @return une chaîne représentant le médicament.
     */
    @Override
    public String toString() {
        return nom + " : " + nombreJours + ", " + posologie + " par jour.";
    }

    /**
     * Retourne le nom du médicament.
     *
     * @return Le nom du médicament.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne le nombre de jours pendant lequel le médicament doit être pris.
     *
     * @return Le nombre de jours pendant lequel le médicament doit être pris.
     */
    public int getNombreJours() {
        return nombreJours;
    }

    /**
     * Retourne la posologie du médicament.
     *
     * @return La posologie du médicament.
     */
    public int getPosologie() {
        return posologie;
    }
}
