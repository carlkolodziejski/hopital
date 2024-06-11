package fr.univartois.sae.hopital.controller;

import fr.univartois.sae.hopital.model.Hopital;
import fr.univartois.sae.hopital.model.IHopitalControleur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Classe qui représente le contrôleur du menu de gestion de patient.
 */
public class MenuGestionPatientControleur implements IHopitalControleur {
    /**
     * L'hôpital controlé par l'application.
     */
    private Hopital hopital;

    /**
     * La fenêtre de l'application.
     */
    private Stage stage;

    /**
     * Composant représentant le bouton pour afficher l'historique médical du patient.
     */
    @FXML
    private Button boutonAfficherHistoriqueMedical;

    /**
     * Composant représentant le bouton pour accéder à l'espace factures du patient.
     */
    @FXML
    private Button boutonEspaceFactures;

    /**
     * Composant représentant le prénom et le nom du patient.
     */
    @FXML
    private Label labelPrenomNomPatient;

    /**
     * Permet d'afficher l'historique médical du patient.
     */
    @FXML
    void onAfficherHistoriqueMedicalButtonClick(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/vue-menu-historique-medical.fxml"));
    }

    /**
     * Permet d'accéder à l'espace factures du patient.
     */
    @FXML
    void onEspaceFacturesButtonClick(ActionEvent event) {
        //TODO Accéder à l'espace factures du patient
    }

    /**
     * Permet au patient de prendre rendez-vous.
     */
    @FXML
    void onPrendreRDVButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/vue-menu-prendre-rdv.fxml"));
        Parent viewContent = fxmlLoader.load();

        MenuPriseRendezVousControleur menuPrendreRendezVousControleur = fxmlLoader.getController();
        menuPrendreRendezVousControleur.setStage(stage);
        menuPrendreRendezVousControleur.setHopital(hopital);

        Scene scene = new Scene(viewContent);
        stage.setScene(scene);
    }

    /**
     * Permet de retourner à la scène précédente.
     */
    @FXML
    void onRetourButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/vue-menu-selection-patient.fxml"));
        Parent viewContent = fxmlLoader.load();

        MenuSelectionnerPatientControleur menuSelectionnerPatientControleur = fxmlLoader.getController();
        menuSelectionnerPatientControleur.setStage(stage);
        menuSelectionnerPatientControleur.setHopital(hopital);
        menuSelectionnerPatientControleur.setListePatients();
        hopital.setPatientCourant(null);

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

        labelPrenomNomPatient.setText(hopital.getPatientCourant().getPrenom() + " " + hopital.getPatientCourant().getNom());
        boutonAfficherHistoriqueMedical.disableProperty().bind(hopital.getPatientCourant().getHistoriqueMedical().getNombreRendezVous().greaterThan(0).not());
    }
}
