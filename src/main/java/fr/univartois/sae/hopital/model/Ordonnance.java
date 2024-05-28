package fr.univartois.sae.hopital.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Ordonnance {
    private Patient patient;
    private ArrayList<Prescription> prescriptions;

    public Ordonnance(Patient patient) {
        this.patient = patient;
        prescriptions = new ArrayList<>();
    }

    public static void ajouterOrdonnance(Patient patient, RendezVous visite) {
        patient.getHistoriqueMedical().getTraitements()[patient.getHistoriqueMedical().getNombreVisites() % patient.getHistoriqueMedical().getTAILLE_MAX()] = new Ordonnance(patient);
        String reponse;
        String diagnostic, medicament;
        boolean choix = true;
        int duree, posologie;
        Scanner sc = new Scanner(System.in);
        System.out.print("Ajoutez un diagnostic : ");
        diagnostic = sc.nextLine();
        do {
            System.out.print("Quel médicament préscrire ? : ");
            medicament = sc.nextLine();
            System.out.print("Pendant combien de jours ? : ");
            duree = sc.nextInt();
            sc.nextLine();
            System.out.print("Combien de fois par jour ? : ");
            posologie = sc.nextInt();
            sc.nextLine();
            patient.getHistoriqueMedical().getTraitements()[patient.getHistoriqueMedical().getNombreVisites() % patient.getHistoriqueMedical().getTAILLE_MAX()].prescrire(medicament, duree, posologie);
            System.out.println("Préscrire un autre médicament ? O/N : ");
            reponse = sc.nextLine();
            if (!(reponse.equals("O") || reponse.equals("o"))) {
                choix = false;
            }
        } while (choix);
        patient.enregistrerVisite(visite, diagnostic, patient.getHistoriqueMedical().getTraitements()[patient.getHistoriqueMedical().getNombreVisites() % patient.getHistoriqueMedical().getTAILLE_MAX()]);
    }

    void prescrire(String medicament, int duree, int posologie) {
        Prescription prescription = new Prescription(medicament, duree, posologie, this);
        prescriptions.add(prescription);
    }

    String afficherPrescriptions() {
        StringBuilder chainePrescriptions = new StringBuilder();
        for (Prescription prescription : prescriptions) {
            chainePrescriptions.append(prescription.toString());
        }
        return chainePrescriptions.toString();
    }

    @Override
    public String toString() {
        return "Ordonnance pour " + patient.getNom() + " " + patient.getPrenom() + " : \n"
                + afficherPrescriptions();
    }

    class Prescription {
        private String medicament;
        private int duree;
        private int posologie;
        private Ordonnance ordonnance;

        // Constructeur prenant en compte l'ordonnance parente
        Prescription(String medicament, int duree, int posologie, Ordonnance ordonnance) {
            if (duree < 1) {
                System.out.println("Veuillez entrer une durée valide.");
                System.exit(1);
            }
            if (posologie < 1) {
                System.out.println("Veuillez entrer une posologie valide.");
                System.exit(1);
            }
            this.medicament = medicament;
            this.duree = duree;
            this.posologie = posologie;
            this.ordonnance = ordonnance;
        }

        public String getMedicaments() {
            return medicament;
        }

        public int getPosologie() {
            return posologie;
        }

        public int getDuree() {
            return duree;
        }

        public String toString() {
            return medicament + ", " + duree + " jours" + ", " + posologie + " fois par jour.\n";
        }
    }
}
