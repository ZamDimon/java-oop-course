package org.turnBasedFighting.game;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Defender extends AbstractUnit implements IUnit, IDefendable {
    static final int DEFAULT_HEALTH = 60;
    static final int DEFAULT_ATTACK = 3;
    static final int DEFAULT_DEFENCE = 2;

    public Defender() {
        super(DEFAULT_HEALTH, DEFAULT_ATTACK);
    }

    public int getDefence() {
        return DEFAULT_DEFENCE;
    }

    @Override
    public boolean acceptDamage(int damage) {
        int actualDamage = Math.max(damage - getDefence(), 0);
        return super.acceptDamage(actualDamage);
    }
}
