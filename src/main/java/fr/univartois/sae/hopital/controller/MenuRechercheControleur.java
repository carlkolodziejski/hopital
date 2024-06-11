package fr.univartois.sae.hopital.controller;

import fr.univartois.sae.hopital.model.Hopital;
import fr.univartois.sae.hopital.model.IHopitalControleur;
import fr.univartois.sae.hopital.model.Medecin;
import fr.univartois.sae.hopital.model.Personne;
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MenuRechercheControleur implements IHopitalControleur {

  /**
   * La fenêtre de l'application.
   */
  private Stage stage;
  /**
   * L'hôpital controlé par l'application.
   */
  private Hopital hopital;
  /**
   * Le composant représentant le champ de saisie de recherche d'un nom.
   */
  @FXML
  private TextField rechercheNom;
  /**
   * Le composant représentant le champ de saisie de recherche d'une specialisation.
   */
  @FXML
  private TextField rechercheSpe;
  /**
   * Le composant représentant le resultat de la recherche.
   */
  @FXML
  private Label resultat;

  /**
   * Permet de retourner à la scène précédente.
   */
  @FXML
  void onRetourButtonClick(ActionEvent event) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(
        getClass().getResource("../view/vue-menu-principal.fxml"));
    Parent viewContent = fxmlLoader.load();

    MenuPrincipalControleur menuPrincipalControleur = fxmlLoader.getController();
    menuPrincipalControleur.setStage(stage);
    menuPrincipalControleur.setHopital(hopital);

    Scene scene = new Scene(viewContent);
    stage.setScene(scene);
  }

  /**
   * Méthode pour rechercher des médecins par spécialisation et retourner les résultats sous forme
   * de chaîne de caractères.
   */
  public String rechercheSpe() {
    StringBuilder sb = new StringBuilder();
    String spe = rechercheSpe.getText();
    ObservableList<Medecin> medecins = hopital.rechercherParSpecialisation(spe);
    if (medecins != null) {
      for (int i = 0; i < medecins.size(); i++) {
        sb.append(medecins.get(i).toString()).append("\n");
      }
    }
    return sb.toString();
  }

  /**
   * Méthode pour rechercher des personnes par nom et retourner les résultats sous forme de chaîne
   * de caractères.
   */
  public String rechercheNom() {
    StringBuilder sb = new StringBuilder();
    String nom = rechercheNom.getText();
    ObservableList<Personne> noms = hopital.rechercherParNom(nom);
    if (noms != null) {
      for (int i = 0; i < noms.size(); i++) {
        sb.append(noms.get(i).toString()).append("\n");
      }
    }
    return sb.toString();
  }

  /**
   * Méthode appelée pour rechercher par nom et spécialisation et affiche les résultats.
   */
  @FXML
  void onValiderButtonClick(ActionEvent event) {
    String nom = rechercheNom.getText();
    String spe = rechercheSpe.getText();
    ObservableList<Medecin> medecins = hopital.rechercherParSpecialisation(spe);
    ObservableList<Personne> noms = hopital.rechercherParNom(nom);
    if ((medecins != null && !medecins.isEmpty()) || (noms != null && !noms.isEmpty())) {
      resultat.setText(rechercheSpe() + "\n" + rechercheNom());
    } else {
      resultat.setText("Aucun médecin ou patient trouvé.");
    }
  }

  /**
   * Définit la fenêtre de l'application.
   *
   * @param stage La fenêtre de l'application.
   */
  public void setStage(Stage stage) {
    this.stage = stage;
  }

  /**
   * Définit l'hôpital contrôlé.
   *
   * @param hopital L'hôpital contrôlé.
   */
  public void setHopital(Hopital hopital) {
    this.hopital = hopital;
  }
}
