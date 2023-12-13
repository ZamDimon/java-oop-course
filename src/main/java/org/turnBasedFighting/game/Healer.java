package org.turnBasedFighting.game;

public class Healer extends AbstractUnit implements IHealing{
    static final int DEFAULT_HEAL_POWER = 2;
    static final int DEFAULT_HEALTH = 50;
    static final int DEFAULT_ATTACK = 0;

    public Healer() {
        super(DEFAULT_HEALTH, DEFAULT_ATTACK);
    }

    private int getHealPower() {
        return DEFAULT_HEAL_POWER;
    }

    @Override
    public void heal(IHealthable target) {
        if (target instanceof AbstractUnit abstractTarget) {
            abstractTarget.healSelf(getHealPower());
        }
    }
}
