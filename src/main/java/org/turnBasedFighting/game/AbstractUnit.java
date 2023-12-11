package org.turnBasedFighting.game;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AbstractUnit implements IUnit {
    private int health;
    private int attack;

    public AbstractUnit(int health, int attack) {
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

    protected void setHealth(int newHealth) {
        this.health = newHealth;
    }

    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }

    /** Function for hitting another warrior
     * @param target - Warrior to hit
     * @return Whether the target was killed
     */
    @Override
    public boolean hit(IUnit target) {
        log.debug("{} tries to hit {}", this, target);

        if (target instanceof AbstractUnit abstractTarget) {
            return abstractTarget.acceptDamage(getAttack());
        }

        throw new IllegalArgumentException("Unsupported type");
    }

    /** Function for getting damage from another entity
     * @param damage - Damage to be taken
     * @return Whether the unit was killed
     */
    protected boolean acceptDamage(int damage) {
        log.debug("Unit {} accepts {} damage", this, damage);

        setHealth(getHealth() - damage);
        return !isAlive();
    }

    @Override
    public String toString() {
        String className = getClass().getSimpleName().toUpperCase();
        return className +
                "{health=" + getHealth() +
                ",attack=" + getAttack() +
                "}";
    }
}
