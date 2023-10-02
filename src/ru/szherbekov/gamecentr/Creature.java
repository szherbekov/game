package ru.szherbekov.gamecentr;

public abstract class Creature {

    private int attack;
    private int defence;
    protected int health;
    private int minDamage;
    private int maxDamage;

    public Creature(int attack, int defence, int health, int minDamage, int maxDamage) {
        if (attack < 0) {
            this.attack = 0;
        }
        if (attack > 30) {
            this.attack = 30;
        }
        if (defence < 0) {
            this.defence = 0;
        }
        if (defence > 30) {
            this.defence = 30;
        }
        this.health = Math.max(health, 0);
        this.minDamage = Math.max(minDamage, 0);
        this.maxDamage = Math.max(maxDamage, 0);
    }

    public boolean isSuccessAttack(Creature target) {
        int modifier = attack - target.defence + 1;
        modifier = Math.max(1, modifier);
        int diceCount = modifier;
        int successCount = 0;
        for (int i = 0; i < diceCount; i++) {
            int diceValue = (int) (Math.random() * 6) + 1;
            if (diceValue > 5) {
                successCount++;
            }
        }
        if (successCount > 0) {
            int damage = (int) (Math.random() * (maxDamage - minDamage + 1)) + minDamage;
            target.setHealth(target.getHealth() - damage);
            if (target.getHealth() < 0 || target.getHealth() == 0) {
                target.setHealth(0);
            }
            return true;
        } else return false;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }
}
