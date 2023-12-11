package org.turnBasedFighting.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WarriorsBattleTest {
    /* Test taken from https://py.checkio.org/en/mission/the-warriors/
    "1. Fight": [
        prepare_test(middle_code='''carl = Warrior()
jim = Knight()''',
                     test="fight(carl, jim)",
                     answer=False)
                ],
     */
    @Test
    @DisplayName("When warrior and knight fight, the latter should win")
    void Test_01() {
        IUnit carl = UnitType.WARRIOR.make();
        IUnit jim = UnitType.KNIGHT.make();

        Game.FightResult result = Game.fight(carl, jim);

        assertEquals(result, Game.FightResult.SECOND_WIN);
    }

    /* Test taken from https://py.checkio.org/en/mission/the-warriors/
    "2. Fight": [
        prepare_test(middle_code='''ramon = Knight()
slevin = Warrior()''',
                     test="fight(ramon, slevin)",
                     answer=True)
                ],
     */
    @Test
    @DisplayName("When knight and warrior fight, the former should win")
    void Test_02() {
        IUnit ramon = UnitType.KNIGHT.make();
        IUnit slevin = UnitType.WARRIOR.make();

        Game.FightResult result = Game.fight(ramon, slevin);

        assertEquals(result, Game.FightResult.FIRST_WIN);
    }

    /* Test taken from https://py.checkio.org/en/mission/the-warriors/
    "3. Fight": [
        prepare_test(middle_code='''bob = Warrior()
mars = Warrior()
fight(bob, mars)''',
                     test="bob.is_alive",
                     answer=True)
                ],
     */
    @Test
    @DisplayName("When warrior and warrior fight, the first should be alive")
    void Test_03() {
        IUnit bob = UnitType.WARRIOR.make();
        IUnit mars = UnitType.WARRIOR.make();

        Game.fight(bob, mars);

        assertTrue(bob.isAlive());
    }

    /* Test taken from https://py.checkio.org/en/mission/the-warriors/
    "4. Fight": [
        prepare_test(middle_code='''zeus = Knight()
godkiller = Warrior()
fight(zeus, godkiller)''',
                     test="zeus.is_alive",
                     answer=True)
                ],
     */
    @Test
    @DisplayName("When knight and warrior fight, the knight should stay alive")
    void Test_04() {
        IUnit zeus = UnitType.KNIGHT.make();
        IUnit godkiller = UnitType.WARRIOR.make();

        Game.fight(zeus, godkiller);

        assertTrue(zeus.isAlive());
    }

    /* Test taken from https://py.checkio.org/en/mission/the-warriors/
    "5. Fight": [
        prepare_test(middle_code='''husband = Warrior()
wife = Warrior()
fight(husband, wife)''',
                     test="wife.is_alive",
                     answer=False)
                ],
     */
    @Test
    @DisplayName("When warrior and warrior fight, the latter should not be alive")
    void Test_05() {
        IUnit husband = UnitType.WARRIOR.make();
        IUnit wife = UnitType.WARRIOR.make();

        Game.fight(husband, wife);

        assertFalse(wife.isAlive());
    }

    /* Test taken from https://py.checkio.org/en/mission/the-warriors/
    "6. Fight": [
        prepare_test(middle_code='''dragon = Warrior()
knight = Knight()
fight(dragon, knight)''',
                     test="knight.is_alive",
                     answer=True)
                ],
     */
    @Test
    @DisplayName("When warrior and knight fight, the knight should be alive")
    void Test_06() {
        IUnit dragon = UnitType.WARRIOR.make();
        IUnit knight = UnitType.KNIGHT.make();

        Game.FightResult result = Game.fight(dragon, knight);

        assertTrue(knight.isAlive());
    }

    /* Test taken from https://py.checkio.org/en/mission/the-warriors/
    "7. Fight": [
        prepare_test(middle_code='''unit_1 = Warrior()
unit_2 = Knight()
unit_3 = Warrior()
fight(unit_1, unit_2)''',
                     test="fight(unit_2, unit_3)",
                     answer=False)
                ]
     */
    @Test
    @DisplayName("When warrior and knights first fight, and then knight with another warrior, the last warrior should win")
    void Test_07() {
        IUnit unit1 = UnitType.WARRIOR.make();
        IUnit unit2 = UnitType.KNIGHT.make();
        IUnit unit3 = UnitType.WARRIOR.make();

        Game.FightResult resultFight1 = Game.fight(unit1, unit2);
        assertEquals(resultFight1, Game.FightResult.SECOND_WIN);

        Game.FightResult resultFight2 = Game.fight(unit2, unit3);
        assertEquals(resultFight2, Game.FightResult.SECOND_WIN);
    }

    // A couple of parameterized tests for learning how they function
    @ParameterizedTest
    @MethodSource("warriorsPairsFirstWins")
    @DisplayName("First unit should win")
    void firstUnitWins(IUnit first, IUnit second) {
        assertEquals(Game.fight(first, second), Game.FightResult.FIRST_WIN);
    }

    static Stream<Arguments> warriorsPairsFirstWins() {
        return Stream.of(
                Arguments.arguments(UnitType.WARRIOR.make(), UnitType.WARRIOR.make()),
                Arguments.arguments(UnitType.KNIGHT.make(), UnitType.WARRIOR.make()),
                Arguments.arguments(UnitType.KNIGHT.make(), UnitType.KNIGHT.make()),
                Arguments.arguments(UnitType.DEFENDER.make(), UnitType.WARRIOR.make())
        );
    }

    @ParameterizedTest
    @MethodSource("warriorsPairsSecondWins")
    @DisplayName("Second unit should win")
    void secondUnitWins(IUnit first, IUnit second) {
        assertEquals(Game.fight(first, second), Game.FightResult.SECOND_WIN);
    }

    static Stream<Arguments> warriorsPairsSecondWins() {
        return Stream.of(
                Arguments.arguments(UnitType.WARRIOR.make(), UnitType.KNIGHT.make())
        );
    }

    @Test
    void defenderSmokeTest() {
        var chuck = UnitType.WARRIOR.make();
        var bruce = UnitType.WARRIOR.make();
        var carl = UnitType.KNIGHT.make();
        var dave = UnitType.WARRIOR.make();
        var mark = UnitType.WARRIOR.make();
        var bob = UnitType.DEFENDER.make();
        var mike = UnitType.KNIGHT.make();
        var rog = UnitType.WARRIOR.make();
        var lancelot = UnitType.DEFENDER.make();

        // Making a fight between chuck and bruce + dave vs carl
        assertEquals(Game.fight(chuck, bruce), Game.FightResult.FIRST_WIN);
        assertEquals(Game.fight(dave, carl), Game.FightResult.SECOND_WIN);
        assertTrue(chuck.isAlive());
        assertFalse(bruce.isAlive());
        assertTrue(carl.isAlive());
        assertFalse(dave.isAlive());

        // Making a fight Carl vs Mark
        assertEquals(Game.fight(carl, mark), Game.FightResult.SECOND_WIN);
        assertFalse(carl.isAlive());

        // Making fights Bob vs Mike and Lancelot vs Rog
        assertEquals(Game.fight(bob, mike), Game.FightResult.SECOND_WIN);
        assertEquals(Game.fight(lancelot, rog), Game.FightResult.FIRST_WIN);

        // Making fights 1D vs 2W and 1W+1D vs 2W
        var myArmy1 = new Army().addUnits(UnitType.DEFENDER, 1);
        var enemyArmy1 = new Army().addUnits(UnitType.WARRIOR, 2);
        var myArmy2 = new Army().addUnits(UnitType.WARRIOR, 1).addUnits(UnitType.DEFENDER, 1);
        var enemyArmy2 = new Army().addUnits(UnitType.WARRIOR, 2);

        // 2W > 1D, 1W+1D > 2W
        assertEquals(Game.fight(myArmy1, enemyArmy1), Game.FightResult.SECOND_WIN);
        assertEquals(Game.fight(myArmy2, enemyArmy2), Game.FightResult.FIRST_WIN);
    }

    @Test
    void DefenderVsVampire() {
        var defender = UnitType.DEFENDER.make();
        var vampire = UnitType.VAMPIRE.make();

        var result = Game.fight(defender, vampire);

        assertAll(
                () -> assertEquals(result, Game.FightResult.FIRST_WIN),
                () -> assertEquals(22, defender.getHealth()),
                () -> assertEquals(-1, vampire.getHealth())
        );
    }
}