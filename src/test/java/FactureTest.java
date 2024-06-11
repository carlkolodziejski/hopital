import fr.univartois.sae.hopital.model.Facture;
//  Classe qui représente une facture

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactureTest {

    @Test
    @DisplayName("devraitCalculerCoutTotal")
    public void testCalculerCoutTotal() {
        Facture facture = new Facture("1", "Facture de test", false);
        facture.calculerCoutTotal();
        assertEquals(0, facture.getCoutTotal());
    }

    @Test
    @DisplayName("devraitRetournerDetails")
    public void devraitRetournerDetails() {
        Facture facture = new Facture("1", "details", false);
        assertEquals("details", facture.getDetails());
    }

    @Test
    @DisplayName("devraitRetournerStatutPaiement")
    public void devraitRetournerStatutPaiement() {
        Facture facture = new Facture("1", "details", false);
        assertFalse(facture.isPayee());
    }

    @Test
    @DisplayName("devraitChangerStatutPaiement")
    public void devraitChangerStatutPaiement() {
        Facture facture = new Facture("1", "details", false);
        facture.setPayee(true);
        assertTrue(facture.isPayee());
    }

}