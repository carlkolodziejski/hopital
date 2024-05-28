package fr.univartois.sae.hopital.model;

public abstract class Personne {
    private String nom, prenom, numTel;
    private int age;

    public Personne(String nom, String prenom, String numTel, int age) {
        if (age < 1) {
            System.out.println("Veuillez entrer un âge valide pour " + nom + " " + prenom + ".");
            System.exit(1);
        } else {
            this.nom = nom;
            this.prenom = prenom;
            this.numTel = numTel;
            this.age = age;
        }
    }

    public String statut() {
        if (this instanceof Medecin) {
            return "Médecin";
        } else {
            return "fr.univartois.sae.hopital.model.Patient";
        }
    }

    public String afficherStatut() {
        return getNom() + " " + getPrenom() + ", " + statut() + "\n";
    }

    public String afficherAge() {
        if (age == 1) {
            return age + " an";
        } else {
            return age + " ans";
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract String toString();
}
