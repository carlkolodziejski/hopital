package fr.univartois.sae.hopital.controller;

import fr.univartois.sae.hopital.model.Hopital;
import fr.univartois.sae.hopital.model.IHopitalControleur;
import fr.univartois.sae.hopital.model.RendezVous;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuRendezVousMedecinControleur implements IHopitalControleur {

    private Hopital hopital;

    private Stage stage;
    @FXML
    private Button boutonAjouterOrdonnance;
    @FXML
    private ListView<RendezVous> listeRDV;

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void setHopital(Hopital hopital) {
        this.hopital = hopital;
    }

    public void setListeRendezVous() {
        listeRDV.setItems(hopital.getMedecinCourant().getRendezVous());
    }

    @FXML
    void onAjoutOrdonnanceButtonClick() {
        // Non implémenté.
    }

    @FXML
    void onRetourButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/vue-menu-selection-medecin.fxml"));
        Parent viewContent = fxmlLoader.load();

        MenuSelectionnerMedecinControleur menuSelectionnerMedecinControleur = fxmlLoader.getController();
        menuSelectionnerMedecinControleur.setStage(stage);
        menuSelectionnerMedecinControleur.setHopital(hopital);
        menuSelectionnerMedecinControleur.setListeMedecins();
        hopital.setMedecinCourant(null);

        Scene scene = new Scene(viewContent);
        stage.setScene(scene);
    }
}
