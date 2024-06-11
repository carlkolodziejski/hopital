package fr.univartois.sae.hopital.controller;

import fr.univartois.sae.hopital.model.Hopital;
import fr.univartois.sae.hopital.model.IHopitalControleur;
import fr.univartois.sae.hopital.model.Medecin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuSelectionnerMedecinControleur implements IHopitalControleur {

    private Stage stage;
    private Hopital hopital;

    @FXML
    private ListView<Medecin> listeMedecins;

    @FXML
    private Label texteMedecinSelectionne;

    public void setListeMedecins() {
        listeMedecins.setItems(hopital.getMedecins());
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void setHopital(Hopital hopital) {
        this.hopital = hopital;
    }

    @FXML
    void onRetourButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/vue-menu-medecin.fxml"));
        Parent viewContent = fxmlLoader.load();

        MenuMedecinControleur menuMedecinControleur = fxmlLoader.getController();
        menuMedecinControleur.setStage(stage);
        menuMedecinControleur.setHopital(hopital);

        Scene scene = new Scene(viewContent);
        stage.setScene(scene);
    }

    @FXML
    void initialize() {
        listeMedecins.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, medecinChoisi) -> {
            if (medecinChoisi != null)
                texteMedecinSelectionne.setText(medecinChoisi.toString());
        });
    }

    // Méthode pour supprimer un médecin
    public void supprimerMedecin() {
        Medecin medecinASupprimer = listeMedecins.getSelectionModel().getSelectedItem();
        if (medecinASupprimer != null) {
            hopital.supprimerMedecin(medecinASupprimer); // Assurez-vous d'avoir une méthode supprimerMedecin dans la classe Hopital
            listeMedecins.getItems().remove(medecinASupprimer);
            texteMedecinSelectionne.setText("");
        }
    }

    @FXML
    void onSupprimerButtonClick(ActionEvent event) {
        supprimerMedecin();
    }
}
