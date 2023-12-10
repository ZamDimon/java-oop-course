package org.turnBasedFighting.game;

public interface IUnit {
    int getAttack();
    int getHealth();

    boolean isAlive();

    boolean hit(IUnit target);
}
