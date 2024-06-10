package fr.univartois.sae.hopital.controller;

import fr.univartois.sae.hopital.model.Hopital;
import fr.univartois.sae.hopital.model.IHopitalControleur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuPrincipalControleur implements IHopitalControleur {

    @FXML
    private Button boutonChercher;

    private Hopital hopital;

    private Stage stage;

    @FXML
    void onChercherButtonClick(ActionEvent event) {

    }

    @FXML
    void onMedecinButtonClick(ActionEvent event) {

    }

    @FXML
    void onPatientButtonClick(ActionEvent event) {

    }

    public void setHopital(Hopital hopital) {
        this.hopital = hopital;
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
