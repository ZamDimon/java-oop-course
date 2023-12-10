package org.example.game;

public class Warrior {
    static final int DEFAULT_HEALTH = 50;
    private int health;

    static final int DEFAULT_ATTACK = 5;
    private int attack;

    public Warrior() {
        this(DEFAULT_HEALTH, DEFAULT_ATTACK);
    }

    protected Warrior(int health, int attack) {
        this.health = health;
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }
    protected void setHealth(int newHealth) {
        this.health = newHealth;
    }

    public int getAttack() {
        return attack;
    }

    public boolean isAlive() {
        return getHealth() > 0;
    }


    /** Function for hitting another warrior
     * @param target - Warrior to hit
     * @return Whether the target was killed
     */
    public boolean hit(Warrior target) {
        target.setHealth(target.getHealth() - getAttack());
        return !target.isAlive();
    }
}
