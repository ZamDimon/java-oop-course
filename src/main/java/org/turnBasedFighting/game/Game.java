package org.turnBasedFighting.game;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    public enum FightResult {
        FIRST_WIN,
        SECOND_WIN,
        UNDEFINED
    }

    public static FightResult fight(IUnit first, IUnit second) {
        while(first.isAlive() && second.isAlive()) {
            first.hit(second);
            if (!second.isAlive()) return FightResult.FIRST_WIN;

            second.hit(first);
            if (!first.isAlive()) return FightResult.SECOND_WIN;
        }

        return FightResult.UNDEFINED;
    }

    public static FightResult fight(Army first, Army second) {
        log.debug("Army {} fights against army {}", first, second);

        var iteratorFirst = first.firstAliveIterator();
        var iteratorSecond = second.firstAliveIterator();

        while(iteratorFirst.hasNext() && iteratorSecond.hasNext()) {
            fight(iteratorFirst.next(), iteratorSecond.next());
        }

        return iteratorFirst.hasNext()? FightResult.FIRST_WIN : FightResult.SECOND_WIN;
    }

    public static FightResult straightFight(Army first, Army second) {
        log.debug("Army {} straight fights against army {}", first, second);

        while(!first.isEmpty() && !second.isEmpty()) {
            var iteratorFirst = first.allAliveIterator();
            var iteratorSecond = second.allAliveIterator();
            while (iteratorFirst.hasNext() && iteratorSecond.hasNext()) {
                fight(iteratorFirst.next(), iteratorSecond.next());
            }
        }

        return first.isEmpty()? FightResult.SECOND_WIN : FightResult.FIRST_WIN;
    }
}
