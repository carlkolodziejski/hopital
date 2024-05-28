package fr.univartois.sae.hopital.model;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;


public class Hopital {
    private final int NOMBRE_MAX_MEDECINS;
    private final int NOMBRE_MAX_PATIENTS;
    private final int NOMBRE_MAX_PERSONNES;
    private Medecin[] medecins;
    private Patient[] patients;
    private Personne[] personnes;
    private int nombrePatients;
    private int nombreMedecins;

    public Hopital(int NOMBRE_MAX_MEDECINS, int NOMBRE_MAX_PATIENTS) {
        this.NOMBRE_MAX_MEDECINS = NOMBRE_MAX_MEDECINS;
        this.NOMBRE_MAX_PATIENTS = NOMBRE_MAX_PATIENTS;
        NOMBRE_MAX_PERSONNES = NOMBRE_MAX_MEDECINS + NOMBRE_MAX_PATIENTS;
        medecins = new Medecin[NOMBRE_MAX_MEDECINS];
        patients = new Patient[NOMBRE_MAX_PATIENTS];
        personnes = new Personne[NOMBRE_MAX_PERSONNES];
        nombreMedecins = 0;
        nombrePatients = 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int inNombreMedecins = 0;
        int inNombrePatients = 0;
        System.out.println("Bienvenue dans votre hôpital !");
        System.out.print("Combien de médecin travaillent dans votre hôpital ? : ");
        while (inNombreMedecins < 1) {
            try {
                inNombreMedecins = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Veuillez entrer une valeur correcte : ");
                sc.nextLine();
            }
        }
        System.out.print("Combien de patients accueillerez-vous ? : ");
        while (inNombrePatients < 1) {
            try {
                inNombrePatients = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Veuillez entrer une valeur correcte : ");
                sc.nextLine();
            }
        }
        Hopital hopital = new Hopital(inNombreMedecins, inNombrePatients);
        int choix = -1;
        while (choix != 0) {

            System.out.println("Que faire ?");
            System.out.println("1 - Ajouter une personne");
            System.out.println("2 - Gestion des rendez-vous");
            System.out.println("3 - Chercher une personne");
            System.out.println("4 - Gestion des factures");
            System.out.println("5 - Historiques médicaux des patients");
            System.out.println("0 - Quitter");

            try {
                choix = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.print("Veuillez entrer une valeur correcte : ");
                sc.nextLine();
            }

            switch (choix) {
                case 1:
                    hopital.menuEnregistrement();
                    break;
                case 2:
                    hopital.menuRendezVous();
                    break;
                case 3:
                    hopital.menuRecherche();
                    break;
                case 4:
                    hopital.menuFactures();
                    break;
                case 5:
                    hopital.menuPatients();
                    break;
                case 0:
                    System.out.println("Aurevoir !");
                    break;
                default:
                    System.out.println("Veuillez entrer une valeur correcte.");
            }
        }
    }

    static GroupeSanguin convertirgroupeSanguin(String groupeSanguinString) {
        return switch (groupeSanguinString) {
            case "A+" -> GroupeSanguin.A_POSITIF;
            case "A-" -> GroupeSanguin.A_NEGATIF;
            case "B+" -> GroupeSanguin.B_POSITIF;
            case "B-" -> GroupeSanguin.B_NEGATIF;
            case "AB+" -> GroupeSanguin.AB_POSITIF;
            case "AB-" -> GroupeSanguin.AB_NEGATIF;
            case "O+" -> GroupeSanguin.O_POSITIF;
            default -> GroupeSanguin.O_NEGATIF;
        };
    }

