import fr.univartois.sae.hopital.model.GroupeSanguin;
import fr.univartois.sae.hopital.model.Medecin;
import fr.univartois.sae.hopital.model.Patient;
import fr.univartois.sae.hopital.model.Personne;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonneTest {

    private static Personne medecin;
    private static Personne patient;

    @BeforeAll
    public static void initPersonnes() {
        medecin = new Medecin("1", "Duchmol", "Cardiologue", 50.0);
        patient = new Patient("2", "Doe", "John", GroupeSanguin.AB_NEGATIF, LocalDate.of(1990, 1, 1));
    }

    @BeforeEach
    public void resetPersonnes() {
        medecin = new Medecin("1", "Duchmol", "Cardiologue", 50.0);
        patient = new Patient("2", "Doe", "John", GroupeSanguin.AB_NEGATIF, LocalDate.of(1990, 1, 1));
    }

    @Test
    @DisplayName("Renvoyer le bon statut de la personne")
    void testPersonneStatut() {
        String statutMedecin = medecin.statut();
        String statutPatient = patient.statut();

        assertEquals("Médecin", statutMedecin);
        assertEquals("Patient", statutPatient);
    }

    @Test
    @DisplayName("Renvoyer le nom de la personne suivi de son statut")
    void testPersonneAfficherStatut() {
        String nomStatutMedecin = medecin.afficherStatut();
        String nomStatutPatient = patient.afficherStatut();

        assertEquals("Duchmol, Médecin", nomStatutMedecin);
        assertEquals("Doe, Patient", nomStatutPatient);
    }

    @Test
    @DisplayName("Renvoyer le nom de la personne")
    void testPersonneGetNom() {
        String nomMedecin = medecin.getNom();
        String nomPatient = patient.getNom();

        assertEquals("Duchmol", nomMedecin);
        assertEquals("Doe", nomPatient);
    }

    @Test
    @DisplayName("Renvoyer l'id de la personne")
    void testPersonneGetId() {
        String idMedecin = medecin.getId();
        String idPatient = patient.getId();

        assertEquals("1", idMedecin);
        assertEquals("2", idPatient);
    }

    @Test
    @DisplayName("Modifier le nom de la personne")
    void testPersonneSetNom() {
        medecin.setNom("Doe");
        patient.setNom("Duchmol");

        assertEquals("Doe", medecin.getNom());
        assertEquals("Duchmol", patient.getNom());
    }
}
