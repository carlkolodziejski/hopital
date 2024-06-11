package fr.univartois.sae.hopital.controller;

import fr.univartois.sae.hopital.model.Hopital;
import fr.univartois.sae.hopital.model.IHopitalControleur;
import fr.univartois.sae.hopital.model.RendezVous;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Classe qui représente le contrôleur du menu historique médical.
 */
public class MenuHistoriqueMedicalControleur implements IHopitalControleur {

    /**
     * La fenêtre de l'application.
     */
    private Stage stage;

    /**
     * L'hôpital controlé par l'application.
     */
    private Hopital hopital;

    /**
     * Composant représentant le bouton pour déposer un avis.
     */
    @FXML
    private Button boutonDeposerAvis;

    /**
     * Composant représentant la liste de rendez-vous présents dans l'historique médical.
     */
    @FXML
    private ListView<RendezVous> listeHistorique;


    @FXML
    void onDeposerAvisButtonClick(ActionEvent event) {

    }

    @FXML
    void onRetourButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/vue-menu-gestion-patient.fxml"));
        Parent viewContent = fxmlLoader.load();

        MenuGestionPatientControleur menuGestionPatientControleur = fxmlLoader.getController();
        menuGestionPatientControleur.setStage(stage);
        menuGestionPatientControleur.setHopital(hopital);

        Scene scene = new Scene(viewContent);
        stage.setScene(scene);
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
    void initialize() {
        listeHistorique.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, rendezVousChoisi) -> boutonDeposerAvis.setDisable(rendezVousChoisi == null));
    }

    public void setListeHistorique() {
        listeHistorique.setItems(hopital.getPatientCourant().getHistoriqueMedical().getHistoriqueRendezVous());
    }
}
