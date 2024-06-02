package fr.univartois.sae.hopital.model;

import java.util.LinkedList;
import java.util.List;

public class Ordonnance {
    /**
     * L'identifiant de l'ordonnance.
     */
    private final String id;

    /**
     * La liste des médicaments que contient l'ordonnance.
     */
    private List<Medicament> medicaments;

    /**
     * Le constructeur de la classe Ordonnance.
     *
     * @param id          L'identifiant de l'ordonnance
     * @param medicaments La liste des médicaments que contient l'ordonnance.
     */
    public Ordonnance(String id, List<Medicament> medicaments) {
        this.medicaments = new LinkedList<>();
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

    /**
     * Retourne une représentation en chaîne de l'ordonnance.
     *
     * @return Une chaîne représentant l'ordonnance.
     */
    @Override
    public String toString() {
        return id + " : \n" + afficherMedicaments();
    }
}
