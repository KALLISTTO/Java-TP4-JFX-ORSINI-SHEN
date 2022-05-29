package isep.rpg;

import isep.jfx.GameController;
import isep.jfx.MainController;
import isep.util.InputParser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;


public class Game {

    public static Game context;

    public static void playGame() {
        if (Game.context != null) {
            throw new RuntimeException
                    ("Impossible de lancer plusieurs fois la partie...");
        }
        Game.context = new Game();
        Game.context.generateHeroes();
        Game.context.startCombat();
    }

    public static enum Status {START_COMBAT, HERO_TURN, ENEMY_TURN, END_GAME, AMMOW, MANA, SPELLCASTERS, HUNTER, WARRIOR, HEALER}
    public Status status;



    public List<Hero> heroes;
    public List<String> getHeroesStatus() {
        List<String> heroesStatus = new ArrayList<>();
        for (Hero hero: this.heroes) {
            if (hero instanceof SpellCaster) {
                heroesStatus.add(hero.getName()
                        + " ( HP= " + hero.getLifePoints() + "   | DP= " + hero.getarmorNumber() + "   | AP= " + hero.getweaponDamage() + "  | Mana= " + ((SpellCaster) hero).getManaPoints() + "  | Cost= " + ((SpellCaster) hero).getManaCost() +" )");
            } else if (hero instanceof Hunter) {
                heroesStatus.add(hero.getName()
                        + " ( HP= " + hero.getLifePoints() + "   | DP= " + hero.getarmorNumber() + "  | AP= " + hero.getweaponDamage() + "  | ArrowsLeft= " + ((Hunter) hero).getarrowsNumber() + " )");

            } else {
                heroesStatus.add
                        (hero.getName()
                                + " ( HP= " + hero.getLifePoints() + "   | DP= " + hero.getarmorNumber() + "  | AP= " + hero.getweaponDamage() + " )"
                        );
            }
        }
        return heroesStatus;
    }
    private List<Enemy> enemies;
    public List<String> getEnemiesStatus() {
        List<String> enemyStatus = new ArrayList<>();
        for (Enemy enemy: this.enemies) {
            enemyStatus.add
                ( enemy.getClass().getSimpleName()
                + " ( HP= " + enemy.getLifePoints() + "  | AP= " + enemy.getweaponDamage() + " )"
                );

        }
        return enemyStatus;
    }
    // "fighters" : Les héros et les ennemis mélangés
    private List<Fighter> fighters;
    ListIterator<Fighter> fightersIterator;
    ListIterator<Hero> heroIterator;

    public Fighter currentFighter;
    public String getCurrentFighter() { return currentFighter.getName();}
    public Hero currentHero;
    public String getCurrentHero(){
        return currentHero.getName();
    }

    private int playerTurn;
    private InputParser inputParser;

    // L'instanciation de "Game" ne peut se faire que par "playGame"
    private Game() {}

    public void startCombat() {
        // Combat avec de nouveaux ennemis tant qu'il y a des héros actifs
        if (this.heroes.size() > 0) {
            this.status = Status.START_COMBAT;
            generateCombat();
        } else {
            this.status = Game.Status.END_GAME;
        }
    }

    public void generateCombat() {
        generateEnemies();
        shuffleFighters();
        // Initialise un "curseur" pour parcourir la liste des combattants
        fightersIterator = fighters.listIterator();
    }

