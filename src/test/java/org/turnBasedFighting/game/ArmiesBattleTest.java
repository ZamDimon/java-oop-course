package org.turnBasedFighting.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmiesBattleTest {
    /* Test taken from https://github.com/CheckiO-Missions/checkio-mission-set-war-army-battles/blob/master/verification/tests.py
    "1. Battle": [
        prepare_test(middle_code='''army_1 = Army()
army_2 = Army()
army_1.add_units(Warrior, 1)
army_2.add_units(Warrior, 2)
battle = Battle()''',
                     test="battle.fight(army_1, army_2)",
                     answer=False)
                ],
     */
    @Test
    @DisplayName("1 Warrior < 2 Warriors")
    void Test_01() {
        var army1 = new Army().addUnits(UnitClass.WARRIOR, 1);
        var army2 = new Army().addUnits(UnitClass.WARRIOR, 2);

        var result = Game.fight(army1, army2);
        assertEquals(result, Game.FightResult.SECOND_WIN);
    }

    /* Test taken from https://github.com/CheckiO-Missions/checkio-mission-set-war-army-battles/blob/master/verification/tests.py
    "2. Battle": [
        prepare_test(middle_code='''army_1 = Army()
army_2 = Army()
army_1.add_units(Warrior, 2)
army_2.add_units(Warrior, 3)
battle = Battle()''',
                     test="battle.fight(army_1, army_2)",
                     answer=False)
                ],
     */
    @Test
    @DisplayName("2 Warriors < 3 Warriors")
    void Test_02() {
        var army1 = new Army().addUnits(UnitClass.WARRIOR, 2);
        var army2 = new Army().addUnits(UnitClass.WARRIOR, 3);

        var result = Game.fight(army1, army2);
        assertEquals(result, Game.FightResult.SECOND_WIN);
    }

    /* Test taken from https://github.com/CheckiO-Missions/checkio-mission-set-war-army-battles/blob/master/verification/tests.py
    "3. Battle": [
        prepare_test(middle_code='''army_1 = Army()
army_2 = Army()
army_1.add_units(Warrior, 5)
army_2.add_units(Warrior, 7)
battle = Battle()''',
                     test="battle.fight(army_1, army_2)",
                     answer=False)
                ],
     */
    @Test
    @DisplayName("5 Warriors < 7 Warriors")
    void Test_03() {
        var army1 = new Army().addUnits(UnitClass.WARRIOR, 5);
        var army2 = new Army().addUnits(UnitClass.WARRIOR, 7);

        var result = Game.fight(army1, army2);
        assertEquals(result, Game.FightResult.SECOND_WIN);
    }

    /* Test taken from https://github.com/CheckiO-Missions/checkio-mission-set-war-army-battles/blob/master/verification/tests.py
    "4. Battle": [
        prepare_test(middle_code='''army_1 = Army()
army_2 = Army()
army_1.add_units(Warrior, 20)
army_2.add_units(Warrior, 21)
battle = Battle()''',
                     test="battle.fight(army_1, army_2)",
                     answer=True)
                ],
     */
    @Test
    @DisplayName("20 Warriors > 21 Warriors")
    void Test_04() {
        var army1 = new Army().addUnits(UnitClass.WARRIOR, 20);
        var army2 = new Army().addUnits(UnitClass.WARRIOR, 21);

        var result = Game.fight(army1, army2);
        assertEquals(result, Game.FightResult.FIRST_WIN);
    }

    /* Test taken from https://github.com/CheckiO-Missions/checkio-mission-set-war-army-battles/blob/master/verification/tests.py
    "5. Battle": [
        prepare_test(middle_code='''army_1 = Army()
army_2 = Army()
army_1.add_units(Warrior, 10)
army_2.add_units(Warrior, 11)
battle = Battle()''',
                     test="battle.fight(army_1, army_2)",
                     answer=True)
                ],
     */
    @Test
    @DisplayName("10 Warriors > 11 Warriors")
    void Test_05() {
        var army1 = new Army().addUnits(UnitClass.WARRIOR, 10);
        var army2 = new Army().addUnits(UnitClass.WARRIOR, 11);

        var result = Game.fight(army1, army2);
        assertEquals(result, Game.FightResult.FIRST_WIN);
    }

    /* Test taken from https://github.com/CheckiO-Missions/checkio-mission-set-war-army-battles/blob/master/verification/tests.py
    "6. Battle": [
        prepare_test(middle_code='''army_1 = Army()
army_2 = Army()
army_1.add_units(Warrior, 11)
army_2.add_units(Warrior, 7)
battle = Battle()''',
                     test="battle.fight(army_1, army_2)",
                     answer=True)
                ]
     */
    @Test
    @DisplayName("11 Warriors > 7 Warriors")
    void Test_06() {
        var army1 = new Army().addUnits(UnitClass.WARRIOR, 11);
        var army2 = new Army().addUnits(UnitClass.WARRIOR, 7);

        var result = Game.fight(army1, army2);
        assertEquals(result, Game.FightResult.FIRST_WIN);
    }

    // Smoke test taken from https://py.checkio.org/en/mission/army-battles/
    @Test
    @DisplayName("30 Warriors > 20 Warriors + 5 Knights")
    void Test_07() {
        var army1 = new Army().addUnits(UnitClass.WARRIOR, 30);
        var army2 = new Army()
                .addUnits(UnitClass.WARRIOR, 20)
                .addUnits(UnitClass.KNIGHT, 5);

        var result = Game.fight(army1, army2);
        assertEquals(result, Game.FightResult.FIRST_WIN);
    }
}