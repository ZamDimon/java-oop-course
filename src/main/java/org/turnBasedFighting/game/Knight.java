package org.turnBasedFighting.game;

public class Knight extends AbstractUnit implements IUnit {
    static final int DEFAULT_HEALTH = 50;
    static final int DEFAULT_ATTACK = 7;

    public Knight() {
        super(DEFAULT_HEALTH, DEFAULT_ATTACK);
    }
}
