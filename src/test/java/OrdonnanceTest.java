import fr.univartois.sae.hopital.model.Medicament;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrdonnanceTest {

  @Test
  public void testMedicamentCreation() {
    Medicament medicament = new Medicament("Aspirine", 5, 3);
    assertEquals("Aspirine", medicament.getNom());
    assertEquals(5, medicament.getNombreJours());
    assertEquals(3, medicament.getPosologie());
  }

  @Test
  public void testToString() {
    Medicament medicament = new Medicament("Paracétamol", 7, 2);
    String expected = "Paracétamol : 7, 2 par jour.";
    assertEquals(expected, medicament.toString());
  }
}
