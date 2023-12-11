package org.turnBasedFighting.game;

public enum UnitType {
    WARRIOR, KNIGHT, DEFENDER, VAMPIRE;

    public static IUnit factory(UnitType unitClass) {
        return switch (unitClass) {
            case WARRIOR -> new Warrior();
            case KNIGHT -> new Knight();
            case DEFENDER -> new Defender();
            case VAMPIRE -> new Vampire();
        };
    }

    public IUnit make() {
        return factory(this);
    }
}
