package fr.univartois.sae.hopital.model;

public class Medecin extends Personne {
    /**
     * La spécialisation du médecin.
     */
    private String specialisation;

    /**
     * Le constructeur de la classe Medecin.
     *
     * @param id             L'identifiant du médecin.
     * @param nom            Le nom du médecin.
     * @param specialisation La spécialisation du médecin.
     */
    public Medecin(String id, String nom, String specialisation) {
        super(id, nom);
        this.specialisation = specialisation;
    }

    /**
     * Retourne la spécialisation du médecin.
     *
     * @return La spécialisation du médecin.
     */
    public String getSpecialisation() {
        return specialisation;
    }

    /**
     * Modifie la spécialisation du médecin.
     *
     * @param specialisation La nouvelle spécialisation du médecin.
     */
    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    /**
     * Retourne une représentation en chaîne du médecin.
     *
     * @return Une chaîne représentant le médecin.
     */
    @Override
    public String toString() {
        return "Dr. " + getNom() + " : " + getSpecialisation();
    }
}