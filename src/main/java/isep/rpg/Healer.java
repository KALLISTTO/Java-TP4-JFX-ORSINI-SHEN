package isep.rpg;

public class Healer extends SpellCaster {
    public Healer() { this.setLifePoints(10); this.setManaPoints(6); this.setManaCost(2); this.setarmorNumber(1);}

    public void heal(Fighter hero) {
        if (this.getManaPoints() > 0) {
            hero.setLifePoints(hero.getLifePoints() + 2);
            this.setManaPoints(this.getLifePoints() - getManaCost());
        }
    }
}
