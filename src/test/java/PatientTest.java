import fr.univartois.sae.hopital.model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PatientTest {

    private static Patient patient;

    @BeforeAll
    public static void initPatient() {
        patient = new Patient("1", "Duchmol", "Robert", GroupeSanguin.AB_NEGATIF, LocalDate.of(1990, 1, 1));
    }

    @BeforeEach
    public void setUp() {
        // Réinitialiser l'état du patient avant chaque test
        patient = new Patient("1", "Duchmol", "Robert", GroupeSanguin.AB_NEGATIF, LocalDate.of(1990, 1, 1));
    }

    @Test
    @DisplayName("Marquer une facture comme payée")
    void testMarquerFacturePayee() {
        // Arrange
        Facture facture = mock(Facture.class);

        // Act
        patient.marquerFacturePayee(facture);

        // Assert
        verify(facture).setPayee(true);
    }

    @Test
    @DisplayName("Afficher l'état des factures")
    void testAfficherEtatFactures() {
        // Arrange
        Facture facture1 = mock(Facture.class);
        Facture facture2 = mock(Facture.class);
        when(facture1.toString()).thenReturn("Facture 1");
        when(facture2.toString()).thenReturn("Facture 2");

        patient.ajouterFacture(facture1);
        patient.ajouterFacture(facture2);

        // Act
        String etatFactures = patient.afficherEtatFactures();

        // Assert
        System.out.println(etatFactures);
        assertEquals("Facture 1\nFacture 2\n", etatFactures);
    }

    @Test
    @DisplayName("Afficher l'historique médical")
    void testAfficherHistoriqueMedical() {
        // Arrange
        Medecin medecin = mock(Medecin.class);
        when(medecin.toString()).thenReturn("Dr. Duchmol");

        RendezVous rendezVous = new RendezVous("1", "Consultation", 50.0, patient, medecin, LocalDateTime.now());
        rendezVous.enregistrerVisite();

        // Act
        String historiqueMedical = patient.afficherHistoriqueMedical();

        // Assert
        assertEquals(rendezVous.toString() + "\n", historiqueMedical);
    }

    @Test
    @DisplayName("Retourner l'historique médical")
    void testGetHistoriqueMedical() {
        // Arrange
        Medecin medecin = mock(Medecin.class);
        when(medecin.toString()).thenReturn("Dr. Duchmol");

        RendezVous rendezVous = new RendezVous("1", "Consultation", 50.0, patient, medecin, LocalDateTime.now());
        rendezVous.enregistrerVisite();

        // Act
        HistoriqueMedical historiqueMedical = patient.getHistoriqueMedical();

        // Assert
        assertEquals(patient.getHistoriqueMedical(), historiqueMedical);
    }

    @Test
    @DisplayName("Test patient toString")
    void testPatientToString() {
        // Arrange
        String expected = "Duchmol Robert : AB_NEGATIF, né le 1990-01-01";

        // Act
        String actual = patient.toString();

        // Assert
        assertEquals(expected, actual);
    }
}