    private void generateHeroes() {
        this.heroes = new ArrayList<>();
        int m = 0;
        int h = 0;
        int w = 0;
        int he = 0;
        for (int i = 0; i <= MainController.heroesSelected.size() - 1; i++) {
            if (MainController.heroesSelected.get(i).equals("Mage") && m == 0) {
                Hero mage1 = new Mage();
                mage1.setName("Mage");
                m++;
                this.heroes.add(mage1);
            } else if (MainController.heroesSelected.get(i).equals("Mage") && m == 1) {
                Hero mage2 = new Mage();
                mage2.setName("Mage 2");
                m++;
                this.heroes.add(mage2);
            } else if (MainController.heroesSelected.get(i).equals("Mage") && m == 2) {
                Hero mage3 = new Mage();
                mage3.setName("Mage 3");
                m++;
                this.heroes.add(mage3);
            } else if (MainController.heroesSelected.get(i).equals("Mage") && m == 3) {
                Hero mage4 = new Mage();
                mage4.setName("Mage 4");
                m++;
                this.heroes.add(mage4);
            } else if (MainController.heroesSelected.get(i).equals("Warrior") && w == 0) {
                Hero warrior = new Warrior();
                warrior.setName("Warrior");
                w++;
                this.heroes.add(warrior);
            } else if (MainController.heroesSelected.get(i).equals("Warrior") && w == 1) {
                Hero warrior2 = new Warrior();
                warrior2.setName("Warrior 2");
                w++;
                this.heroes.add(warrior2);
            } else if (MainController.heroesSelected.get(i).equals("Warrior") && w == 2) {
                Hero warrior3 = new Warrior();
                warrior3.setName("Warrior 3");
                m++;
                this.heroes.add(warrior3);
            } else if (MainController.heroesSelected.get(i).equals("Warrior") && w == 3) {
                Hero warrior4 = new Warrior();
                warrior4.setName("Warrior 4");
                m++;
                this.heroes.add(warrior4);
            } else if (MainController.heroesSelected.get(i).equals("Hunter") && h == 0) {
                Hero hunter1 = new Hunter();
                hunter1.setName("Hunter");
                h++;
                this.heroes.add(hunter1);
            } else if (MainController.heroesSelected.get(i).equals("Hunter") && h == 1) {
                Hero hunter2 = new Hunter();
                hunter2.setName("Hunter 2");
                h++;
                this.heroes.add(hunter2);
            } else if (MainController.heroesSelected.get(i).equals("Hunter") && h == 2) {
                Hero hunter3 = new Hunter();
                hunter3.setName("Hunter 3");
                h++;
                this.heroes.add(hunter3);
            } else if (MainController.heroesSelected.get(i).equals("Hunter") && h == 3) {
                Hero hunter4 = new Hunter();
                hunter4.setName("Hunter 4");
                h++;
                this.heroes.add(hunter4);
            } else if (MainController.heroesSelected.get(i).equals("Healer") && he == 0) {
                Hero healer1 = new Healer();
                healer1.setName("Healer");
                he++;
                this.heroes.add(healer1);
            } else if (MainController.heroesSelected.get(i).equals("Healer") && he == 1) {
                Hero healer2 = new Healer();
                healer2.setName("Healer 2");
                he++;
                this.heroes.add(healer2);
            } else if (MainController.heroesSelected.get(i).equals("Healer") && he == 2) {
                Hero healer3 = new Healer();
                healer3.setName("Healer 3");
                he++;
                this.heroes.add(healer3);
            } else if (MainController.heroesSelected.get(i).equals("Healer") && he == 3) {
                Hero healer4 = new Healer();
                healer4.setName("Healer 4");
                he++;
                this.heroes.add(healer4);
            }
        }
    }

    private void generateEnemies() {
        this.enemies = new ArrayList<>();
        int getRandomValue = (int) (Math.random()*(5));
        if (getRandomValue == 0 || getRandomValue == 1 || getRandomValue == 2){
            for (int i=0; i<=MainController.heroesSelected.size()-1; i++){
                enemies.add( new BasicEnemy() );
            }
        } else {
            enemies.add( new Boss() );
        }

    }

    // Mélange les héros avec les ennemis dans une liste pour le combat
    private void shuffleFighters() {
        this.fighters = new ArrayList<>();
        this.fighters.addAll(this.heroes);
        this.fighters.addAll(this.enemies);
        Collections.shuffle(this.fighters); //--> google "java shuffle list"
    }

    public void getstartCombat() {
        this.status = Status.START_COMBAT;
    }

