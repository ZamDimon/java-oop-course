package org.turnBasedFighting.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArmiesBattleTest {
    /*
    Tests are taken from https://github.com/CheckiO-Missions/checkio-mission-set-war-army-battles/blob/master/verification/tests.py
    */
    @ParameterizedTest
    @MethodSource("armyPairsFirstWins")
    @DisplayName("First army should win")
    void firstArmyWins(Army first, Army second) {
        assertEquals(Game.fight(first, second), Game.FightResult.FIRST_WIN);
    }

    static Stream<Arguments> armyPairsFirstWins() {
        return Stream.of(
                Arguments.arguments(
                        new Army().addUnits(UnitType.WARRIOR, 20),
                        new Army().addUnits(UnitType.WARRIOR, 21)
                ),
                Arguments.arguments(
                        new Army().addUnits(UnitType.WARRIOR, 10),
                        new Army().addUnits(UnitType.WARRIOR, 11)
                ),
                Arguments.arguments(
                        new Army().addUnits(UnitType.WARRIOR, 11),
                        new Army().addUnits(UnitType.WARRIOR, 7)
                ),
                Arguments.arguments(
                        new Army().addUnits(UnitType.WARRIOR, 30),
                        new Army()
                                .addUnits(UnitType.WARRIOR, 20)
                                .addUnits(UnitType.KNIGHT, 5)
                ),
                Arguments.arguments(
                        new Army()
                                .addUnits(UnitType.DEFENDER, 2)
                                .addUnits(UnitType.VAMPIRE, 2)
                                .addUnits(UnitType.LANCER, 4)
                                .addUnits(UnitType.WARRIOR, 1),
                        new Army()
                                .addUnits(UnitType.WARRIOR, 2)
                                .addUnits(UnitType.LANCER, 2)
                                .addUnits(UnitType.DEFENDER, 2)
                                .addUnits(UnitType.VAMPIRE, 3)
                )
        );
    }

    /*
    Tests are taken from https://github.com/CheckiO-Missions/checkio-mission-set-war-army-battles/blob/master/verification/tests.py
    */
    @ParameterizedTest
    @MethodSource("armyPairsSecondWins")
    @DisplayName("Second army should win")
    void secondArmyWins(Army first, Army second) {
        assertEquals(Game.fight(first, second), Game.FightResult.SECOND_WIN);
    }

    static Stream<Arguments> armyPairsSecondWins() {
        return Stream.of(
                Arguments.arguments(
                        new Army().addUnits(UnitType.WARRIOR, 1),
                        new Army().addUnits(UnitType.WARRIOR, 2)
                ),
                Arguments.arguments(
                        new Army().addUnits(UnitType.WARRIOR, 2),
                        new Army().addUnits(UnitType.WARRIOR, 3)
                ),
                Arguments.arguments(
                        new Army().addUnits(UnitType.WARRIOR, 5),
                        new Army().addUnits(UnitType.WARRIOR, 7)
                ),
                Arguments.arguments(
                        new Army()
                                .addUnits(UnitType.WARRIOR, 1)
                                .addUnits(UnitType.LANCER, 1)
                                .addUnits(UnitType.DEFENDER, 2),
                        new Army()
                                .addUnits(UnitType.VAMPIRE, 3)
                                .addUnits(UnitType.WARRIOR, 1)
                                .addUnits(UnitType.LANCER, 2)
                )
        );
    }
}