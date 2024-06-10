package fr.univartois.sae.hopital.controller;

import fr.univartois.sae.hopital.model.Hopital;
import fr.univartois.sae.hopital.model.IHopitalControleur;
import fr.univartois.sae.hopital.model.Medecin;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuAfficherMedecinControleur implements IHopitalControleur {
    /**
     * La fenêtre de l'application.
     */
    private Stage stage;

    /**
     * L'hôpital controlé par l'application.
     */
    private Hopital hopital;

    /**
     * Composant représentant la liste des médecins.
     */
    @FXML
    private ListView<Medecin> listeMedecins;

    /**
     * Composant représentant le texte du médecin sélectionné.
     */
    @FXML
    private Label texteMedecinSelectionne;

    /**
     * Définit l'hôpital contrôlé.
     */
    public void setListeMedecins() {
        listeMedecins.setItems(hopital.getMedecins());
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
    }


    /**
     * Permet de retourner à la scène précédente.
     */
    @FXML
    void onRetourButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/vue-menu-medecin.fxml"));
        Parent viewcontent = fxmlLoader.load();

        MenuMedecinControleur menuMedecinControleur = fxmlLoader.getController();
        menuMedecinControleur.setStage(stage);
        menuMedecinControleur.setHopital(hopital);

        Scene scene = new Scene(viewcontent);
        stage.setScene(scene);
    }

    /**
     * Initialise les composants de la vue.
     */
    @FXML
    void initialize() {
        listeMedecins.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, medecinChoisi) -> {
            if (medecinChoisi != null)
                texteMedecinSelectionne.setText(medecinChoisi.toString());
        });
    }
}
