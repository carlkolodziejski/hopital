package fr.univartois.sae.hopital.model;

public class Patient extends Personne {
    private final int NOMBRE_MAX_FACTURES;
    private HistoriqueMedical historiqueMedical;
    private GroupeSanguin groupeSanguin;
    private String adresse;
    private String nom;
    private String prenom;
    private int numTel, age;
    private Facture[] listeFactures;
    private int nombreFactures;

    public Patient(String nom, String prenom, String numTel, int age, String adresse, GroupeSanguin groupeSanguin) {
        super(nom, prenom, numTel, age);
        this.adresse = adresse;
        this.groupeSanguin = groupeSanguin;
        NOMBRE_MAX_FACTURES = 100;
        listeFactures = new Facture[NOMBRE_MAX_FACTURES];
        nombreFactures = 0;
        this.historiqueMedical = new HistoriqueMedical();
    }

    public void ajouterAvis(RendezVous rendezVous, String feedback) {
        if (rendezVous.getPatient() == this) {
            rendezVous.setFeedback(feedback);
        } else {
            System.out.println("Vous n'avez pas assisté à ce rendez-vous.");
        }
    }

    public Facture[] getListeFactures() {
        return listeFactures;
    }

    public int getNombreFactures() {
        return nombreFactures;
    }

    public void incrementerNombreFactures() {
        nombreFactures++;
    }

    public void decrementerNombreFactures() {
        nombreFactures--;
    }

    public GroupeSanguin getGroupeSanguin() {
        return groupeSanguin;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNOMBRE_MAX_FACTURES() {
        return NOMBRE_MAX_FACTURES;
    }

    public String toString() {
        return getNom() + " " + getPrenom() + " : " + afficherAge() + ", " + groupeSanguin + ", " + adresse + ", " + getNumTel();
    }

    public void marquerFacturePayee(Facture facture) {
        facture.setPayee(true);
        System.out.println("La facture pour la consultation du " + facture.getDateConsultation() + " a été marquée comme payée.");
    }

    public void afficherEtatFactures() {
        System.out.println("État des factures :");
        for (int i = 0; i < this.getNombreFactures(); i++) {
            String statut = this.getListeFactures()[i].isPayee() ? "Payée" : "Non payée"; // Si vrai, retourne "Payée", sinon retourne "Non payée".
            System.out.println((i + 1) + " - fr.univartois.sae.hopital.model.Patient : " + this.getListeFactures()[i].getPatient().getNom() + ", Médecin : " + this.getListeFactures()[i].getMedecin().getNom() +
                    ", Date : " + this.getListeFactures()[i].getDateConsultation() + ", Montant : " + this.getListeFactures()[i].getMontantTotal() + " - Statut : "
                    + statut);
        }
    }

    public HistoriqueMedical getHistoriqueMedical() {
        return historiqueMedical;
    }

    public void enregistrerVisite(RendezVous visite, String diagnostic, Ordonnance traitement) {
        if (historiqueMedical.getNombreVisites() < historiqueMedical.getVisites().length) {
            historiqueMedical.getVisites()[historiqueMedical.getNombreVisites() % historiqueMedical.getTAILLE_MAX()] = visite;
            historiqueMedical.getDiagnostics()[historiqueMedical.getNombreVisites() % historiqueMedical.getTAILLE_MAX()] = diagnostic;
            historiqueMedical.getTraitements()[historiqueMedical.getNombreVisites() % historiqueMedical.getTAILLE_MAX()] = traitement;
            historiqueMedical.incrementerNombreVisites();
        }
    }

    public void afficherHistorique() {
        System.out.println("Historique médical :");
        for (int i = 0; i < historiqueMedical.getNombreVisites(); i++) {
            System.out.println("Visite " + (i + 1) + " : ");
            System.out.println("Diagnostic : " + historiqueMedical.getDiagnostics()[i]);
            System.out.println("Traitement : " + historiqueMedical.getTraitements()[i]);
            System.out.println();
        }
    }
}