import fr.univartois.sae.hopital.model.Medicament;
import fr.univartois.sae.hopital.model.Ordonnance;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class OrdonnanceTest {

    private static Ordonnance ordonnance;

    @BeforeAll
    public static void initOrdonnance() {
        Medicament medicament = mock(Medicament.class);
        when(medicament.getNom()).thenReturn("Doliprane");
        when(medicament.getNombreJours()).thenReturn(7);
        when(medicament.getPosologie()).thenReturn(3);
        List<Medicament> medicaments = List.of(medicament);
        ordonnance = new Ordonnance("1", medicaments);
    }

    @BeforeEach
    public void resetOrdonnance() {
        OrdonnanceTest.initOrdonnance();
    }

    @Test
    @DisplayName("Prescription d'un médicament")
    void testPrescrire() {
        Medicament medicament = mock(Medicament.class);

        ordonnance.prescrire(medicament);

        assertTrue(ordonnance.getMedicaments().contains(medicament));
    }

    @Test
    @DisplayName("Affichage des médicaments")
    void testAfficherMedicaments() {
        Medicament medicament = mock(Medicament.class);
        when(medicament.toString()).thenReturn("Doliprane : 7 jours, 3 fois par jour.");
        ordonnance.prescrire(medicament);

        String affichageMedicaments = ordonnance.afficherMedicaments();

        assertTrue(affichageMedicaments.contains("Doliprane : 7 jours, 3 fois par jour."));
    }

    @Test
    @DisplayName("Affichage de l'ordonnance")
    void testAfficherOrdonnance() {
        Medicament medicament = mock(Medicament.class);
        when(medicament.toString()).thenReturn("Doliprane : 7 jours, 3 fois par jour.");
        ordonnance.prescrire(medicament);

        String affichageOrdonnance = ordonnance.toString();

        assertTrue(affichageOrdonnance.contains("1 : \nDoliprane : 7 jours, 3 fois par jour."));
    }
}
