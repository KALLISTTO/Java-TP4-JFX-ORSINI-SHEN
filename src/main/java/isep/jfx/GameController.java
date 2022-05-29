package isep.jfx;

import isep.rpg.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;
import java.io.FileInputStream;


public class GameController {

    @FXML
    ListView<String> heroList;
    @FXML
    ListView<String> enemyList;
    @FXML
    Text statusInformation = new Text();
    @FXML
    Button statusButton,attackButton,defendButton,armorButton,weaponButton,healButton,manaButton,numbButton,costButton;

    public GameController() throws FileNotFoundException {
    }


    // "initialize()" est appelé par JavaFX à l'affichage de la fenêtre
    @FXML
    public void initialize() {
        Game.playGame();
        updateListViews();
        updateFightButton();
        invisible();

    }

    private void invisible() {
        armorButton.setVisible(false);
        weaponButton.setVisible(false);
        healButton.setVisible(false);
        manaButton.setVisible(false);
        numbButton.setVisible(false);
        costButton.setVisible(false);
    }


    private void updateListViews () {
        heroList.getItems().setAll(Game.context.getHeroesStatus());
        enemyList.getItems().setAll(Game.context.getEnemiesStatus());
    }
    private void updateHeroListViews() {
        heroList.getItems().setAll(Game.context.getHeroesStatus());
    }

