package org.example.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    /*
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
        Warrior carl = new Warrior();
        Warrior jim = new Knight();

        Game.FightResult result = Game.fight(carl, jim);

        assertEquals(result, Game.FightResult.SECOND_WIN);
    }

    /*
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
        Warrior ramon = new Knight();
        Warrior slevin = new Warrior();

        Game.FightResult result = Game.fight(ramon, slevin);

        assertEquals(result, Game.FightResult.FIRST_WIN);
    }

    /*
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
        Warrior bob = new Warrior();
        Warrior mars = new Warrior();

        Game.fight(bob, mars);

        assertTrue(bob.isAlive());
    }

    /*
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
        Warrior zeus = new Knight();
        Warrior godkiller = new Warrior();

        Game.fight(zeus, godkiller);

        assertTrue(zeus.isAlive());
    }

    /*
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
        Warrior husband = new Warrior();
        Warrior wife = new Warrior();

        Game.fight(husband, wife);

        assertFalse(wife.isAlive());
    }

    /*
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
        Warrior dragon = new Warrior();
        Warrior knight = new Knight();

        Game.FightResult result = Game.fight(dragon, knight);

        assertTrue(knight.isAlive());
    }

    /*
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
        Warrior unit1 = new Warrior();
        Warrior unit2 = new Knight();
        Warrior unit3 = new Warrior();

        Game.FightResult resultFight1 = Game.fight(unit1, unit2);
        assertEquals(resultFight1, Game.FightResult.SECOND_WIN);

        Game.FightResult resultFight2 = Game.fight(unit2, unit3);
        assertEquals(resultFight2, Game.FightResult.SECOND_WIN);
    }
}