import fr.univartois.sae.hopital.model.Medecin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedecinTest {
  private Medecin medecinTest;
  @BeforeEach
  public void initMedecin() {
    medecinTest = new Medecin("1", "Doe", "Cardiologue", 50.0);
  }
  @AfterEach
  public void invalideMedecin() {
    medecinTest = null;
  }

  @Test
  @DisplayName("Test Medecin get Specialisation ")
  public void testMedecinSpecialisation() {
    assertEquals("Cardiologue", medecinTest.getSpecialisation());
  }

  @Test
  @DisplayName("Test Medecin set Specialisation")
  public void testMedecinSetSpecialisation() {
    medecinTest.setSpecialisation("Pédiatre");
    assertEquals("Pédiatre", medecinTest.getSpecialisation());
  }
  @Test
  @DisplayName("Test Medecin toString()")
  public void testMedecinToString() {
    assertEquals("Dr. Doe : Cardiologue", medecinTest.toString());

  }

  @Test
  @DisplayName("Test Medecin Tarif")
  public void testMedecinTarif() {
    assertEquals(50.0, medecinTest.getTarif());
  }


}
