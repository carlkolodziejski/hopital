package fr.univartois.sae.hopital.controller;

import fr.univartois.sae.hopital.model.Hopital;
import fr.univartois.sae.hopital.model.IHopitalControleur;
import fr.univartois.sae.hopital.model.Medecin;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
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
     * Composant permettant l'affichage d'un message d'erreur.
     */
    @FXML
    private Label messageErreur;

    /**
     * Permet d'ajouter le médecin à la liste de médecins si les informations ont été correctement entrées.
     */
    @FXML
    void onAjouterMedecinButtonClick() {
        try {
            String id = UUID.randomUUID().toString();
            String nom = champNom.getText();
            String specialisation = champSpecialisation.getText();
            double tarif = Double.parseDouble(champSpecialisation.getText());

            hopital.ajouterMedecin(new Medecin(id, nom, specialisation, tarif));

            champNom.clear();
            champSpecialisation.clear();
        } catch (NumberFormatException e) {
            messageErreur.setText("Erreur de saisie sur le tarif.");
        }
    }

    /**
     * Permet de retourner à la scène précédente.
     */
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
     * Initialise les composants de la vue.
     */
    @FXML
    void initialize() {
        boutonAjouterMedecin.disableProperty().bind(champNom.textProperty().isEmpty().or(champSpecialisation.textProperty().isEmpty()));
        boutonAjouterMedecin.styleProperty().bind(
                Bindings.when(boutonAjouterMedecin.disableProperty())
                        .then("-fx-border-color: grey")
                        .otherwise("-fx-border-color: green"));
    }
}
