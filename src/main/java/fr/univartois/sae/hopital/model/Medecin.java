package fr.univartois.sae.hopital.model;

public class Medecin extends Personne {
    private final int NOMBRE_MAX_RENDEZVOUS = 30;
    private String specialisation;
    private RendezVous[] listeRendezVous;
    private int nombreRendezVous;

    public Medecin(String nom, String prenom, String numTel, int age, String specialisation) {
        super(nom, prenom, numTel, age);
        this.specialisation = specialisation;
        listeRendezVous = new RendezVous[NOMBRE_MAX_RENDEZVOUS];
        nombreRendezVous = 0;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    @Override
    public String toString() {
        return getNom() + " " + getPrenom() + " : " + afficherAge() + ", " + specialisation + ", " + getNumTel();
    }

    public int getNOMBRE_MAX_RENDEZVOUS() {
        return NOMBRE_MAX_RENDEZVOUS;
    }

    public RendezVous[] getListeRendezVous() {
        return listeRendezVous;
    }

    public int getNombreRendezVous() {
        return nombreRendezVous;
    }

    public void incrementerNombreRendezVous() {
        nombreRendezVous++;
    }

    public void decrementerNombreRendezVous() {
        nombreRendezVous--;
    }

}