package fr.univartois.sae.hopital.model;

public class HistoriqueMedical {
    private final int TAILLE_MAX;
    private RendezVous[] rendezVous;
    private String[] diagnostics;
    private Ordonnance[] traitements;
    private int nombreVisites;

    public HistoriqueMedical() {
        TAILLE_MAX = 100;
        rendezVous = new RendezVous[TAILLE_MAX];
        diagnostics = new String[TAILLE_MAX];
        traitements = new Ordonnance[TAILLE_MAX];
        nombreVisites = 0;
    }

    public RendezVous[] getVisites() {
        return rendezVous;
    }

    public String[] getDiagnostics() {
        return diagnostics;
    }

    public Ordonnance[] getTraitements() {
        return traitements;
    }

    public int getTAILLE_MAX() {
        return TAILLE_MAX;
    }

    public int getNombreVisites() {
        return nombreVisites;
    }

    public void incrementerNombreVisites() {
        nombreVisites++;
    }
}