package fr.univartois.sae.hopital.controller;

import fr.univartois.sae.hopital.model.*;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Classe qui représente le contrôleur du menu de prise de rendez-vous.
 */
public class MenuRendezVousControleur implements IHopitalControleur {

    /**
     * La fenêtre de l'application.
     */
    private Stage stage;

    /**
     * L'hôpital controlé par l'application.
     */
    private Hopital hopital;

    /**
     * Composant représentant le bouton qui confirme la prise de rendez-vous.
     */
    @FXML
    private Button boutonPrendreRDV;

    /**
     * Composant représentant le champ de saisie de l'heure du rendez-vous.
     */
    @FXML
    private TextField champHeure;

    /**
     * Composant représentant le champ de saisie des minutes du rendez-vous.
     */
    @FXML
    private TextField champMinute;

    /**
     * Composant représentant le champ de saisie du motif du rendez-vous.
     */
    @FXML
    private TextArea champMotif;

    /**
     * Composant représentant le choix de la date du rendez-vous.
     */
    @FXML
    private DatePicker choixDate;

    /**
     * Composant représentant le choix du médecin pour le rendez-vous.
     */
    @FXML
    private ChoiceBox<Medecin> choixMedecin;

    /**
     * Composant permettant d'afficher un message d'erreur.
     */
    @FXML
    private Label message;

    /**
     * Permet de confirmer la prise de rendez-vous.
     */
    @FXML
    void onPrendreRDVButtonClick() {
        try {
            RendezVous rendezVous = definirRendezVous();
            rendezVous.enregistrerVisite();

            validerAjout();
        } catch (NumberFormatException | HeureInvalideException e) {
            message.setText("Veuillez saisir une heure et des minutes valides.");
        }
    }

    private void validerAjout() {
        choixMedecin.getSelectionModel().clearSelection();
        champHeure.clear();
        champMinute.clear();
        champMotif.clear();
        choixDate.getEditor().clear();
        message.setStyle("-fx-text-fill: green");
        message.setText("Rendez-vous pris avec succès.");
    }

    private RendezVous definirRendezVous() throws HeureInvalideException {
        String id = UUID.randomUUID().toString();
        Medecin medecin = choixMedecin.getValue();

        int heure = Integer.parseInt(champHeure.getText());
        int minute = Integer.parseInt(champMinute.getText());

        if (heure < 0 || heure > 23 || minute < 0 || minute > 59) throw new HeureInvalideException();

        String motif = champMotif.getText();
        LocalDate date = choixDate.getValue();

        return new RendezVous(id, motif, medecin.getTarif(), hopital.getPatientCourant(), medecin, date.atTime(heure, minute));
    }

    /**
     * Permet de revenir à la fenêtre précédente.
     */
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
     * @param hopital L'hôpital controlé
     */
    @Override
    public void setHopital(Hopital hopital) {
        this.hopital = hopital;

        choixMedecin.setItems(hopital.getMedecins());
    }


    /**
     * Initialise les composants de la vue.
     */
    @FXML
    void initialize() {
        boutonPrendreRDV.disableProperty().bind(
                choixDate.valueProperty().isNull()
                        .or(choixMedecin.valueProperty().isNull())
                        .or(champHeure.textProperty().isEmpty())
                        .or(champMinute.textProperty().isEmpty())
                        .or(champMotif.textProperty().isEmpty())
        );

        boutonPrendreRDV.styleProperty().bind(
                Bindings.when(boutonPrendreRDV.disableProperty())
                        .then("-fx-border-color: grey")
                        .otherwise("-fx-border-color: green")
        );
    }
}
