package isep.rpg;

public class Potion implements Consumable {

    public void Potion1(Fighter hero) {
    hero.setLifePoints(hero.getLifePoints()+1);
    }
    public void Potion2(Fighter hero) {
        hero.setLifePoints(hero.getLifePoints()+2);
    }
    public void Potion3(Fighter hero) {
        hero.setLifePoints(hero.getLifePoints()+3);
    }
    public void Potion4(Fighter hero) {
        hero.setLifePoints(hero.getLifePoints()+4);
    }
}

