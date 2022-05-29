package isep.rpg;

public abstract class Fighter {
    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    private int lifePoints;
    public int getLifePoints() { return lifePoints; }
    public void setLifePoints(int lifePoints) { this.lifePoints = lifePoints; }

    private int weaponDamage;
    public int getweaponDamage() { return weaponDamage; }
    public void setweaponDamage(int weaponDamage) { this.weaponDamage = weaponDamage; }

//    public abstract boolean attack(Fighter fighter);
    public boolean attack(Fighter fighter) { return false; }

    public boolean receiveAttack(int lifePoints) {
        this.lifePoints -= lifePoints;
        return this.lifePoints <= 0; // Vrai si le combattant est mort
    }
}
