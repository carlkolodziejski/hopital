package fr.univartois.sae.hopital.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ListChangeListener;

import java.util.LinkedList;
import java.util.List;

public class Hopital {
    private SimpleListProperty<Medecin> medecins;
    private SimpleListProperty<Patient> patients;
    private IntegerProperty nbPersonnes;

    public Hopital() {
        this.medecins = new SimpleListProperty<>();
        this.patients = new SimpleListProperty<>();
        this.nbPersonnes = new SimpleIntegerProperty(0);
        ListChangeListener<Personne> listener = change -> updateNbPersonnes();
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

    public List<Medecin> rechercherParSpecialisation(String specialisation) {
        List<Medecin> medecinsTrouves = new LinkedList<>();
        for (Medecin medecin : medecins) {
            if (medecin.getSpecialisation().equals(specialisation)) {
                medecinsTrouves.add(medecin);
            }
        }
        return medecinsTrouves;
    }

    public List<Personne> rechercherParNom(String nom) {
        List<Personne> personnesTrouvees = new LinkedList<>();
        for (Medecin medecin : medecins) {
            if (medecin.getNom().equals(nom)) {
                personnesTrouvees.add(medecin);
            }
        }
        for (Patient patient : patients) {
            if (patient.getNom().equals(nom)) {
                personnesTrouvees.add(patient);
            }
        }
        return personnesTrouvees;
    }

    public List<Personne> rechercheGenerale() {
        // TODO Trouver comment implémenter cette méthode.
        return java.util.Collections.emptyList();
    }

    public List<Medecin> medecinsSimpleListProperty() {
        return medecins;
    }

    public SimpleListProperty<Patient> patientSimpleListProperty() {
        return patients;
    }

    public void updateNbPersonnes() {
        nbPersonnes.set(medecins.size() + patients.size());
    }

    public IntegerProperty getNbPersonnes() {
        return nbPersonnes;
    }
}