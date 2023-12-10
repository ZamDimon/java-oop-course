package org.example.game;

public class Game {
    public enum FightResult {
        FIRST_WIN,
        SECOND_WIN,
        UNDEFINED
    }

    public static FightResult fight(Warrior first, Warrior second) {
        while(first.isAlive() && second.isAlive()) {
            if (first.hit(second)) return FightResult.FIRST_WIN;
            if (second.hit(first)) return FightResult.SECOND_WIN;
        }

        return FightResult.UNDEFINED;
    }
}
