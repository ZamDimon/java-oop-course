package org.turnBasedFighting.game;

public enum UnitClass {
    WARRIOR, KNIGHT;

    public static IUnit factory(UnitClass unitClass) {
        return switch (unitClass) {
            case WARRIOR -> new Warrior();
            case KNIGHT -> new Knight();
        };
    }

    public IUnit make() {
        return factory(this);
    }
}
