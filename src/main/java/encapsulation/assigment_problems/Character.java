package encapsulation.assigment_problems;

/**
 * Assignment Problem 1: The Health Bar.
 * Health is private and can only be changed through damage/healing actions.
 */
public class Character {
    private int health;
    private final int maxHealth;

    public Character(int maxHealth) {
        if (maxHealth < 0) {
            throw new IllegalArgumentException("Maximum health cannot be negative");
        }
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount <= 0) {
            return;
        }
        health = Math.max(0, health - amount);
    }

    public void heal(int amount) {
        if (amount <= 0) {
            return;
        }
        health = Math.min(maxHealth, health + amount);
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
}
