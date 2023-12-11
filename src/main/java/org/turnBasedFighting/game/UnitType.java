package org.turnBasedFighting.game;

public enum UnitType {
    WARRIOR, KNIGHT, DEFENDER, VAMPIRE, LANCER;

    public static IUnit factory(UnitType unitClass) {
        return switch (unitClass) {
            case WARRIOR -> new Warrior();
            case KNIGHT -> new Knight();
            case DEFENDER -> new Defender();
            case VAMPIRE -> new Vampire();
            case LANCER -> new Lancer();
        };
    }

    public IUnit make() {
        return factory(this);
    }
}