    int i = 0;
    public void nextUpgrade() {
        if (i==0) {
            i=1;
            heroIterator = heroes.listIterator();
        }
        if (!heroIterator.hasNext()) {
            this.status = Status.START_COMBAT;
            i=0;
            upgradeReinitialization = 0;
        } else {
            this.currentHero = heroIterator.next();
            if (currentHero instanceof SpellCaster) {
                this.status = Status.SPELLCASTERS;
            } else if (currentHero instanceof Hunter) {
                this.status = Status.HUNTER;
            } else if (currentHero instanceof Warrior) {
                this.status = Status.WARRIOR;
            }
        }
    }
    static int combat=1;
    static public int getCombat() {
        return combat;
    }
    static int upgradeReinitialization = 0;
    public static int getUpgradeReinitialization() {
        return upgradeReinitialization;
    }
    public void startNextFighterTurn() {

        if (this.heroes.size() == 0) {
            this.status = Game.Status.END_GAME;
        } else if (enemies.size() == 0) {
            this.status = Game.Status.START_COMBAT;
            combat++;
            upgradeReinitialization++;
            generateCombat();
        } else {
            // Récupère le combattant suivant en déplaçant le curseur de liste
            if (!fightersIterator.hasNext()) {
                // Si on est à la fin de la liste, l'itérateur est réinitialisé
                fightersIterator = fighters.listIterator();
            }
            this.currentFighter = fightersIterator.next();


            if (this.currentFighter instanceof SpellCaster && ((SpellCaster) this.currentFighter).getManaPoints() - ((SpellCaster) this.currentFighter).getManaCost() < 0) {
                    this.status = Game.Status.MANA;
            } else if (this.currentFighter instanceof Hunter && ((Hunter) this.currentFighter).getarrowsNumber() < 0) {
                this.status = Game.Status.AMMOW;
            } else if (this.currentFighter instanceof Healer){
                this.status = Game.Status.HEALER;
            } else if (this.currentFighter instanceof Hero ) {// déplacer dans le startHeroTurn
                //--> "instanceof" permet de valider si la variable "fighter",
                //    qui est de type "Fighter", contient bien une instance de la
                //    sous-classe "Hero".
                this.status = Game.Status.HERO_TURN;
            } else {
                this.status = Game.Status.ENEMY_TURN;
            }// déplacer dans le startHeroTurn
        }
    }

    public void startHeroTurn() {
        if (GameController.getWhat() == 0) {
            if (currentFighter instanceof Healer){
                Hero hero = this.heroes.get((int) (Math.random() * (enemies.size())));
                ((Healer) currentFighter).heal(hero);
            } else {
                Fighter ennemy = this.enemies.get((int) (Math.random() * (enemies.size())));
                boolean ennemyDefeated = this.currentFighter.attack(ennemy);

                if (ennemyDefeated) {
                    this.enemies.remove(ennemy);
                    this.fighters.remove(ennemy);
                }
            }
        } else {
            ((Hero) this.currentFighter).defend();
        }

    }


    public void startEnemyTurn() {
        Fighter hero = this.heroes.get((int) (Math.random()*(heroes.size())));
        boolean heroDefeated = this.currentFighter.attack(hero);
        if (heroDefeated) {
            this.heroes.remove(hero);
            this.fighters.remove(hero);
        }
    }

    public void weaponUpgrade(Hero hero) {
        hero.setweaponDamage(hero.getweaponDamage()+3);
    }

    public void armorUpgrade(Hero hero) {
        hero.setarmorNumber(hero.getarmorNumber()+2);
    }

    public void lifeUpgrade(Hero hero) {
        hero.setLifePoints(hero.getLifePoints()+4);
    }

    public void costUpgrade(SpellCaster hero) {
        if (hero.getManaCost()-1 < 0) {
            hero.setManaCost(0);
        } else {
            hero.setManaCost(hero.getManaCost()-1);
        }
    }

    public void manaUpgrade(SpellCaster hero) {
        hero.setManaPoints(hero.getManaPoints()+2);
    }

    public void arrowUpgrade(Hunter hero) {
        hero.setarrowsNumber(hero.getarrowsNumber()+10);
    }

}
