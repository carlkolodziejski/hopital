package fr.univartois.sae.hopital.controller;

import fr.univartois.sae.hopital.model.Hopital;
import fr.univartois.sae.hopital.model.IHopitalControleur;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Classe qui représente le contrôleur du menu patients.
 */
public class MenuPatientControleur implements IHopitalControleur {
    /**
     * L'hôpital controlé par l'application.
     */
    private Hopital hopital;

    /**
     * La fenêtre de l'application.
     */
    private Stage stage;

    /**
     * Composant représentant le bouton d'ajout de patient.
     */
    @FXML
    private Button boutonGererPatients;

    /**
     * Renvoie l'utilisateur sur le menu d'ajout de patients.
     */
    @FXML
    void onAjouterPatientButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/vue-menu-ajouter-patient.fxml"));
        Parent viewContent = fxmlLoader.load();

        MenuAjouterPatientControleur menuAjouterPatientControleur = fxmlLoader.getController();
        menuAjouterPatientControleur.setStage(stage);
        menuAjouterPatientControleur.setHopital(hopital);

        Scene scene = new Scene(viewContent);
        stage.setScene(scene);
    }

    /**
     * Renvoie l'utilisateur sur le menu de gestion des patients.
     */
    @FXML
    void onGererPatientsButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/vue-menu-gestion-patients.fxml"));
        Parent viewContent = fxmlLoader.load();

        GererPatientsControleur gererPatientsControleur = fxmlLoader.getController();
        gererPatientsControleur.setStage(stage);
        gererPatientsControleur.setHopital(hopital);

        Scene scene = new Scene(viewContent);
        stage.setScene(scene);
    }

    /**
     * Renvoie l'utilisateur sur le menu principal.
     */
    @FXML
    void onRetourButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/vue-menu-principal.fxml"));
        Parent viewContent = fxmlLoader.load();

        MenuPrincipalControleur menuPrincipalControleur = fxmlLoader.getController();
        menuPrincipalControleur.setStage(stage);
        menuPrincipalControleur.setHopital(hopital);

        Scene scene = new Scene(viewContent);
        stage.setScene(scene);
    }

    /**
     * Définit la fenêtre de l'application.
     *
     * @param stage La fenêtre de l'application.
     */
    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Définit l'hôpital contrôlé.
     *
     * @param hopital L'hôpital contrôlé.
     */
    @Override
    public void setHopital(Hopital hopital) {
        this.hopital = hopital;

        boutonGererPatients.disableProperty().bind(hopital.getNbPatients().isEqualTo(0));
    }
}