package isep.rpg;

public class Boss extends Enemy {

    public Boss() { this.setLifePoints(50); this.setweaponDamage(10);}
    @Override
    public boolean attack(Fighter hero) {
        return hero.receiveAttack(this.getweaponDamage());
    }
}
