package fr.univartois.sae.hopital.model;

import java.time.LocalDateTime;

class RendezVous {
    private String id;
    private String motif;
    private double prix;
    private String feedback;
    private String diagnostic;
    private LocalDateTime dateHeure;
    private Ordonnance ordonnance;
    private Patient patient;
    private Medecin medecin;
    public RendezVous(String id, String motif, Patient patient, Medecin medecin, LocalDateTime dateHeure) {
        this.id = id;
        this.motif = motif;
        this.dateHeure = dateHeure;
        this.patient = patient;
        this.medecin = medecin;
    }

    public RendezVous(String id, String motif, String feedback, Patient patient, Medecin medecin, LocalDateTime dateHeure) {
        this.id = id;
        this.motif = motif;
        this.dateHeure = dateHeure;
        this.patient = patient;
        this.medecin = medecin;
    }

    public double getPrix() {
        return prix;
    }

    public void enregistrerVisite() {
        patient.getHistoriqueMedical().ajouterRendezVous(this);
    }

    @Override
    public String toString() {
        return "Rendez-vous du " + dateHeure.getDayOfMonth() + "/" + dateHeure.getMonthValue() + "/" + dateHeure.getYear() + " à " + dateHeure.getHour() + "h" + dateHeure.getMinute() + " : " + motif + " avec le Dr." + medecin.getNom() + " pour " + patient.getNom();
    }
}