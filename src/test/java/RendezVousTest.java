import fr.univartois.sae.hopital.model.HistoriqueMedical;
import fr.univartois.sae.hopital.model.Medecin;
import fr.univartois.sae.hopital.model.Patient;
import fr.univartois.sae.hopital.model.RendezVous;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RendezVousTest {

    @Test
    @DisplayName("devraitEnregistrerVisite")
    void devraitEnregistrerVisite() {
        Patient patient = mock(Patient.class);
        HistoriqueMedical historique = mock(HistoriqueMedical.class);
        when(patient.getHistoriqueMedical()).thenReturn(historique);

        Medecin medecin = mock(Medecin.class);

        // Création de l'objet à tester
        RendezVous rendezVous = new RendezVous("1", "Consultation", 50.0, patient, medecin, LocalDateTime.now());

        // Appel de la méthode à tester
        rendezVous.enregistrerVisite();

        // Vérification que la méthode ajouterRendezVous a été appelée sur l'historique médical
        verify(historique, times(1)).ajouterRendezVous(rendezVous);
    }

    @Test
    @DisplayName("devraitRetournerPrix")
    void devraitRetournerPrix() {
        Patient patient = mock(Patient.class);
        Medecin medecin = mock(Medecin.class);

        RendezVous rendezVous = new RendezVous("1", "Consultation", 50.0, patient, medecin, LocalDateTime.now());

        assertEquals(50.0, rendezVous.getPrix());
    }

    @Test
    @DisplayName("devraitRetournerRepresentationChaine")
    void devraitRetournerRepresentationChaine() {
        Patient patient = mock(Patient.class);
        when(patient.getNom()).thenReturn("Doe");

        Medecin medecin = mock(Medecin.class);
        when(medecin.getNom()).thenReturn("Smith");

        LocalDateTime dateHeure = LocalDateTime.of(2022, 1, 1, 10, 0);
        RendezVous rendezVous = new RendezVous("1", "Consultation", 50.0, patient, medecin, dateHeure);

        String expected = "Rendez-vous du 1/1/2022 à 10h0 : Consultation avec le Dr.Smith pour Doe";
        assertEquals(expected, rendezVous.toString());
    }
}