package org.turnBasedFighting.game;

public class Lancer extends AbstractUnit implements IHitAndReportable {
    static final int DEFAULT_HEALTH = 50;
    static final int DEFAULT_ATTACK = 6;
    /// In percents
    static final int PENETRATION_RATIO = 50;

    public Lancer() {
        super(DEFAULT_HEALTH, DEFAULT_ATTACK);
    }

    public int getPenetrationRatio() {
        return PENETRATION_RATIO;
    }

    @Override
    public void hit(IHittable target) {
        int damageDealt = hitAndReportDealtDamage(target);
        if (target instanceof IUnitInArmy targetInArmy) {
            var nextBehind = targetInArmy.getNextUnit();
            if (nextBehind.isEmpty()) {
                return;
            }

            int penetrationDamage = getPenetrationDamage(damageDealt);
            IHitting proxySecondHitByLancer = () -> penetrationDamage;
            proxySecondHitByLancer.hit(nextBehind.get());
        }
    }

    private int getPenetrationDamage(int baseDamage) {
        return baseDamage * getPenetrationRatio() / 100;
    }
}
