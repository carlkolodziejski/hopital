import fr.univartois.sae.hopital.model.HistoriqueMedical;
import fr.univartois.sae.hopital.model.Medecin;
import fr.univartois.sae.hopital.model.Patient;
import fr.univartois.sae.hopital.model.RendezVous;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

class RendezVousTest {

    @Test
    @DisplayName("devraitEnregistrerVisite")
    void devraitEnregistrerVisite() {
        // Création des mocks
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
}