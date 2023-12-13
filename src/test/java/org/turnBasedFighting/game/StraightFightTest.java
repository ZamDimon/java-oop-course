package org.turnBasedFighting.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StraightFightTest {
    @Test
    @DisplayName("Example straight fight 1: 7L+3V+H+4W+H+2D<4W+4D+1H+6V+4L")
    void Fight1() {
        var army1 = new Army()
                .addUnits(UnitType.LANCER, 7)
                .addUnits(UnitType.VAMPIRE, 3)
                .addUnits(UnitType.HEALER, 1)
                .addUnits(UnitType.WARRIOR, 4)
                .addUnits(UnitType.HEALER, 1)
                .addUnits(UnitType.DEFENDER, 2);
        var army2 = new Army()
                .addUnits(UnitType.WARRIOR, 4)
                .addUnits(UnitType.DEFENDER, 4)
                .addUnits(UnitType.HEALER, 1)
                .addUnits(UnitType.VAMPIRE, 6)
                .addUnits(UnitType.LANCER, 4);

        assertEquals(Game.straightFight(army1, army2), Game.FightResult.SECOND_WIN);
    }

    @Test
    @DisplayName("Example straight fight 2: 7L+3V+4W+2D>4W+4D+6V+4L")
    void Fight2() {
        var army1 = new Army()
                .addUnits(UnitType.LANCER, 7)
                .addUnits(UnitType.VAMPIRE, 3)
                .addUnits(UnitType.WARRIOR, 4)
                .addUnits(UnitType.DEFENDER, 2);

        var army2 = new Army()
                .addUnits(UnitType.WARRIOR, 4)
                .addUnits(UnitType.DEFENDER, 4)
                .addUnits(UnitType.VAMPIRE, 6)
                .addUnits(UnitType.LANCER, 4);

        assertEquals(Game.straightFight(army1, army2), Game.FightResult.FIRST_WIN);
    }
}
