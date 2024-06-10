package fr.univartois.sae.hopital.controller;

import fr.univartois.sae.hopital.model.Hopital;
import fr.univartois.sae.hopital.model.IHopitalControleur;
import fr.univartois.sae.hopital.model.Medecin;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.UUID;

public class MenuAjouterMedecinControleur implements IHopitalControleur {

    /**
     * L'hôpital controlé par l'application.
     */
    private Hopital hopital;

    /**
     * La fenêtre de l'application.
     */
    private Stage stage;

    /**
     * La scène précédente.
     */
    private Scene scenePrecedente;

    /**
     * Composant représentant le bouton d'ajout de médecin.
     */
    @FXML
    private Button boutonAjouterMedecin;

    /**
     * Composant représentant le champ de saisie du nom du médecin.
     */
    @FXML
    private TextField champNom;

    /**
     * Composant représentant le champ de saisie de la spécialisation du médecin.
     */
    @FXML
    private TextField champSpecialisation;

    /**
     * Permet d'ajouter le médecin à la liste de médecins si les informations ont été correctement entrées.
     */
    @FXML
    void onAjouterMedecinButtonClick() {
        String id = UUID.randomUUID().toString();
        System.out.println(id);
        String nom = champNom.getText();
        String specialisation = champSpecialisation.getText();
        hopital.ajouterMedecin(new Medecin(id, nom, specialisation));
    }

    /**
     * Permet de retourner à la scène précédente.
     */
    @FXML
    void onRetourButtonClick(ActionEvent event) {
        stage.setScene(scenePrecedente);
    }

    /**
     * Définit l'hôpital contrôlé.
     *
     * @param hopital L'hôpital contrôlé.
     */
    @Override
    public void setHopital(Hopital hopital) {
        this.hopital = hopital;
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
     * Définit la scène précédente.
     *
     * @param scenePrecedente La scène précédente.
     */
    @Override
    public void setScenePrecedente(Scene scenePrecedente) {
        this.scenePrecedente = scenePrecedente;
    }

    /**
     * Initialise les composants de la vue.
     */
    @FXML
    void initialize() {
        boutonAjouterMedecin.disableProperty().bind(champNom.textProperty().isEmpty().or(champSpecialisation.textProperty().isEmpty()));
        boutonAjouterMedecin.styleProperty().bind(
                Bindings.when(
                                champNom.textProperty().isEmpty().or(champSpecialisation.textProperty().isEmpty())
                        )
                        .then("-fx-border-color: green;")
                        .otherwise("-fx-border-color: grey;")
        );
    }
}
