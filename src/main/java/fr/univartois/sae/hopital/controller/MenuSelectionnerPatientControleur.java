package fr.univartois.sae.hopital.controller;

import fr.univartois.sae.hopital.model.Hopital;
import fr.univartois.sae.hopital.model.IHopitalControleur;
import fr.univartois.sae.hopital.model.Patient;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

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
    private Button boutonSelectionnerPatient;

    /**
     * Composant représentant la liste des patients.
     */
    @FXML
    private ListView<Patient> listePatients;

    /**
     * Permet de revenir à la fenêtre précédente.
     */
    @FXML
    void onRetourButtonClick() {

    }

    /**
     * Permet de confirmer la sélection d'un patient.
     */
    @FXML
    void onSelectionnerPatientButtonClick() {

    }

    /**
     * Définit la fenêtre de l'application.
     *
     * @param stage La fenêtre de l'application.
     */
    @Override
    public void setStage(Stage stage) {

    }

    /**
     * Définit l'hôpital controlé.
     *
     * @param hopital L'hôpital controlé.
     */
    @Override
    public void setHopital(Hopital hopital) {

    }

    public void setListePatients() {
        listePatients.setItems(hopital.getPatients());
    }

    @FXML
    void initialize() {
        listePatients.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, patientChoisi) -> boutonSelectionnerPatient.setDisable(patientChoisi == null));
        boutonSelectionnerPatient.styleProperty().bind(
                Bindings.when(boutonSelectionnerPatient.disableProperty())
                        .then("-fx-border-color: grey")
                        .otherwise("-fx-border-color: green")
        );
    }
}
