package fr.univartois.sae.hopital.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.LinkedList;
import java.util.List;

/**
 * Classe qui représente un hôpital.
 */
public class Hopital {
    /**
     * La liste des médecins de l'hôpital.
     */
    private ObservableList<Medecin> medecins;

    /**
     * La liste des patients de l'hôpital.
     */
    private ObservableList<Patient> patients;

    /**
     * Le nombre de personnes dans l'hôpital.
     */
    private IntegerProperty nbPersonnes;

    /**
     * Le patient sélectionné sur lequel seront effectuées les prochaines opérations.
     */
    private Patient patientCourant;

    /**
     * Constructeur de la classe Hopital.
     */
    public Hopital() {
        this.medecins = FXCollections.observableArrayList();
        this.patients = FXCollections.observableArrayList();
        this.nbPersonnes = new SimpleIntegerProperty(0);
        this.patientCourant = null;

        // Cet écouteur permet de mettre à jour le nombre de personnes dans l'hôpital à chaque fois que la taille de la liste des médecins ou des patients change.
        ListChangeListener<Personne> listener = change -> updateNbPersonnes();
    }

    /**
     * Ajoute un médecin à la liste des médecins.
     *
     * @param medecin Le médecin à ajouter.
     */
    public void ajouterMedecin(Medecin medecin) {
        medecins.add(medecin);
    }

    /**
     * Ajoute un patient à la liste des patients.
     *
     * @param patient Le patient à ajouter.
     */
    public void ajouterPatient(Patient patient) {
        patients.add(patient);
    }

    /**
     * Retourne une représentation en chaîne de la liste des médecins.
     *
     * @return Une chaîne représentant la liste des médecins.
     */
    public String afficherMedecins() {
        StringBuilder sb = new StringBuilder();
        for (Medecin medecin : medecins) {
            sb.append(medecin.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Retourne une représentation en chaîne de la liste des patients.
     *
     * @return Une chaîne représentant la liste des patients.
     */
    public String afficherPatients() {
        StringBuilder sb = new StringBuilder();
        for (Patient patient : patients) {
            sb.append(patient.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Recherche les médecins qui ont une spécialisation donnée.
     *
     * @param specialisation La spécialisation à rechercher.
     * @return La liste des médecins qui ont la spécialisation donnée.
     */
    public List<Medecin> rechercherParSpecialisation(String specialisation) {
        List<Medecin> medecinsTrouves = new LinkedList<>();
        for (Medecin medecin : medecins) {
            if (medecin.getSpecialisation().equals(specialisation)) {
                medecinsTrouves.add(medecin);
            }
        }
        return medecinsTrouves;
    }

    /**
     * Recherche les personnes qui ont un nom donné.
     *
     * @param nom Le nom à rechercher.
     * @return La liste des personnes qui ont le nom donné.
     */
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

    /**
     * Recherche des personnes selon différents critères.
     *
     * @return La liste des personnes trouvées.
     */
    public List<Personne> rechercheGenerale() {
        // TODO Trouver comment implémenter cette méthode.
        return java.util.Collections.emptyList();
    }

    /**
     * Retourne la liste des médecins.
     *
     * @return La liste des médecins.
     */
    public ObservableList<Medecin> getMedecins() {
        return medecins;
    }

    /**
     * Retourne la liste des patients.
     *
     * @return La liste des patients.
     */
    public ObservableList<Patient> getPatients() {
        return patients;
    }

    /**
     * Met à jour le nombre de personnes dans l'hôpital.
     */
    public void updateNbPersonnes() {
        nbPersonnes.set(medecins.size() + patients.size());
    }

    /**
     * Retourne le nombre de personnes dans l'hôpital.
     *
     * @return Le nombre de personnes dans l'hôpital.
     */
    public IntegerProperty getNbPersonnes() {
        return nbPersonnes;
    }

    /**
     * Retourne le nombre de médecins dans l'hôpital.
     *
     * @return Le nombre de médecins dans l'hôpital.
     */
    public IntegerProperty getNbMedecins() {
        return new SimpleIntegerProperty(medecins.size());
    }

    /**
     * Retourne le nombre de patients dans l'hôpital.
     *
     * @return Le nombre de patients dans l'hôpital.
     */
    public IntegerProperty getNbPatients() {
        return new SimpleIntegerProperty(patients.size());
    }

    /**
     * Retourne le patient sélectionné.
     *
     * @return Le patient sélectionné.
     */
    public Patient getPatientCourant() {
        return patientCourant;
    }

    /**
     * Définit le patient sélectionné.
     *
     * @param patientCourant Le patient sélectionné.
     */
    public void setPatientCourant(Patient patientCourant) {
        this.patientCourant = patientCourant;
    }
}