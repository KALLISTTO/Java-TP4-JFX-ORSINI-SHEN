package isep.jfx;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Tooltip;
import java.awt.Desktop;

public class MainController {
    Integer nb[] = { 1, 2, 3, 4 };
    String HeroName[] = {"Warrior", "Mage", "Hunter", "Healer"};

    @FXML
    ChoiceBox HeroNumberChoice = new ChoiceBox(FXCollections.observableArrayList(nb));

    @FXML
    ChoiceBox HeroChoice1 = new ChoiceBox(FXCollections.observableArrayList(HeroName));
    @FXML
    ChoiceBox HeroChoice2 = new ChoiceBox(FXCollections.observableArrayList(HeroName));
    @FXML
    ChoiceBox HeroChoice3 = new ChoiceBox(FXCollections.observableArrayList(HeroName));
    @FXML
    ChoiceBox HeroChoice4 = new ChoiceBox(FXCollections.observableArrayList(HeroName));
    @FXML
    Button jouer = new Button();
    @FXML
    Hyperlink regles = new Hyperlink("Règles");
    @FXML
    Tooltip tooltip1 = new Tooltip("              HP      AP     DP\nWarrior  15        6        3\nMage     10        8        2\nHunter   10        6        2\nHealer    10        0        1");


    static public  List<String> heroesSelected = new ArrayList<String>();


    public void initialize(){
        disableChoice();
        setTooltip();
    }

    @FXML
    protected void Html() throws URISyntaxException, IOException {
        File htmlFile = new File("src/main/java/isep/util/index.html");
        Desktop.getDesktop().browse(htmlFile.toURI());
    }
    private void setTooltip(){
        HeroChoice1.setTooltip(tooltip1);
        HeroChoice2.setTooltip(tooltip1);
        HeroChoice3.setTooltip(tooltip1);
        HeroChoice4.setTooltip(tooltip1);
    }
    private void disableChoice() {
        HeroChoice1.setDisable(true);
        HeroChoice2.setDisable(true);
        HeroChoice3.setDisable(true);
        HeroChoice4.setDisable(true);
        HeroChoice1.setVisible(false);
        HeroChoice2.setVisible(false);
        HeroChoice3.setVisible(false);
        HeroChoice4.setVisible(false);
        jouer.setDisable(true);
    }

    @FXML
    protected void onStartButtonClick() throws IOException {

        if ( (int) HeroNumberChoice.getValue() == 1) {
            heroesSelected.add((String) HeroChoice1.getValue());
        } else if ( (int) HeroNumberChoice.getValue() == 2) {
            heroesSelected.add((String) HeroChoice1.getValue());
            heroesSelected.add((String) HeroChoice2.getValue());
        } else if ( (int) HeroNumberChoice.getValue() == 3) {
            heroesSelected.add((String) HeroChoice1.getValue());
            heroesSelected.add((String) HeroChoice2.getValue());
            heroesSelected.add((String) HeroChoice3.getValue());
        } else if ( (int) HeroNumberChoice.getValue() == 4){
            heroesSelected.add((String) HeroChoice1.getValue());
            heroesSelected.add((String) HeroChoice2.getValue());
            heroesSelected.add((String) HeroChoice3.getValue());
            heroesSelected.add((String) HeroChoice4.getValue());
        }

        // Affiche la fenêtre principale du jeu
        FXMLLoader fxmlLoader = new FXMLLoader
                (MainApplication.class.getResource("game-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        MainApplication.stage.setScene(scene);
        MainApplication.stage.show();
    }

    @FXML
    protected void HowManyHeroes() throws IOException {
        jouer.setDisable(true);
        if ((int) HeroNumberChoice.getValue() == 1) {
            HeroChoice1.setDisable(false);
            HeroChoice2.setDisable(true);
            HeroChoice3.setDisable(true);
            HeroChoice4.setDisable(true);
            HeroChoice1.setVisible(true);
            HeroChoice2.setVisible(false);
            HeroChoice3.setVisible(false);
            HeroChoice4.setVisible(false);
        } else if ((int) HeroNumberChoice.getValue() == 2) {
            HeroChoice1.setDisable(false);
            HeroChoice2.setDisable(true);
            HeroChoice3.setDisable(true);
            HeroChoice4.setDisable(true);
            HeroChoice1.setVisible(true);
            HeroChoice2.setVisible(true);
            HeroChoice3.setVisible(false);
            HeroChoice4.setVisible(false);
        } else if ((int) HeroNumberChoice.getValue() == 3) {
            HeroChoice1.setDisable(false);
            HeroChoice2.setDisable(true);
            HeroChoice3.setDisable(true);
            HeroChoice4.setDisable(true);
            HeroChoice1.setVisible(true);
            HeroChoice2.setVisible(true);
            HeroChoice3.setVisible(true);
            HeroChoice4.setVisible(false);
        } else if ((int) HeroNumberChoice.getValue() == 4) {
            HeroChoice1.setDisable(false);
            HeroChoice2.setDisable(true);
            HeroChoice3.setDisable(true);
            HeroChoice4.setDisable(true);
            HeroChoice1.setVisible(true);
            HeroChoice2.setVisible(true);
            HeroChoice3.setVisible(true);
            HeroChoice4.setVisible(true);
        }
    }

    @FXML
    protected void c1() throws IOException {
        HeroChoice2.setDisable(false);
        if ( (int) HeroNumberChoice.getValue() == 1) {
            jouer.setDisable(false);
        }
    }

    @FXML
    protected void c2() throws IOException {
        HeroChoice3.setDisable(false);
        if ( (int) HeroNumberChoice.getValue() == 2) {
            jouer.setDisable(false);
        }
    }

    @FXML
    protected void c3() throws IOException {
        HeroChoice4.setDisable(false);
        if ( (int) HeroNumberChoice.getValue() == 3) {
            jouer.setDisable(false);
        }
    }

    @FXML
    protected void c4() throws IOException {
        if ( (int) HeroNumberChoice.getValue() == 4) {
            jouer.setDisable(false);
        }
    }


}