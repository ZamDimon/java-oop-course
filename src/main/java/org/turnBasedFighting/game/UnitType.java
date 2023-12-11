package org.turnBasedFighting.game;

public enum UnitType {
    WARRIOR, KNIGHT, DEFENDER;

    public static IUnit factory(UnitType unitClass) {
        return switch (unitClass) {
            case WARRIOR -> new Warrior();
            case KNIGHT -> new Knight();
            case DEFENDER -> new Defender();
        };
    }

    public IUnit make() {
        return factory(this);
    }
}
