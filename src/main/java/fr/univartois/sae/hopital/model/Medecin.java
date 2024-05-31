package fr.univartois.sae.hopital.model;

public class Medecin extends Personne {
    private String specialisation;

    public Medecin(String id, String nom, String specialisation) {
        super(id, nom);
        this.specialisation = specialisation;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    @Override
    public String toString() {
        return "Dr. " + getNom() + " : " + getSpecialisation();
    }
}