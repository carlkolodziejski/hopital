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
 * Classe qui représente le contrôleur du menu principal.
 */
public class MenuPrincipalControleur implements IHopitalControleur {

    /**
     * Composant représentant le bouton de recherche.
     */
    @FXML
    private Button boutonChercher;

    /**
     * L'hôpital controlé par l'application.
     */
    private Hopital hopital;

    /**
     * La fenêtre de l'application.
     */
    private Stage stage;

    /**
     * Renvoie l'utilisateur sur le menu de recherche.
     *
     * @throws IOException
     */
    @FXML
    void onChercherButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/vue-menu-recherche.fxml"));
        Parent viewContent = fxmlLoader.load();

        MenuRechercheControleur menuRechercheControleur = fxmlLoader.getController();
        menuRechercheControleur.setStage(stage);
        menuRechercheControleur.setScene(this.stage.getScene());
        menuRechercheControleur.setHopital(hopital);

        Scene scene = new Scene(viewContent);
        stage.setScene(scene);
    }

    /**
     * Renvoie l'utilisateur sur le menu de gestion des médecins.
     *
     * @throws IOException
     */
    @FXML
    void onMedecinButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/vue-menu-medecin.fxml"));
        Parent viewContent = fxmlLoader.load();

        MenuMedecinControleur menuMedecinControleur = fxmlLoader.getController();
        menuMedecinControleur.setStage(stage);
        menuMedecinControleur.setScene(this.stage.getScene());
        menuMedecinControleur.setHopital(hopital);

        Scene scene = new Scene(viewContent);
        stage.setScene(scene);
    }

    /**
     * Renvoie l'utilisateur sur le menu de gestion des patients.
     *
     * @throws IOException
     */
    @FXML
    void onPatientButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/vue-menu-patient.fxml"));
        Parent viewContent = fxmlLoader.load();

        MenuPatientControleur menuPatientControleur = fxmlLoader.getController();
        menuPatientControleur.setStage(stage);
        menuPatientControleur.setScene(this.stage.getScene());
        menuPatientControleur.setHopital(hopital);

        Scene scene = new Scene(viewContent);
        stage.setScene(scene);
    }

    /**
     * Définit l'hôpital contrôlé et lie les composants de la vue avec les données de l'hôpital.
     *
     * @param hopital L'hôpital contrôlé.
     */
    public void setHopital(Hopital hopital) {
        this.hopital = hopital;

        boutonChercher.disableProperty().bind(hopital.getNbPersonnes().isEqualTo(0));
    }

    /**
     * Définit la fenêtre de la vue.
     *
     * @param stage Le fenêtre de la vue.
     */
    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
