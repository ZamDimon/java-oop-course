package org.turnBasedFighting.game;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AbstractUnit implements IUnit {
    // Unit stats
    private final int initialHealth;
    private int health;
    private int attack;

    // Unit identifier
    private static int idCounter = 0;
    private final int id = ++idCounter;

    public AbstractUnit(int health, int attack) {
        this.initialHealth = health;
        this.health = health;
        this.attack = attack;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public int getHealth() {
        return health;
    }

    private void setHealth(int newHealth) {
        this.health = Math.min(newHealth, initialHealth);
    }

    protected void healSelf(int healing) {
        log.debug("{} tries to heal himself on {}", this, healing);
        setHealth(getHealth() + healing);
    }

    /** Function for getting damage from another entity
     * @param damage - Damage to be taken
     * @return Whether the unit was killed
     */
    public boolean acceptDamage(int damage) {
        log.debug("Unit {} accepts {} damage", this, damage);

        setHealth(getHealth() - damage);
        return !isAlive();
    }

    @Override
    public String toString() {
        String className = getClass().getSimpleName().toUpperCase();
        return className + "#" + id +
                "{health=" + getHealth() +
                ",attack=" + getAttack() +
                "}";
    }
}
