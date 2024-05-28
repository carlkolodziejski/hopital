package fr.univartois.sae.hopital.model;

public class RendezVous {
    private Patient patient;
    private Medecin medecin;
    private String date, heure, motif, feedback;

    public RendezVous(Patient patient, Medecin medecin, String date, String heure, String motif) {
        this.patient = patient;
        this.medecin = medecin;
        this.date = date;
        this.heure = heure;
        this.motif = motif;
        this.feedback = "Pas d'avis déposé.";
    }

    public Patient getPatient() {
        return patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getMotif() {
        return motif;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
