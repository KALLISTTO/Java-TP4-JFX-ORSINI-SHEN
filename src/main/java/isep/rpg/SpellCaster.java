package isep.rpg;

public abstract class SpellCaster extends Hero {

    private int manaPoints;
    public int getManaPoints() { return manaPoints; }
    public void setManaPoints(int manaPoints) { this.manaPoints = manaPoints; }

    private int manaCost;
    public int getManaCost() { return manaCost; }
    public void setManaCost(int manaCost) { this.manaCost = manaCost; }

}
