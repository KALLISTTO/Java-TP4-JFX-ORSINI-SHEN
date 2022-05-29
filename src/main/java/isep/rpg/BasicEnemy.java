package isep.rpg;

public class BasicEnemy extends Enemy {
    public BasicEnemy() { this.setLifePoints(20); this.setweaponDamage(3);}
    @Override
    public boolean attack(Fighter hero) {
        return hero.receiveAttack(this.getweaponDamage());
    }
}
