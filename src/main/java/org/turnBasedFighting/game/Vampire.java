package org.turnBasedFighting.game;

public class Vampire extends AbstractUnit implements IUnit, IVampirable{
    static final int DEFAULT_HEALTH = 40;
    static final int DEFAULT_ATTACK = 4;
    static final int DEFAULT_VAMPIRING = 50;

    public Vampire() {
        super(DEFAULT_HEALTH, DEFAULT_ATTACK);
    }

    public int getVampiring() {
        return DEFAULT_VAMPIRING;
    }

    @Override
    public boolean hit(IUnit target) {
        if (target instanceof AbstractUnit abstractUnit) {
            // Dealing damage and fixating health before and after
            int healthBefore = abstractUnit.getHealth();
            boolean killed = super.hit(target);
            int healthAfter = abstractUnit.getHealth();

            // Healing yourself
            int dealtDamage = healthBefore - healthAfter;
            healSelf(calculateHealingFromDamage(dealtDamage));
            return killed;
        }

        throw new IllegalArgumentException("Unsupported type");
    }

    private int calculateHealingFromDamage(int dealtDamage) {
        return dealtDamage * getVampiring() / 100;
    }
}
