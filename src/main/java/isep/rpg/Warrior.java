package isep.rpg;

public class Warrior extends Hero {
    public Warrior() { this.setLifePoints(15); this.setweaponDamage(6); this.setarmorNumber(3);}
    @Override
    public boolean attack(Fighter enemy) {
        return enemy.receiveAttack(this.getweaponDamage());
    }
}
