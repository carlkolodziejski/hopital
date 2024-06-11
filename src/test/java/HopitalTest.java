import fr.univartois.sae.hopital.model.Hopital;
import fr.univartois.sae.hopital.model.Medecin;
import fr.univartois.sae.hopital.model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HopitalTest {

    private Hopital hopital;

    @BeforeEach
    public void initHopital() {
        hopital = new Hopital();
    }

    @Test
    @DisplayName("Ajout d'un médecin")
    void ajouterMedecin() {
        Medecin medecin = mock(Medecin.class);
        hopital.ajouterMedecin(medecin);
        assertTrue(hopital.getMedecins().contains(medecin));
    }

    @Test
    @DisplayName("Ajout d'un patient")
    void ajouterPatient() {
        Patient patient = mock(Patient.class);
        hopital.ajouterPatient(patient);
        assertTrue(hopital.getPatients().contains(patient));
    }

    @Test
    @DisplayName("Suppression d'un patient")
    void supprimerPatient() {
        Patient patient = mock(Patient.class);
        hopital.ajouterPatient(patient);
        hopital.supprimerPatient(patient);
        assertFalse(hopital.getPatients().contains(patient));
    }

    @Test
    @DisplayName("Suppression d'un médecin")
    void supprimerMedecin() {
        Medecin medecin = mock(Medecin.class);
        hopital.ajouterMedecin(medecin);
        hopital.supprimerMedecin(medecin);
        assertFalse(hopital.getMedecins().contains(medecin));
    }

    @Test
    @DisplayName("Recherche des médecins par spécialisation")
    void rechercherParSpecialisation() {
        Medecin medecin = mock(Medecin.class);
        when(medecin.getSpecialisation()).thenReturn("Cardiologue");
        hopital.ajouterMedecin(medecin);
        assertTrue(hopital.rechercherParSpecialisation("Cardiologue").contains(medecin));
    }

    @Test
    @DisplayName("Recherche des personnes par nom")
    void rechercherParNom() {
        Medecin medecin = mock(Medecin.class);
        when(medecin.getNom()).thenReturn("Dr. Smith");
        hopital.ajouterMedecin(medecin);

        Patient patient = mock(Patient.class);
        when(patient.getNom()).thenReturn("Duchmol");
        hopital.ajouterPatient(patient);

        assertTrue(hopital.rechercherParNom("Dr. Smith").contains(medecin));
        assertTrue(hopital.rechercherParNom("Duchmol").contains(patient));
    }


    @Test
    @DisplayName("Obtenir le patient courant")
    void getPatientCourant() {
        Patient patient = mock(Patient.class);
        hopital.setPatientCourant(patient);
        assertEquals(patient, hopital.getPatientCourant());
    }

    @Test
    @DisplayName("Définir le patient courant")
    void setPatientCourant() {
        Patient patient = mock(Patient.class);
        hopital.setPatientCourant(patient);
        assertEquals(patient, hopital.getPatientCourant());
    }
    @Test
    @DisplayName("Mise à jour du nombre de personnes")
    void updateNbPersonnes() {
        Medecin medecin = mock(Medecin.class);
        hopital.ajouterMedecin(medecin);

        Patient patient = mock(Patient.class);
        hopital.ajouterPatient(patient);

        assertEquals(2, hopital.getNbPersonnes().get());
    }
    @Test
    @DisplayName("Affichage des médecins")
    void afficherMedecins() {
        Medecin medecin = mock(Medecin.class);
        when(medecin.toString()).thenReturn("Dr. Smith");
        hopital.ajouterMedecin(medecin);
        assertTrue(hopital.afficherMedecins().contains("Dr. Smith"));
    }

    @Test
    @DisplayName("Affichage des patients")
    void afficherPatients() {
        Patient patient = mock(Patient.class);
        when(patient.toString()).thenReturn("Duchmol");
        hopital.ajouterPatient(patient);
        assertTrue(hopital.afficherPatients().contains("Duchmol"));
    }

    @Test
    @DisplayName("Obtenir le nombre de médecins")
    void getNbMedecins() {
        Medecin medecin = mock(Medecin.class);
        hopital.ajouterMedecin(medecin);
        assertEquals(1, hopital.getNbMedecins().get());
    }

    @Test
    @DisplayName("Obtenir le nombre de patients")
    void getNbPatients() {
        Patient patient = mock(Patient.class);
        hopital.ajouterPatient(patient);
        assertEquals(1, hopital.getNbPatients().get());
    }
    @Test
    @DisplayName("Recherche des médecins par spécialisation non existante")
    void rechercherParSpecialisationNonExistante() {
        assertTrue(hopital.rechercherParSpecialisation("Non existante").isEmpty());
    }

    @Test
    @DisplayName("Recherche des personnes par nom non existant")
    void rechercherParNomNonExistant() {
        assertTrue(hopital.rechercherParNom("Non existant").isEmpty());
    }

    @Test
    @DisplayName("Suppression d'un médecin non existant")
    void supprimerMedecinNonExistant() {
        Medecin medecin = mock(Medecin.class);
        assertFalse(hopital.supprimerMedecin(medecin));
    }

}