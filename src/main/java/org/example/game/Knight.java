package org.example.game;

public class Knight extends Warrior {
    static final int DEFAULT_ATTACK = 7;

    public Knight() {
        super(Warrior.DEFAULT_HEALTH, DEFAULT_ATTACK);
    }
}
