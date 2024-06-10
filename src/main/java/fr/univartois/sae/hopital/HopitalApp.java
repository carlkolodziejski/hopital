package fr.univartois.sae.hopital;

import fr.univartois.sae.hopital.controller.MenuPrincipalControleur;
import fr.univartois.sae.hopital.model.Hopital;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Classe qui permet d'exécuter l'application de gestion d'un hôpital.
 *
 * @author Carl Kolodziejski
 * @author Clément GOUMZI
 * @version 0.2.0
 */
public class HopitalApp extends Application {

    public static void main(String[] args) {
        launch();
    }

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("./view/vue-menu-principal.fxml"));
        Parent viewContent = fxmlLoader.load();

        MenuPrincipalControleur menuPrincipalControleur = fxmlLoader.getController();
        menuPrincipalControleur.setStage(stage);

        Scene scene = new Scene(viewContent, 1280, 720);
        stage.setScene(scene);

        Hopital hopital = new Hopital();
        menuPrincipalControleur.setHopital(hopital);

        stage.setTitle("Mon hôpital");

        stage.show();
    }
}
