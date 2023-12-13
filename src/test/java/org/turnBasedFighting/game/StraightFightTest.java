package org.turnBasedFighting.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StraightFightTest {
    @Test
    @DisplayName("Example straight fight")
    void ExampleFight() {
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
}
