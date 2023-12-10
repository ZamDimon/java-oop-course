package org.turnBasedFighting;

import org.turnBasedFighting.game.Knight;
import org.turnBasedFighting.game.IUnit;

public class Main {
    public static void main(String[] args) {
        IUnit warrior = new Knight();
        System.out.println(warrior.getAttack());
    }
}