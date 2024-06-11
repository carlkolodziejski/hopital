import fr.univartois.sae.hopital.model.Medecin;
import fr.univartois.sae.hopital.model.GroupeSanguin;
import fr.univartois.sae.hopital.model.Patient;
import fr.univartois.sae.hopital.model.Personne;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PersonneTest {


  @Test
  @DisplayName("Test de Personne") void testPersonneCreation() {
    Personne personne = new Medecin("M001", "Dr. House", "Cardiologie", 150.0);
    assertEquals("M001", personne.getId());
    assertEquals("Dr. House", personne.getNom());

    personne = new Patient("P001", "Doe", "John", GroupeSanguin.A_POSITIVE, LocalDate.of(1990, 5, 15));
    assertEquals("P001", personne.getId());
    assertEquals("Doe", personne.getNom());
  }

  @Test
  public void testAfficherStatut() {
    Personne medecin = new Medecin("M001", "Dr. House", "Cardiologie", 150.0);
    assertEquals("Dr. House, Médecin", medecin.afficherStatut());

    Personne patient = new Patient("P001", "Doe", "John", GroupeSanguin.A_POSITIVE, LocalDate.of(1990, 5, 15));
    assertEquals("Doe, Patient", patient.afficherStatut());
  }
}
