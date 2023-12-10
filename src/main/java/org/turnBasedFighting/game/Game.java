package org.turnBasedFighting.game;

public class Game {
    public enum FightResult {
        FIRST_WIN,
        SECOND_WIN,
        UNDEFINED
    }

    public static FightResult fight(IUnit first, IUnit second) {
        while(first.isAlive() && second.isAlive()) {
            if (first.hit(second)) return FightResult.FIRST_WIN;
            if (second.hit(first)) return FightResult.SECOND_WIN;
        }

        return FightResult.UNDEFINED;
    }

    public static FightResult fight(Army first, Army second) {
        var iteratorFirst = first.iterator();
        var iteratorSecond = second.iterator();

        while(iteratorFirst.hasNext() && iteratorSecond.hasNext()) {
            fight(iteratorFirst.next(), iteratorSecond.next());
        }

        return iteratorFirst.hasNext()? FightResult.FIRST_WIN : FightResult.SECOND_WIN;
    }
}
