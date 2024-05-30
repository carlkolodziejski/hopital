package fr.univartois.sae.hopital.model;

public abstract class Personne {
    private final String id;
    private String nom;


    protected Personne(String id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public String statut() {
        if (this instanceof Medecin) {
            return "Médecin";
        } else {
            return "Patient";
        }
    }

    public String afficherStatut() {
        return nom + ", " + statut();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getId() {
        return id;
    }

    public abstract String toString();
}
