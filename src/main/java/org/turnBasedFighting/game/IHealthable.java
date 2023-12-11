package org.turnBasedFighting.game;

public interface IHealthable {
    int getHealth();
    default boolean isAlive() {
        return getHealth() > 0;
    }
}
