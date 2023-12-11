package org.turnBasedFighting.game;

public class Vampire extends AbstractUnit implements IVampirable, IHitAndReportable {
    static final int DEFAULT_HEALTH = 40;
    static final int DEFAULT_ATTACK = 4;
    /// Vampiring in percents
    static final int DEFAULT_VAMPIRING = 50;

    public Vampire() {
        super(DEFAULT_HEALTH, DEFAULT_ATTACK);
    }

    public int getVampiring() {
        return DEFAULT_VAMPIRING;
    }

    @Override
    public void hit(IHittable target) {
        int dealtDamage = hitAndReportDealtDamage(target);
        healSelf(calculateHealingFromDamage(dealtDamage));
    }

    private int calculateHealingFromDamage(int dealtDamage) {
        return dealtDamage * getVampiring() / 100;
    }
}
