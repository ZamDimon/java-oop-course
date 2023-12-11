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
        log.info("Warrior {} hits {}", this, target);

        if (target instanceof AbstractUnit abstractTarget) {
            abstractTarget.setHealth(abstractTarget.getHealth() - getAttack());
            return !abstractTarget.isAlive();
        }

        throw new IllegalArgumentException("Unsupported type");
    }
}
