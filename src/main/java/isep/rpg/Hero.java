package isep.rpg;

import java.util.List;

public abstract class Hero extends Fighter {


    private int armor;
    public int getarmorNumber() { return armor; }
    public void setarmorNumber(int armor) { this.armor = armor; }

    private List<Potion> potions;
    private List<Food> lembas;
    public void defend() {
        this.setLifePoints(this.getLifePoints()+this.getarmorNumber());
    }
    public void useConsumable(Consumable consumable) {
    }

}
