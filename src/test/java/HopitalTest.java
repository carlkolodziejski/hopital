import fr.univartois.sae.hopital.model.Hopital;
import fr.univartois.sae.hopital.model.Medecin;
import fr.univartois.sae.hopital.model.Patient;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HopitalTest {

    private static Hopital hopital;

    @BeforeAll
    public static void initHopital() {
        hopital = new Hopital();
    }

    @BeforeEach
    public void resetHopital() {
        HopitalTest.initHopital();
    }

    @Test
    @DisplayName("Ajout d'un médecin")
    void testAjoutMedecin() {
        Medecin medecin = mock(Medecin.class);
        hopital.ajouterMedecin(medecin);
        assertTrue(hopital.getMedecins().contains(medecin));
    }

    @Test
    @DisplayName("Ajout d'un patient")
    void testAjoutPatient() {
        Patient patient = mock(Patient.class);
        hopital.ajouterPatient(patient);
        assertTrue(hopital.getPatients().contains(patient));
    }

    @Test
    @DisplayName("Affichage des médecins")
    void testAffichageMedecins() {
        Medecin medecin = mock(Medecin.class);
        when(medecin.toString()).thenReturn("Dr. Smith");

        hopital.ajouterMedecin(medecin);

        String affichageMedecins = hopital.afficherMedecins();

        assertTrue(affichageMedecins.contains("Dr. Smith"));
    }

    @Test
    @DisplayName("Affichage des patients")
    void testAffichagePatients() {
        Patient patient = mock(Patient.class);
        when(patient.toString()).thenReturn("Duchmol");

        hopital.ajouterPatient(patient);

        String affichagePatients = hopital.afficherPatients();

        assertTrue(affichagePatients.contains("Duchmol"));
    }

    @Test
    @DisplayName("Recherche des médecins par spécialisation")
    void testRechercheMedecinsParSpecialisation() {
        Medecin medecin = mock(Medecin.class);
        when(medecin.getSpecialisation()).thenReturn("Cardiologue");

        hopital.ajouterMedecin(medecin);

        assertTrue(hopital.rechercherParSpecialisation("Cardiologue").contains(medecin));
    }
}
