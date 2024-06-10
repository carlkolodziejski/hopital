package fr.univartois.sae.hopital.controller;

import fr.univartois.sae.hopital.model.Hopital;
import fr.univartois.sae.hopital.model.IHopitalControleur;
import fr.univartois.sae.hopital.model.Medecin;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class MenuAfficherMedecinControleur implements IHopitalControleur {
    /**
     * La fenêtre de l'application.
     */
    private Stage stage;

    /**
     * La scène précédente.
     */
    private Scene scenePrecedente;

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
     *
     * @param hopital L'hôpital contrôlé.
     */
    public void setListeMedecins(Hopital hopital) {
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
     * Définit la scène précédente.
     *
     * @param scenePrecedente La scène précédente.
     */
    @Override
    public void setScenePrecedente(Scene scenePrecedente) {
        this.scenePrecedente = scenePrecedente;
    }

    /**
     * Permet de retourner à la scène précédente.
     */
    @FXML
    void onRetourButtonClick() {
        stage.setScene(scenePrecedente);
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
