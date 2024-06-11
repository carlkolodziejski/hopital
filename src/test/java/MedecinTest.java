import fr.univartois.sae.hopital.model.Medecin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedecinTest {
    private Medecin medecinTest;

    @BeforeEach
    public void initMedecin() {
        medecinTest = new Medecin("1", "Duchmol", "Cardiologue", 50.0);
    }

    @AfterEach
    public void invalideMedecin() {
        medecinTest = null;
    }

    @Test
    @DisplayName("Test Medecin get Specialisation ")
    void testMedecinSpecialisation() {
        assertEquals("Cardiologue", medecinTest.getSpecialisation());
    }

    @Test
    @DisplayName("Test Medecin set Specialisation")
    void testMedecinSetSpecialisation() {
        medecinTest.setSpecialisation("Pédiatre");
        assertEquals("Pédiatre", medecinTest.getSpecialisation());
    }

    @Test
    @DisplayName("Test Medecin toString()")
    void testMedecinToString() {
        assertEquals("Dr. Duchmol : Cardiologue", medecinTest.toString());

    }

    @Test
    @DisplayName("Test Medecin Tarif")
    void testMedecinTarif() {
        assertEquals(50.0, medecinTest.getTarif());
    }


}
