package fr.univartois.sae.hopital.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Classe qui représente un médecin.
 */
public class Medecin extends Personne {
    /**
     * La spécialisation du médecin.
     */
    private String specialisation;

    /**
     * Prix de la consultation.
     */
    private double tarif;

    /**
     * Liste des rendez-vous du médecin.
     */
    private ObservableList<RendezVous> rendezVous;

    /**
     * Le constructeur de la classe Medecin.
     *
     * @param id             L'identifiant du médecin.
     * @param nom            Le nom du médecin.
     * @param specialisation La spécialisation du médecin.
     */
    public Medecin(String id, String nom, String specialisation, double tarif) {
        super(id, nom);
        this.specialisation = specialisation;
        this.tarif = tarif;
        rendezVous = FXCollections.observableArrayList();
    }

    /**
     * Retourne la spécialisation du médecin.
     *
     * @return La spécialisation du médecin.
     */
    public String getSpecialisation() {
        return specialisation;
    }

    /**
     * Modifie la spécialisation du médecin.
     *
     * @param specialisation La nouvelle spécialisation du médecin.
     */
    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    /**
     * Retourne la liste des rendez-vous du médecin.
     *
     * @return La liste des rendez-vous du médecin.
     */
    public ObservableList<RendezVous> getRendezVous() {
        return rendezVous;
    }

    /**
     * Ajoute un rendez-vous à la liste des rendez-vous du médecin.
     *
     * @param rendezVous Le rendez-vous à ajouter.
     */
    public void ajouterRendezVous(RendezVous rendezVous) {
        this.rendezVous.add(rendezVous);
    }

    /**
     * Retourne une représentation en chaîne du médecin.
     *
     * @return Une chaîne représentant le médecin.
     */
    @Override
    public String toString() {
        return "Dr. " + getNom() + " : " + getSpecialisation();
    }

    public double getTarif() {
        return tarif;
    }
}