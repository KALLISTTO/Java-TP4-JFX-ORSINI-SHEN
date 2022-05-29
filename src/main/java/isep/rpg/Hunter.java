package isep.rpg;

public class Hunter extends Hero {

    private int arrows;
    public int getarrowsNumber() { return arrows; }
    public void setarrowsNumber(int arrows) { this.arrows = arrows; }

    public Hunter() { this.setLifePoints(10); this.setarrowsNumber(6); this.setweaponDamage(6); this.setarmorNumber(2);}
    @Override
    public boolean attack(Fighter enemy) {
        if (this.getarrowsNumber() > 0) {
            this.setarrowsNumber(this.getarrowsNumber()-1);
            return enemy.receiveAttack(this.getweaponDamage());
        } else {return false;}
    }
}
