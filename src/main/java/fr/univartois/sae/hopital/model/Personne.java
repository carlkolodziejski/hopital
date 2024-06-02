package fr.univartois.sae.hopital.model;

public abstract class Personne {
    /**
     * L'identifiant de la personne.
     */
    private final String id;

    /**
     * Le nom de la personne.
     */
    private String nom;

    /**
     * Constructeur de la classe Personne.
     *
     * @param id  L'identifiant de la personne.
     * @param nom Le nom de la personne.
     */
    protected Personne(String id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    /**
     * Retourne "Médecin" si la personne est un médecin, sinon "Patient".
     *
     * @return Le statut de la personne.
     */
    public String statut() {
        if (this instanceof Medecin) {
            return "Médecin";
        } else {
            return "Patient";
        }
    }

    /**
     * Affiche le nom de la personne, suivi de son statut.
     *
     * @return Le nom de la personne, suivi de son statut.
     * @see #statut()
     */
    public String afficherStatut() {
        return nom + ", " + statut();
    }

    /**
     * Retourne le nom de la personne.
     *
     * @return Le nom de la personne.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom de la personne.
     *
     * @param nom Le nouveau nom de la personne.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne l'identifiant de la personne.
     *
     * @return L'identifiant de la personne.
     */
    public String getId() {
        return id;
    }

    /**
     * Retourne une représentation en chaîne de la personne.
     *
     * @return Une chaîne représentant la personne.
     */
    public abstract String toString();
}
