package fr.univartois.sae.hopital.model;

import java.util.List;

public class Ordonnance {
    /**
     * L'identifiant de l'ordonnance.
     */
    private final String id;

    /**
     * Liste des médicaments que contient l'ordonnance.
     */
    private List<Medicament> medicaments;

    public Ordonnance(List<Medicament> medicaments, String id) {
        this.medicaments = medicaments;
        this.id = id;
    }

    /**
     * Ajoute un médicament à l'ordonnance.
     *
     * @param medicament Le médicament à ajouter.
     */
    void prescrire(Medicament medicament) {
        medicaments.add(medicament);
    }

    /**
     * Permet d'afficher les médicaments compris dans l'ordonnance.
     *
     * @return La liste des médicaments compris dans l'ordonnance.
     */
    String afficherMedicaments() {
        StringBuilder affichageMedicaments = new StringBuilder();
        for (Medicament medicament : medicaments) {
            affichageMedicaments.append(medicament.toString()).append("\n");
        }
        return affichageMedicaments.toString();
    }

    @Override
    public String toString() {
        return id + " : \n" + afficherMedicaments();
    }
}
