import fr.univartois.sae.hopital.model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PatientTest {

    private static Patient patient;

    @BeforeAll
    public static void initPatient() {

        patient = new Patient("1", "Doe", "John", GroupeSanguin.AB_NEGATIF, LocalDate.of(1990, 1, 1));
    }

    @Test
    @DisplayName("Marquer une facture comme payée")
    void testMarquerFacturePayee() {
        // Arrange
        Facture facture = new Facture("1", "Consultation", false);

        // Act
        patient.marquerFacturePayee(facture);

        // Assert
        assertTrue(facture.isPayee());
    }

    @Test
    @DisplayName("Afficher l'état des factures")
    void testAfficherEtatFactures() {
        // Arrange
        Facture facture1 = new Facture("1", "Consultation", false);
        Facture facture2 = new Facture("2", "Consultation", true);
        patient.ajouterFacture(facture1);
        patient.ajouterFacture(facture2);

        // Act
        String etatFactures = patient.afficherEtatFactures();

        // Assert
        System.out.println(etatFactures);
        assertEquals(facture1.toString() + "\n" + facture2.toString() + "\n", patient.afficherEtatFactures());
    }

    @Test
    @DisplayName("Afficher l'historique médical")
    void testAfficherHistoriqueMedical() {
        // Arrange
        RendezVous rendezVous = new RendezVous("1", "Consultation", 50.0, patient, new Medecin("1", "Doe", "Cardiologue", 50.0), LocalDateTime.now());
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
        RendezVous rendezVous = new RendezVous("1", "Consultation", 50.0, patient, new Medecin("1", "Doe", "Cardiologue", 50.0), LocalDateTime.now());
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
        String expected = "Doe John : AB_NEGATIF, né le 1990-01-01";

        // Act
        String actual = patient.toString();

        // Assert
        assertEquals(expected, actual);
    }
}
