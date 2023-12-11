package org.turnBasedFighting.game;

public class Defender extends AbstractUnit implements IUnit {
    static final int DEFAULT_HEALTH = 60;
    static final int DEFAULT_ATTACK = 3;

    public Defender() {
        super(DEFAULT_HEALTH, DEFAULT_ATTACK);
    }
}
