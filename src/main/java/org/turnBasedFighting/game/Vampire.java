package org.turnBasedFighting.game;

public class Vampire extends AbstractUnit implements IVampirable{
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
    public void hit(IHittable target) {
        // Dealing damage and fixating health before and after
        int healthBefore = target.getHealth();
        super.hit(target);
        int healthAfter = target.getHealth();

        // Healing yourself
        int dealtDamage = healthBefore - healthAfter;
        healSelf(calculateHealingFromDamage(dealtDamage));
    }

    private int calculateHealingFromDamage(int dealtDamage) {
        return dealtDamage * getVampiring() / 100;
    }
}
