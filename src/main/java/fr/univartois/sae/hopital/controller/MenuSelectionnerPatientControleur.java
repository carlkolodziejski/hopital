package fr.univartois.sae.hopital.controller;

import fr.univartois.sae.hopital.model.Hopital;
import fr.univartois.sae.hopital.model.IHopitalControleur;
import fr.univartois.sae.hopital.model.Patient;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Classe qui représente le contrôleur du menu de sélection de patient.
 */
public class MenuSelectionnerPatientControleur implements IHopitalControleur {

    /**
     * L'hôpital controlé par l'application.
     */
    private Hopital hopital;

    /**
     * La fenêtre de l'application.
     */
    private Stage stage;

    /**
     * Composant représentant le bouton pour confirmer la sélection du patient.
     */
    @FXML
    private Button boutonSelectionner;

    /**
     * Composant représentant le bouton pour supprimer un patient.
     */
    @FXML
    private Button boutonSupprimer;

    /**
     * Composant représentant la liste des patients.
     */
    @FXML
    private ListView<Patient> listePatients;

    /**
     * Permet de revenir à la fenêtre précédente.
     */
    @FXML
    void onRetourButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/vue-menu-patient.fxml"));
        Parent viewContent = fxmlLoader.load();

        MenuPatientControleur menuPatientControleur = fxmlLoader.getController();
        menuPatientControleur.setStage(stage);
        menuPatientControleur.setHopital(hopital);

        Scene scene = new Scene(viewContent);
        stage.setScene(scene);
    }

    @FXML
    void onSupprimerButtonClick() {
        Patient patientChoisi = listePatients.getSelectionModel().getSelectedItem();
        hopital.getPatients().remove(patientChoisi);
    }

    /**
     * Permet de confirmer la sélection d'un patient.
     */
    @FXML
    void onSelectionnerPatientButtonClick() throws IOException {
        Patient patientChoisi = listePatients.getSelectionModel().getSelectedItem();
        hopital.setPatientCourant(patientChoisi);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/vue-menu-gestion-patient.fxml"));
        Parent viewContent = fxmlLoader.load();

        MenuGestionPatientControleur menuGestionPatientControleur = fxmlLoader.getController();
        menuGestionPatientControleur.setStage(stage);
        menuGestionPatientControleur.setHopital(hopital);

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
     * Définit l'hôpital controlé.
     *
     * @param hopital L'hôpital controlé.
     */
    @Override
    public void setHopital(Hopital hopital) {
        this.hopital = hopital;
    }

    public void setListePatients() {
        listePatients.setItems(hopital.getPatients());
    }

    @FXML
    void initialize() {
        listePatients.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, patientChoisi) -> boutonSelectionner.setDisable(patientChoisi == null));
        listePatients.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, patientChoisi) -> boutonSupprimer.setDisable(patientChoisi == null));
        boutonSelectionner.styleProperty().bind(
                Bindings.when(boutonSelectionner.disableProperty())
                        .then("-fx-border-color: grey")
                        .otherwise("-fx-border-color: green")
        );
    }
}
