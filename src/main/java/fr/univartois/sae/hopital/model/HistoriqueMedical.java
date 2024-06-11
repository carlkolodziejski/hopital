package fr.univartois.sae.hopital.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
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
     * Le nombre de rendez-vous dans l'historique.
     */
    private IntegerProperty nbRendezVous;

    /**
     * Constructeur de la classe HistoriqueMedical.
     */
    public HistoriqueMedical() {
        historiqueRendezVous = FXCollections.observableArrayList();
        nbRendezVous = new SimpleIntegerProperty(0);
        
        ListChangeListener<RendezVous> listener = change -> updateNbRendezVous();

        historiqueRendezVous.addListener(listener);
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

    public void updateNbRendezVous() {
        nbRendezVous.set(historiqueRendezVous.size());
    }

    public IntegerProperty getNombreRendezVous() {
        return nbRendezVous;
    }
}