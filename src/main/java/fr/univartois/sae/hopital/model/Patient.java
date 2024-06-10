package fr.univartois.sae.hopital.model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Patient extends Personne {
    private LocalDate dateNaissance;
    private String prenom;
    private List<Facture> factures;
    private GroupeSanguin groupeSanguin;
    private HistoriqueMedical historiqueMedical;

    public Patient(String id, String nom, String prenom, GroupeSanguin groupeSanguin, LocalDate dateNaissance) {
        super(id, nom);
        this.prenom = prenom;
        this.groupeSanguin = groupeSanguin;
        this.factures = new LinkedList<>();
        this.dateNaissance = dateNaissance;
        this.historiqueMedical = new HistoriqueMedical();
    }

    public void marquerFacturePayee(Facture facture) {
        facture.setPayee(true);
    }

    public List<String> afficherEtatFactures() {
        List<String> etatFactures = new LinkedList<>();
        for (Facture facture : factures) {
            etatFactures.add(facture.toString());
        }
        return etatFactures;
    }

    public List<String> afficherHistoriqueMedical() {
        List<String> historique = new LinkedList<>();
        for (RendezVous rendezVous : historiqueMedical.getHistoriqueRendezVous()) {
            historique.add(rendezVous.toString());
        }
        return historique;
    }

    @Override
    public String toString() {
        return "";
    }
}