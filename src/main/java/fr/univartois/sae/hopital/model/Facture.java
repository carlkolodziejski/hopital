package fr.univartois.sae.hopital.model;

import java.util.LinkedList;
import java.util.List;

public class Facture {
    /**
     * L'identifiant de la facture.
     */
    private String id;

    /**
     * Les détails de la facture.
     */
    private String details;

    /**
     * Le coût de la facture.
     */
    private double coutTotal;

    /**
     * Indique si la facture a été payée.
     */
    private boolean payee;

    /**
     * Les rendez-vous compris dans la facture.
     */
    private List<RendezVous> rendezVous;

    /**
     * Le constructeur de la classe Facture.
     *
     * @param id      L'identifiant de la facture.
     * @param details Les détails de la facture.
     * @param payee   Le booléen qui indique si la facture est payée.
     */
    public Facture(String id, String details, boolean payee) {
        this.id = id;
        this.details = details;
        this.payee = payee;
        this.rendezVous = new LinkedList<>();
        calculerCoutTotal();
    }

    /**
     * Détermine le coût total de la facture.
     * Le prix est determiné par le prix d'un rendez-vous multiplié par le nombre de rendez-vous compris dans la facture.
     *
     * @return
     */
    private double calculerCoutTotal() {
        assert rendezVous != null;
        return Hopital.PRIX_RENDEZ_VOUS * rendezVous.size();
    }

    /**
     * Retourne les détails de la facture.
     *
     * @return Les détails de la facture.
     */
    public String getDetails() {
        return details;
    }

    /**
     * Retourne le coût de la facture.
     *
     * @return Le coût de la facture.
     */
    public double getCoutTotal() {
        return coutTotal;
    }

    /**
     * Retourne vrai si la facture est payée, sinon faux.
     *
     * @return vrai si la facture est payée, sinon faux.
     */
    public boolean isPayee() {
        return payee;
    }

    /**
     * Change l'état du payement de la facture.
     *
     * @param payee Le nouveau booléen indiquant si la facture est payée ou non.
     */
    public void setPayee(boolean payee) {
        this.payee = payee;
    }
}