package isep.rpg;

public class Mage extends SpellCaster {
    public Mage() { this.setLifePoints(10); this.setManaPoints(6); this.setManaCost(2); this.setweaponDamage(8); this.setarmorNumber(2);}
    @Override
    public boolean attack(Fighter enemy) {
            this.setManaPoints(this.getManaPoints() - getManaCost());
            return enemy.receiveAttack(this.getweaponDamage());
    }
}
