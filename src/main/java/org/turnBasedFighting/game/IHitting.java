package org.turnBasedFighting.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface IHitting extends IHasAttack {
    Logger log = LoggerFactory.getLogger(IHitting.class);

    default void hit(IHittable target) {
        log.info("Unit {} hits {}", this, target);
        target.acceptDamage(getAttack());
    }
}
