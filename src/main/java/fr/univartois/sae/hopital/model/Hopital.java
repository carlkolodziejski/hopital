package fr.univartois.sae.hopital.model;

import java.util.LinkedList;
import java.util.List;

public class Hopital {
    private final double PRIX_RENDEZ_VOUS;
    private List<Medecin> medecins;
    private List<Patient> patients;

    public Hopital(double PRIX_RENDEZ_VOUS) {
        this.PRIX_RENDEZ_VOUS = 23.0;
        this.medecins = new LinkedList<>();
        this.patients = new LinkedList<>();
    }

    public double getPRIX_RENDEZ_VOUS() {
        return PRIX_RENDEZ_VOUS;
    }

    public String afficherMedecins() {
        StringBuilder sb = new StringBuilder();
        for (Medecin medecin : medecins) {
            sb.append(medecin.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String afficherPatients() {
        StringBuilder sb = new StringBuilder();
        for (Patient patient : patients) {
            sb.append(patient.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}