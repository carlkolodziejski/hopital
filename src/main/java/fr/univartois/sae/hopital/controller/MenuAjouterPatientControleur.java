package fr.univartois.sae.hopital.controller;

import fr.univartois.sae.hopital.model.GroupeSanguin;
import fr.univartois.sae.hopital.model.Hopital;
import fr.univartois.sae.hopital.model.Patient;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Classe qui représente le contrôleur du menu d'ajout de patients.
 */
public class MenuAjouterPatientControleur {

    /**
     * La fenêtre de l'application.
     */
    private Stage stage;

    /**
     * L'hôpital controlé par l'application.
     */
    private Hopital hopital;

    /**
     * Le composant représentant le bouton d'ajout de médecin.
     */
    @FXML
    private Button boutonAjouterPatient;

    /**
     * Le composant représentant le champ de saisie du nom du patient.
     */
    @FXML
    private TextField champNom;

    /**
     * Le composant représentant le champ de saisie du prénom du patient.
     */
    @FXML
    private TextField champPrenom;

    /**
     * Le composant représentant le sélecteur de la date de naissance du patient.
     */
    @FXML
    private DatePicker choixDateNaissance;

    /**
     * Le composant représentant le sélecteur du groupe sanguin du patient.
     */
    @FXML
    private ChoiceBox<GroupeSanguin> choixGroupeSanguin;

    /**
     * Permet d'ajouter le patient à la liste de patients si les informations ont été correctement entrées.
     */
    @FXML
    void onAjouterPatientButtonClick() {
        String id = UUID.randomUUID().toString();
        String nom = champNom.getText();
        String prenom = champPrenom.getText();
        LocalDate dateNaissance = choixDateNaissance.getValue();
        GroupeSanguin groupeSanguin = choixGroupeSanguin.getValue();

        hopital.ajouterPatient(new Patient(id, nom, prenom, groupeSanguin, dateNaissance));

        champNom.clear();
        champPrenom.clear();
        choixDateNaissance.setValue(null);
        choixGroupeSanguin.setValue(null);
    }

    /**
     * Permet de retourner à la scène précédente.
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
    void initialize() {
        choixGroupeSanguin.getItems().setAll(GroupeSanguin.values());

        boutonAjouterPatient.disableProperty().bind(champNom.textProperty().isEmpty()
                .or(champPrenom.textProperty().isEmpty())
                .or(choixDateNaissance.valueProperty().isNull())
                .or(choixGroupeSanguin.valueProperty().isNull()));
        boutonAjouterPatient.styleProperty().bind(
                Bindings.when(boutonAjouterPatient.disableProperty())
                        .then("-fx-border-color: grey")
                        .otherwise("-fx-border-color: green")
        );
    }

    /**
     * Définit l'hôpital contrôlé.
     *
     * @param hopital L'hôpital contrôlé.
     */
    public void setHopital(Hopital hopital) {
        this.hopital = hopital;
    }

    /**
     * Définit la fenêtre de l'application.
     *
     * @param stage La fenêtre de l'application.
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
