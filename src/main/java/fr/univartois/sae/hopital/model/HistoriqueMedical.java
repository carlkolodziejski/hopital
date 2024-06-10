package fr.univartois.sae.hopital.model;

import java.util.Stack;

public class HistoriqueMedical {
    /**
     * Pile qui représente l'historique des rendez-vous d'un patient.
     */
    private Stack<RendezVous> historiqueRendezVous;

    /**
     * Constructeur de la classe HistoriqueMedical.
     */
    public HistoriqueMedical() {
        this.historiqueRendezVous = new Stack<>();
    }

    public Stack<RendezVous> getHistoriqueRendezVous() {
        return historiqueRendezVous;
    }

    /**
     * Ajoute un rendez-vous au sommet de la pile.
     *
     * @param rendezVous Le rendez-vous à ajouter.
     */
    public void ajouterRendezVous(RendezVous rendezVous) {
        historiqueRendezVous.push(rendezVous);
    }
}