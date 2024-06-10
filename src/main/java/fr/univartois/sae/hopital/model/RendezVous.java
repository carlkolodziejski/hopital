package fr.univartois.sae.hopital.model;

import java.time.LocalDateTime;

/**
 * Classe qui représente un rendez-vous.
 */
public class RendezVous {
    /**
     * L'identifiant du rendez-vous.
     */
    private String id;

    /**
     * Le motif du rendez-vous.
     */
    private String motif;

    /**
     * Le prix de la consultation.
     */
    private double prix;

    /**
     * Le feedback du rendez-vous.
     */
    private String feedback;

    /**
     * Le diagnostic du rendez-vous.
     */
    private String diagnostic;

    /**
     * La date et l'heure du rendez-vous.
     */
    private LocalDateTime dateHeure;

    /**
     * L'ordonnance associée au rendez-vous.
     */
    private Ordonnance ordonnance;

    /**
     * Le patient concerné par le rendez-vous.
     */
    private Patient patient;

    /**
     * Le médecin qui a donné le rendez-vous.
     */
    private Medecin medecin;

    /**
     * Constructeur de la classe RendezVous.
     *
     * @param id        L'identifiant du rendez-vous.
     * @param motif     Le motif du rendez-vous.
     * @param patient   Le patient concerné par le rendez-vous.
     * @param medecin   Le médecin qui a donné le rendez-vous.
     * @param dateHeure La date et l'heure du rendez-vous.
     */
    public RendezVous(String id, String motif,
                      double prix, Patient patient, Medecin medecin, LocalDateTime dateHeure) {
        this.id = id;
        this.motif = motif;
        this.prix = prix;
        this.dateHeure = dateHeure;
        this.patient = patient;
        this.medecin = medecin;
    }

    /**
     * Retourne le prix de la consultation.
     *
     * @return Le prix de la consultation.
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Ajoute le rendez-vous à l'historique médical du patient.
     */
    public void enregistrerVisite() {
        patient.getHistoriqueMedical().ajouterRendezVous(this);
    }

    /**
     * Retourne une représentation en chaîne du rendez-vous.
     *
     * @return Une chaîne représentant le rendez-vous.
     */
    @Override
    public String toString() {
        return "Rendez-vous du " + dateHeure.getDayOfMonth() + "/" + dateHeure.getMonthValue() + "/" + dateHeure.getYear() + " à " + dateHeure.getHour() + "h" + dateHeure.getMinute() + " : " + motif + " avec le Dr." + medecin.getNom() + " pour " + patient.getNom();
    }
}