    /*
    Logos en cours

    Image ennemi = new Image(new FileInputStream("Java-TP4-JFX-main\\src\\main\\java\\isep\\util\\Logos\\ennemi.png"));

    private Image[] listOfImages = {ennemi};
    private void Images () {
        heroList.setCellFactory(param -> new ListCell<String>() {
            private ImageView imageView = new ImageView();
            @Override
            public void updateItem(String name, boolean empty) {
                super.updateItem(name, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else if(name.equals("Warrior ( HP= 5  | DP= 3  | AP= 5 )")) {
                        imageView.setImage(listOfImages[0]);
                    setText(name);
                    setGraphic(imageView);
                }
            }
        });
    }
    **/
    // L'action du bouton change en fonction de l'état du jeu
    static int what;
    public static int getWhat() {
        return what;
    }
    int i=0;
    private void updateFightButton() {
        switch (Game.context.status) {
            case START_COMBAT:
                attackButton.setText("Attaquer");
                if (Game.getUpgradeReinitialization()>0) {
                    if (i==0) {
                        statusButton.setDisable(true);
                        armorButton.setVisible(false);
                        weaponButton.setVisible(false);
                        healButton.setVisible(false);
                        manaButton.setVisible(false);
                        costButton.setVisible(false);
                        numbButton.setVisible(false);
                        statusButton.setDisable(false);
                        attackButton.setDisable(true);
                        defendButton.setDisable(true);
                    }
                    Game.context.nextUpgrade();
                    updateFightButton();
                } else {
                    armorButton.setVisible(false);
                    weaponButton.setVisible(false);
                    healButton.setVisible(false);
                    manaButton.setVisible(false);
                    costButton.setVisible(false);
                    numbButton.setVisible(false);
                    statusButton.setDisable(false);
                    attackButton.setDisable(true);
                    defendButton.setDisable(true);
                    statusButton.setText("Démarrer le combat !");
                    statusInformation.setText(String.format("Lancer le combat %d !", Game.getCombat()));
                    statusButton.setOnAction(event -> {
                        updateListViews();
                        Game.context.startNextFighterTurn();
                        updateFightButton();
                    });
                }
                break;
            case WARRIOR:
                statusInformation.setText(String.format("%s: Choisir une amélioration",Game.context.getCurrentHero()));
                statusButton.setDisable(true);
                armorButton.setVisible(true);
                weaponButton.setVisible(true);
                healButton.setVisible(true);
                manaButton.setVisible(false);
                costButton.setVisible(false);
                numbButton.setVisible(false);
                weaponButton.setOnAction(event -> {
                    Game.context.weaponUpgrade(Game.context.currentHero);
                    updateHeroListViews();
                    Game.context.getstartCombat();
                    updateFightButton();
                });
                armorButton.setOnAction(event -> {
                    Game.context.armorUpgrade(Game.context.currentHero);
                    updateHeroListViews();
                    Game.context.getstartCombat();
                    updateFightButton();
                });
                healButton.setOnAction(event -> {
                    Game.context.lifeUpgrade((Game.context.currentHero));
                    updateHeroListViews();
                    Game.context.getstartCombat();
                    updateFightButton();
                });
                break;
            case HUNTER:
                statusInformation.setText(String.format("%s: Choisir une amélioration",Game.context.getCurrentHero()));
                statusButton.setDisable(true);
                numbButton.setVisible(true);
                armorButton.setVisible(true);
                weaponButton.setVisible(true);
                healButton.setVisible(false);
                manaButton.setVisible(false);
                costButton.setVisible(false);
                weaponButton.setOnAction(event -> {
                    Game.context.weaponUpgrade(Game.context.currentHero);
                    updateHeroListViews();
                    Game.context.getstartCombat();
                    updateFightButton();
                });
                armorButton.setOnAction(event -> {
                    Game.context.armorUpgrade(Game.context.currentHero);
                    updateHeroListViews();
                    Game.context.getstartCombat();
                    updateFightButton();
                });
                healButton.setOnAction(event -> {
                    Game.context.lifeUpgrade((Game.context.currentHero));
                    updateHeroListViews();
                    Game.context.getstartCombat();
                    updateFightButton();
                });
                numbButton.setOnAction(event -> {
                    Game.context.arrowUpgrade((Hunter) Game.context.currentHero);
                    updateHeroListViews();
                    Game.context.getstartCombat();
                    updateFightButton();
                });
                break;
            case SPELLCASTERS:
                statusInformation.setText(String.format("%s: Choisir une amélioration",Game.context.getCurrentHero()));
                statusButton.setDisable(true);
                numbButton.setVisible(false);
                armorButton.setVisible(true);
                weaponButton.setVisible(true);
                healButton.setVisible(true);
                manaButton.setVisible(true);
                costButton.setVisible(true);
                weaponButton.setOnAction(event -> {
                    Game.context.weaponUpgrade(Game.context.currentHero);
                    updateHeroListViews();
                    Game.context.getstartCombat();
                    updateFightButton();
                });
                armorButton.setOnAction(event -> {
                    Game.context.armorUpgrade(Game.context.currentHero);
                    updateHeroListViews();
                    Game.context.getstartCombat();
                    updateFightButton();
                });
                healButton.setOnAction(event -> {
                    Game.context.lifeUpgrade((Game.context.currentHero));
                    updateHeroListViews();
                    Game.context.getstartCombat();
                    updateFightButton();
                });
                manaButton.setOnAction(event -> {
                    Game.context.manaUpgrade((SpellCaster) Game.context.currentHero);
                    updateHeroListViews();
                    Game.context.getstartCombat();
                    updateFightButton();
                });
                costButton.setOnAction(event -> {
                    Game.context.costUpgrade((SpellCaster) Game.context.currentHero);
                    updateHeroListViews();
                    Game.context.getstartCombat();
                    updateFightButton();
                });
                break;
            case HEALER:
                updateListViews();
                i=0;
                attackButton.setText("Soigner");
                attackButton.setDisable(false);
                defendButton.setDisable(false);
                statusInformation.setText(String.format("%s, à vous de jouer !", Game.context.getCurrentFighter()));
                statusButton.setText("Soigner ou Défendre");
                statusButton.setDisable(true);
                attackButton.setOnAction( event -> {
                    what = 0;
                    Game.context.startHeroTurn();
                    updateListViews();
                    Game.context.startNextFighterTurn();
                    updateFightButton();
                } );
                defendButton.setOnAction( event -> {
                    what = 1;
                    Game.context.startHeroTurn();
                    updateListViews();
                    Game.context.startNextFighterTurn();
                    updateFightButton();
                } );
                break;
            case HERO_TURN:
                attackButton.setText("Attaquer");
                updateListViews();
                i=0;
                attackButton.setDisable(false);
                defendButton.setDisable(false);
                statusInformation.setText(String.format("%s, à vous de jouer !", Game.context.getCurrentFighter()));
                statusButton.setText("Attaquer ou Défendre");
                statusButton.setDisable(true);
                attackButton.setOnAction( event -> {
                    what = 0;
                    Game.context.startHeroTurn();
                    updateListViews();
                    Game.context.startNextFighterTurn();
                    updateFightButton();
                    } );
                defendButton.setOnAction( event -> {
                    what = 1;
                    Game.context.startHeroTurn();
                    updateListViews();
                    Game.context.startNextFighterTurn();
                    updateFightButton();
                } );
                break;
            case ENEMY_TURN:
                updateListViews();
                i=0;
                statusButton.setDisable(false);
                statusInformation.setText("L'ennemi attaque !");
                statusButton.setText("Suivant");
                attackButton.setDisable(true);
                defendButton.setDisable(true);
                statusButton.setOnAction( event -> {
                    Game.context.startEnemyTurn();
                    updateListViews();
                    Game.context.startNextFighterTurn();
                    updateFightButton();
                    } );
                break;
            case AMMOW:
                statusInformation.setText("Plus de flèches... Vous vous défendez");
                attackButton.setOnAction( event -> {
                    what = 1;
                    Game.context.startEnemyTurn();
                    updateListViews();
                    Game.context.startNextFighterTurn();
                    updateFightButton();
                } );
                break;
            case MANA:
                statusInformation.setText("Plus de mana... Vous vous défendez");
                attackButton.setOnAction( event -> {
                    what = 1;
                    Game.context.startEnemyTurn();
                    updateListViews();
                    Game.context.startNextFighterTurn();
                    updateFightButton();
                } );
                break;
            case END_GAME:
                statusInformation.setText("Vous avez perdu !");
                statusButton.setText("Rejouer");
                attackButton.setDisable(true);
                defendButton.setDisable(true);
                break;
        }
    }

}
