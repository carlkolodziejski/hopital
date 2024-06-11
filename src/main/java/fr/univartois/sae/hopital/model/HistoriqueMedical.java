package fr.univartois.sae.hopital.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Classe qui représente l'historique médical d'un patient.
 */
public class HistoriqueMedical {
    /**
     * Pile qui représente l'historique des rendez-vous d'un patient.
     */
    private ObservableList<RendezVous> historiqueRendezVous;

    /**
     * Constructeur de la classe HistoriqueMedical.
     */
    public HistoriqueMedical() {
        this.historiqueRendezVous = FXCollections.observableArrayList();
    }

    public ObservableList<RendezVous> getHistoriqueRendezVous() {
        return historiqueRendezVous;
    }

    /**
     * Ajoute un rendez-vous au sommet de la pile.
     *
     * @param rendezVous Le rendez-vous à ajouter.
     */
    public void ajouterRendezVous(RendezVous rendezVous) {
        historiqueRendezVous.add(rendezVous);
    }

    public int getNombreRendezVous() {
        return historiqueRendezVous.size();
    }
}