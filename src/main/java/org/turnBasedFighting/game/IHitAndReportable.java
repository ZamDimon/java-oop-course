package org.turnBasedFighting.game;

public interface IHitAndReportable extends IHitting {
    default int hitAndReportDealtDamage(IHittable target) {
        int healthBefore = target.getHealth();
        IHitting.super.hit(target);
        int healthAfter = target.getHealth();

        return healthBefore - healthAfter;
    }
}
