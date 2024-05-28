package fr.univartois.sae.hopital.model;

public class Facture {
    private Personne patient;
    private Medecin medecin;
    private String dateConsultation;
    private double montantTotal;
    private boolean payee;


    public Facture(Personne patient, Medecin medecin, String dateConsultation, double montantTotal) {
        this.patient = patient;
        this.medecin = medecin;
        this.dateConsultation = dateConsultation;
        this.montantTotal = montantTotal;
        this.payee = false; // Par défaut, la facture n'est pas payée.
    }

    public Personne getPatient() {
        return patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public String getDateConsultation() {
        return dateConsultation;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public boolean isPayee() {
        return payee;
    }

    public void setPayee(boolean payee) {
        this.payee = payee;
    }
}