    public void menuEnregistrement() {
        int choix = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Qui enregistrer ?");
        System.out.println("1 - Médecin");
        System.out.println("2 - fr.univartois.sae.hopital.model.Patient");
        System.out.println("0 - Revenir au menu principal");
        try {
            choix = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Veuillez entrer une valeur correcte.");
        }
        if (choix == 1) {
            String nom, prenom, numTel, specialisation;
            int age;
            System.out.print("Nom : ");
            nom = sc.nextLine();
            System.out.print("Prénom : ");
            prenom = sc.nextLine();
            System.out.print("Numéro de téléphone : ");
            numTel = sc.nextLine();
            System.out.print("Âge : ");
            age = sc.nextInt();
            sc.nextLine();
            System.out.print("Spécialisation : ");
            specialisation = sc.nextLine();
            enregistrerMedecin(new Medecin(nom, prenom, numTel, age, specialisation));
        } else if (choix == 2) {
            String nom, prenom, numTel, adresse;
            String groupeSanguin = "non-attributed";
            int age;
            System.out.print("Nom : ");
            nom = sc.nextLine();
            System.out.print("Prénom : ");
            prenom = sc.nextLine();
            System.out.print("Numéro de téléphone : ");
            numTel = sc.nextLine();
            System.out.print("Âge : ");
            age = sc.nextInt();
            sc.nextLine();
            System.out.print("Adresse : ");
            adresse = sc.nextLine();
            System.out.print("Groupe sanguin : ");
            while (!Objects.equals(groupeSanguin, "A+") && !Objects.equals(groupeSanguin, "A-") && !Objects.equals(groupeSanguin, "B+") && !Objects.equals(groupeSanguin, "B-") && !Objects.equals(groupeSanguin, "AB+") && !Objects.equals(groupeSanguin, "AB-") && !Objects.equals(groupeSanguin, "O+") && !Objects.equals(groupeSanguin, "O-")) {
                groupeSanguin = sc.nextLine();
            }
            enregistrerPatient(new Patient(nom, prenom, numTel, age, adresse, convertirgroupeSanguin(groupeSanguin)));
        } else if (choix == 0) {
            return;
        } else {
            System.out.println("Choix invalide.");
        }
    }

    public void menuRendezVous() {
        if (nombreMedecins == 0 || nombrePatients == 0) {
            System.out.println("Assurez-vous d'avoir au moins un médecin et un patient.");
        } else {
            int choix = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("Que faire ?");
            System.out.println("1 - Créer un rendez-vous");
            System.out.println("2 - Supprimer un rendez-vous");
            System.out.println("3 - Lister les rendez-vous");
            System.out.println("4 - Laisser un avis");
            System.out.println("0 - Revenir au menu principal");
            try {
                choix = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Veuillez entrer une valeur correcte.");
            }
            if (choix == 1) {
                Medecin medecin = null;
                Patient patient = null;
                String date, heure, motif;
                double prix;
                System.out.println("Quel médecin s'occupe du rendez-vous ?");
                afficherMedecins();
                try {
                    medecin = medecins[sc.nextInt() - 1];
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Veuillez entrer une valeur correcte.");
                    System.exit(1);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Veuillez entrer un index valide.");
                    System.exit(1);
                }
                System.out.println("Quel patient assiste au rendez-vous ?");
                afficherPatients();
                try {
                    patient = patients[sc.nextInt() - 1];
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Veuillez entrer une valeur correcte.");
                    System.exit(1);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Veuillez entrer un index valide.");
                    System.exit(1);
                }
                System.out.print("Date : ");
                date = sc.nextLine();
                System.out.print("Heure : ");
                heure = sc.nextLine();
                System.out.print("Motif : ");
                motif = sc.nextLine();
                System.out.print("Prix : ");
                prix = sc.nextDouble();
                sc.nextLine();
                prendreRendezVous(patient, medecin, date, heure, motif, prix);
                Ordonnance.ajouterOrdonnance(patient, medecin.getListeRendezVous()[medecin.getNombreRendezVous()]);
            } else if (choix == 2) {
                Medecin medecin = null;
                Patient patient = null;
                String date;
                System.out.println("Quel médecin s'occupe du rendez-vous ?");
                afficherMedecins();
                try {
                    medecin = medecins[sc.nextInt() - 1];
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Veuillez entrer une valeur correcte.");
                    System.exit(1);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Veuillez entrer un index valide.");
                    System.exit(1);
                }
                System.out.println("Quel patient assiste au rendez-vous ?");
                afficherPatients();
                try {
                    patient = patients[sc.nextInt() - 1];
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Veuillez entrer une valeur correcte.");
                    System.exit(1);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Veuillez entrer un index valide.");
                    System.exit(1);
                }
                System.out.print("Date : ");
                date = sc.nextLine();
                annulerRendezVous(patient, medecin, date);
            } else if (choix == 3) {
                Medecin medecin = null;
                System.out.println("Sélectionnez un médecin pour voir ses rendez-vous prévus.");
                afficherMedecins();
                try {
                    medecin = medecins[sc.nextInt() - 1];
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Veuillez entrer une valeur correcte.");
                    System.exit(1);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Veuillez entrer un index valide.");
                    System.exit(1);
                }
                this.listerRendezVous(medecin);
            } else if (choix == 4) {
                Patient patient = null;
                Medecin medecin = null;
                RendezVous rendezVous = null;
                String feedback;
                System.out.println("Qui êtes-vous ?");
                afficherPatients();
                try {
                    patient = patients[sc.nextInt() - 1];
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Veuillez entrer une valeur correcte.");
                    System.exit(1);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Veuillez entrer un index valide.");
                    System.exit(1);
                }
                System.out.println("Avec qui avez-vous eu rendez-vous ?");
                afficherMedecins();
                try {
                    medecin = medecins[sc.nextInt() - 1];
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Veuillez entrer une valeur correcte.");
                    System.exit(1);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Veuillez entrer un index valide.");
                    System.exit(1);
                }
                this.listerRendezVous(medecin);
                System.out.print("Veuillez sélectionner le rendez-vous à noter : ");
                try {
                    rendezVous = medecin.getListeRendezVous()[sc.nextInt() - 1];
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Veuillez entrer une valeur correcte.");
                    System.exit(1);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Veuillez entrer un index valide.");
                    System.exit(1);
                }
                System.out.println("Veuillez écrire votre avis :");
                feedback = sc.nextLine();
                patient.ajouterAvis(rendezVous, feedback);
            } else if (choix == 0) {
                return;
            } else {
                System.out.println("Choix invalide.");
            }
        }
    }

