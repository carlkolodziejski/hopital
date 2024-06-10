package fr.univartois.sae.hopital.model;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Interface que doivent implémenter les contrôleurs de l'application.
 */
public interface IHopitalControleur {
    /**
     * Permet de définir l'hôpital contrôlé.
     *
     * @param hopital L'hôpital contrôlé.
     */
    void setHopital(Hopital hopital);

    /**
     * Permet de définir la fenêtre de l'application.
     *
     * @param stage La fenêtre de l'application.
     */
    void setStage(Stage stage);

    /**
     * Permet de définir la scène précédente.
     */
    void setScenePrecedente(Scene scenePrecedente);
}
