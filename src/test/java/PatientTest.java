import fr.univartois.sae.hopital.model.Facture;
import fr.univartois.sae.hopital.model.GroupeSanguin;
import fr.univartois.sae.hopital.model.Patient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PatientTest {
    @Test
    @DisplayName("Marquer une facture comme payée")
    void testMarquerFacturePayee() {
        // Arrange
        Facture facture = new Facture("1", "Consultation", false);
        Patient patient = new Patient("1", "Doe", "John", GroupeSanguin.A_NEGATIF, LocalDate.of(1990, 1, 1));

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
        Patient patient = new Patient("1", "Doe", "John", GroupeSanguin.AB_NEGATIF, LocalDate.of(1990, 1, 1));
        patient.ajouterFacture(facture1);
        patient.ajouterFacture(facture2);

        // Act
        List<String> etatFactures = patient.afficherEtatFactures();

        // Assert
        assertEquals(2, etatFactures.size());
        assertEquals("1 - Consultation - false", etatFactures.get(0));
        assertEquals("2 - Consultation - true", etatFactures.get(1));
    }
}