    public void menuRecherche() {
        if (!(nombreMedecins != 0 && nombrePatients != 0)) {
            System.out.println("Assurez-vous d'avoir au moins un médecin ou un patient.");
        } else {
            int choix = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("Quelle recherche effectuer ?");
            System.out.println("1 - Chercher par nom");
            System.out.println("2 - Chercher par nom complet");
            System.out.println("3 - Chercher par spécialisation");
            System.out.println("4 - Chercher par âge");
            System.out.println("0 - Revenir au menu principal");
            try {
                choix = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Veuillez entrer une valeur correcte.");
            }
            if (choix == 1) {
                System.out.print("Nom : ");
                String nom = sc.nextLine();
                rechercherPersonneParNom(nom);
            } else if (choix == 2) {
                System.out.print("Nom : ");
                String nom = sc.nextLine();
                System.out.println("Prénom : ");
                String prenom = sc.nextLine();
                rechercherPersonneParNomComplet(nom, prenom);
            } else if (choix == 3) {
                System.out.print("Spécialisation : ");
                String specialisation = sc.nextLine();
                rechercherMedecinParSpecialisation(specialisation);
            } else if (choix == 4) {
                System.out.print("Âge : ");
                int age = sc.nextInt();
                sc.nextLine();
                rechercherPersonneParAge(age);
            } else if (choix == 0) {
                return;
            } else {
                System.out.println("Choix invalide.");
            }
        }
    }

    public void menuFactures() {
        if (!(nombreMedecins != 0 && nombrePatients != 0)) {
            System.out.println("Assurez-vous d'avoir au moins un médecin ou un patient.");
        } else {
            int choix = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("Que faire ?");
            System.out.println("1 - Lister factures");
            System.out.println("2 - Payer une facture");
            System.out.println("0 - Revenir au menu principal");
            try {
                choix = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Veuillez entrer une valeur correcte.");
            }
            if (choix == 1) {
                Patient patient = null;
                System.out.println("Voir les factures de :");
                afficherPatients();
                try {
                    patient = patients[sc.nextInt() - 1];
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Veuillez entrer une valeur correcte.");
                    System.exit(1);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Veuillez entrer un index valide.");
                    System.exit(1);
                }
                patient.afficherEtatFactures();
            } else if (choix == 2) {
                Patient patient = null;
                Facture facture = null;
                System.out.println("Qui êtes-vous ?");
                afficherPatients();
                try {
                    patient = patients[sc.nextInt() - 1];
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Veuillez entrer une valeur correcte.");
                    System.exit(1);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Veuillez entrer un index valide.");
                    System.exit(1);
                }
                patient.afficherEtatFactures();
                System.out.print("Quelle facture payer ? : ");
                try {
                    facture = patient.getListeFactures()[sc.nextInt() - 1];
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Veuillez entrer une valeur correcte.");
                    System.exit(1);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Veuillez entrer un index valide.");
                    System.exit(1);
                }
                if (facture.isPayee()) {
                    System.out.println("Cette facture a déjà été payée.");
                } else {
                    patient.marquerFacturePayee(facture);
                    System.out.println("fr.univartois.sae.hopital.model.Facture payée avec succès.");
                }
            } else if (choix == 0) {
                return;
            } else {
                System.out.println("Choix invalide.");
            }
        }
    }

