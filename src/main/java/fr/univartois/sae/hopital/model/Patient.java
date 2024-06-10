package fr.univartois.sae.hopital.model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe qui représente un patient.
 */
public class Patient extends Personne {
    private LocalDate dateNaissance;
    private String prenom;
    private List<Facture> factures;
    private GroupeSanguin groupeSanguin;
    private HistoriqueMedical historiqueMedical;

    /**
     * Constructeur de la classe Patient.
     *
     * @param id            L'identifiant du patient.
     * @param nom           Le nom du patient.
     * @param prenom        Le prénom du patient.
     * @param groupeSanguin Le groupe sanguin du patient.
     * @param dateNaissance La date de naissance du patient.
     */
    public Patient(String id, String nom, String prenom, GroupeSanguin groupeSanguin, LocalDate dateNaissance) {
        super(id, nom);
        this.prenom = prenom;
        this.groupeSanguin = groupeSanguin;
        this.factures = new LinkedList<>();
        this.dateNaissance = dateNaissance;
        this.historiqueMedical = new HistoriqueMedical();
    }

    /**
     * Retourne la date de naissance du patient.
     *
     * @return La date de naissance du patient.
     */
    public HistoriqueMedical getHistoriqueMedical() {
        return historiqueMedical;
    }

    /**
     * Marque une facture comme payée.
     *
     * @param facture La facture à marquer comme payée.
     */
    public void marquerFacturePayee(Facture facture) {
        facture.setPayee(true);
    }

    /**
     * Affiche l'état des factures du patient.
     *
     * @return La liste des factures du patient ainsi que leur état.
     */
    public List<String> afficherEtatFactures() {
        List<String> etatFactures = new LinkedList<>();
        for (Facture facture : factures) {
            etatFactures.add(facture.toString());
        }
        return etatFactures;
    }

    /**
     * Affiche l'historique médical du patient.
     *
     * @return La liste des rendez-vous du patient.
     */
    public List<String> afficherHistoriqueMedical() {
        List<String> historique = new LinkedList<>();
        for (RendezVous rendezVous : historiqueMedical.getHistoriqueRendezVous()) {
            historique.add(rendezVous.toString());
        }
        return historique;
    }

    /**
     * Retourne une représentation en chaîne du patient.
     *
     * @return Une chaîne représentant le patient.
     */
    @Override
    public String toString() {
        return getNom() + " " + prenom + " : " + groupeSanguin + ", né le " + dateNaissance;
    }
}