import fr.univartois.sae.hopital.model.Facture;
//  Classe qui représente une facture

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactureTest {

    @Test
    @DisplayName("tester calculerCoutTotal")
    public void testCalculerCoutTotal() {
        Facture facture = new Facture("1", "Facture de test", false);
        facture.calculerCoutTotal();
        assertEquals(150.0, facture.getCoutTotal());
    }
}