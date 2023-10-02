package ru.szherbekov.gamecentr;

public class Player extends Creature {
    private final int maxHealth;

    public Player(int attack, int defence, int health, int minDamage, int maxDamage, int maxHealth) {
        super(attack, defence, health, minDamage, maxDamage);
        this.maxHealth = Math.max(maxHealth, 0);
        this.health = Math.min(health, maxHealth);
    }

    public void heal() {
        if (getHealth() == 0) {
            throw new IllegalArgumentException("Нельзя вылечить мертвого игрока!");
        }
        if (getHealth() < maxHealth) {
            setHealth((int) Math.min(getHealth() + getMaxHealth() * 0.3, getMaxHealth()));
        }
        if (getHealth() > maxHealth) {
            setHealth(maxHealth);
        }
    }

    public int getMaxHealth() {
        return maxHealth;
    }

}