    public void menuPatients() {
        if (nombrePatients == 0) {
            System.out.println("Assurez-vous d'avoir au moins un patient.");
        } else {
            Patient patient = null;
            int choix = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("Sélectionnez le patient.");
            afficherPatients();
            try {
                patient = patients[sc.nextInt() - 1];
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Veuillez entrer une valeur correcte.");
                System.exit(1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Veuillez entrer un index valide.");
                System.exit(1);
            }
            patient.afficherHistorique();
        }
    }

    public void enregistrerMedecin(Medecin medecin) {
        if (nombreMedecins < NOMBRE_MAX_MEDECINS) {
            medecins[nombreMedecins] = medecin;
            personnes[nombreMedecins + nombrePatients] = medecin;
            nombreMedecins++;
        } else {
            System.out.println("Nombre maximal de médecins atteint.");
        }
    }

    public void enregistrerPatient(Patient patient) {
        if (nombrePatients < NOMBRE_MAX_PATIENTS) {
            patients[nombrePatients] = patient;
            personnes[nombrePatients + nombreMedecins] = patient;
            nombrePatients++;
        } else {
            System.out.println("Nombre maximal de patients atteint.");
        }
    }

    public void afficherMedecins() {
        System.out.println("Liste des médecins :");
        for (int i = 0; i < nombreMedecins; i++) {
            System.out.println((i + 1) + " " + medecins[i].toString());
        }
    }

    public void afficherPatients() {
        System.out.println("Liste des patients :");
        for (int i = 0; i < nombrePatients; i++) {
            System.out.println((i + 1) + " " + patients[i].toString());
        }
    }

    public void prendreRendezVous(Patient patient, Medecin medecin, String date, String heure, String motif, double prix) {
        if (medecin.getNombreRendezVous() < medecin.getNOMBRE_MAX_RENDEZVOUS()) {
            RendezVous rdv = new RendezVous(patient, medecin, date, heure, motif);
            medecin.getListeRendezVous()[medecin.getNombreRendezVous()] = rdv;
            medecin.incrementerNombreRendezVous();
            patient.getListeFactures()[patient.getNombreFactures() % patient.getNOMBRE_MAX_FACTURES()] = genererFacture(patient, medecin, date, prix);
            patient.incrementerNombreFactures();
            System.out
                    .println("Rendez-vous pris avec succès pour le " + date + " à " + heure + " entre " + patient.getNom() + " " + patient.getPrenom() + " et le Dr. " + medecin.getNom() + ".");
        } else {
            System.out.println("Impossible de prendre un rendez-vous, capacité maximale atteinte.");
        }
    }

    public void annulerRendezVous(Patient patient, Medecin medecin, String date) {
        boolean rendezVousTrouve = false;
        for (int i = 0; i < medecin.getNombreRendezVous(); i++) {
            if (medecin.getListeRendezVous()[i].getDate().equals(date) && medecin.getListeRendezVous()[i].getPatient() == patient) {
                rendezVousTrouve = true;
                System.out.println("Rendez-vous annulé avec succès.");
                for (int j = i; j < medecin.getNombreRendezVous() - 1; j++) {
                    medecin.getListeRendezVous()[j] = medecin.getListeRendezVous()[j + 1];
                }
                medecin.getListeRendezVous()[medecin.getNombreRendezVous() - 1] = null;
                medecin.decrementerNombreRendezVous();
            }
        }
        if (!rendezVousTrouve) {
            System.out.println("Aucun rendez-vous trouvé à cette date entre " + patient.getNom() + " " + patient.getPrenom() + " et le Dr. " + medecin.getNom() + ".");
        } else {
            for (int i = 0; i < patient.getNombreFactures(); i++) {
                if (patient.getListeFactures()[i].getDateConsultation().equals(date) && patient.getListeFactures()[i].getMedecin() == medecin) {
                    for (int j = i; j < patient.getNombreFactures() - 1; j++) {
                        patient.getListeFactures()[j] = patient.getListeFactures()[j + 1];
                    }
                    patient.getListeFactures()[patient.getNombreFactures() - 1] = null;
                    patient.decrementerNombreFactures();
                }
            }
        }
    }

    public void listerRendezVous(Medecin medecin) {
        System.out.println("Liste des rendez-vous de " + medecin.getNom() + " " + medecin.getPrenom() + " :");
        for (int i = 0; i < medecin.getNombreRendezVous(); i++) {
            RendezVous rdv = medecin.getListeRendezVous()[i];
            System.out.println((i + 1) + " - " + rdv.getPatient().getNom() + " " + rdv.getPatient().getPrenom() + " - " + rdv.getMedecin().getNom() +
                    " - " + rdv.getDate() + " - " + rdv.getHeure() + " - " + rdv.getMotif() + " - " + rdv.getFeedback());
        }
    }

    public void rechercherPersonneParNomComplet(String nom, String prenom) {
        boolean personneTrouvee = false;
        StringBuilder chainePersonnes = new StringBuilder();
        for (int i = 0; i < nombrePatients + nombreMedecins; i++) {
            if (personnes[i].getNom().equalsIgnoreCase(nom) && personnes[i].getPrenom().equalsIgnoreCase(prenom)) {
                chainePersonnes.append(personnes[i].afficherStatut());
                personneTrouvee = true;
            }
        }
        if (!personneTrouvee) {
            System.out.println("Aucune personne ne correspond à votre recherche.");
        } else {
            System.out.println("Liste des personnes trouvées : \n" + chainePersonnes.toString());
        }
    }

    public void rechercherPersonneParNom(String nom) {
        boolean personneTrouvee = false;
        StringBuilder chainePersonnes = new StringBuilder();
        for (int i = 0; i < nombrePatients + nombreMedecins; i++) {
            if (personnes[i].getNom().equalsIgnoreCase(nom)) {
                chainePersonnes.append(personnes[i].afficherStatut());
                personneTrouvee = true;
            }
        }
        if (!personneTrouvee) {
            System.out.println("Aucune personne ne correspond à votre recherche.");
        } else {
            System.out.println("Liste des personnes trouvées : \n" + chainePersonnes.toString());
        }
    }

    public void rechercherMedecinParSpecialisation(String specialisation) {
        boolean personneTrouvee = false;
        StringBuilder chainePersonnes = new StringBuilder();
        for (int i = 0; i < nombreMedecins; i++) {
            if (medecins[i].getSpecialisation().equalsIgnoreCase(specialisation)) {
                chainePersonnes.append(medecins[i].afficherStatut());
                personneTrouvee = true;
            }
        }
        if (!personneTrouvee) {
            System.out.println("Aucune personne ne correspond à votre recherche.");
        } else {
            System.out.println("Liste des personnes trouvées : \n" + chainePersonnes.toString());
        }
    }

    public void rechercherPersonneParAge(int age) {
        boolean personneTrouvee = false;
        StringBuilder chainePersonnes = new StringBuilder();
        for (int i = 0; i < nombreMedecins + nombrePatients; i++) {
            if (personnes[i].getAge() == age) {
                chainePersonnes.append(personnes[i].afficherStatut());
                personneTrouvee = true;
            }
        }
        if (!personneTrouvee) {
            System.out.println("Aucune personne ne correspond à votre recherche.");
        } else {
            System.out.println("Liste des personnes trouvées : \n" + chainePersonnes.toString());
        }
    }

    Facture genererFacture(Personne patient, Medecin medecin, String dateConsultation, double montantTotal) {
        return new Facture(patient, medecin, dateConsultation, montantTotal);
    }
}