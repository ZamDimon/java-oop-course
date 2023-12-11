package org.turnBasedFighting.game;

public class Lancer extends AbstractUnit {
    static final int DEFAULT_HEALTH = 50;
    static final int DEFAULT_ATTACK = 6;

    public Lancer() {
        super(DEFAULT_HEALTH, DEFAULT_ATTACK);
    }

    @Override
    public void hit(IHittable target) {
        return;
    }
}
