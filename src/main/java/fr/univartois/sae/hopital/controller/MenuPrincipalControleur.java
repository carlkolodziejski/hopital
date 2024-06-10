package fr.univartois.sae.hopital.controller;

import fr.univartois.sae.hopital.model.Hopital;
import fr.univartois.sae.hopital.model.IHopitalControleur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPrincipalControleur implements IHopitalControleur {

    @FXML
    private Button boutonChercher;

    private Hopital hopital;

    private Stage stage;

    @FXML
    void onChercherButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/vue-menu-recherche.fxml"));
        Parent viewContent = fxmlLoader.load();

        MenuRechercheControleur menuRechercheControleur = fxmlLoader.getController();
        menuRechercheControleur.setStage(stage);
        menuRechercheControleur.setScene(this.stage.getScene());
        menuRechercheControleur.setHopital(hopital);

        Scene scene = new Scene(viewContent);
        stage.setScene(scene);
    }

    @FXML
    void onMedecinButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/vue-menu-medecin.fxml"));
        Parent viewContent = fxmlLoader.load();

        MenuMedecinControleur menuMedecinControleur = fxmlLoader.getController();
        menuMedecinControleur.setStage(stage);
        menuMedecinControleur.setScene(this.stage.getScene());
        menuMedecinControleur.setHopital(hopital);

        Scene scene = new Scene(viewContent);
        stage.setScene(scene);
    }

    @FXML
    void onPatientButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/vue-menu-patient.fxml"));
        Parent viewContent = fxmlLoader.load();

        MenuPatientControleur menuPatientControleur = fxmlLoader.getController();
        menuPatientControleur.setStage(stage);
        menuPatientControleur.setScene(this.stage.getScene());
        menuPatientControleur.setHopital(hopital);

        Scene scene = new Scene(viewContent);
        stage.setScene(scene);
    }

    public void setHopital(Hopital hopital) {
        this.hopital = hopital;

        boutonChercher.disableProperty().bind(hopital.getNbPersonnes().isEqualTo(0));
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
