package org.turnBasedFighting.game;

public class Warrior extends AbstractUnit {
    static final int DEFAULT_HEALTH = 50;
    static final int DEFAULT_ATTACK = 5;

    public Warrior() {
        super(DEFAULT_HEALTH, DEFAULT_ATTACK);
    }
}
