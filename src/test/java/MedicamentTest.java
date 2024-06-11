import fr.univartois.sae.hopital.model.Medicament;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MedicamentTest {
  private Medicament medicamentTest;
  @BeforeEach
  public void initMedicament() {
    medicamentTest = new Medicament("Doliprane", 7, 3);
  }
  @AfterEach
  public void invalideMedecin() {
    medicamentTest = null;
  }
  @Test
  @DisplayName("Test medecin toString()")
   void testMedicament() {
    assertEquals("Doliprane : 7, 3 par jour.", medicamentTest.toString());
  }
  @Test
  @DisplayName("Test medecin getNom()")
   void testMedicamentGetNom() {
    assertEquals("Doliprane", medicamentTest.getNom());
  }
  @Test
  @DisplayName("Test medecin getNombreJours()")
   void testMedicamentGetNombreJours() {
    assertEquals(7, medicamentTest.getNombreJours());
  }
  @Test
  @DisplayName("Test medecin getPosologie()")
   void testMedicamentGetPosologie() {
    assertEquals(3, medicamentTest.getPosologie());
  }

}
