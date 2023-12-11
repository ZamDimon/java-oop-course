package org.turnBasedFighting.game;

public interface IUnit extends IHealthable, IHittable, IHitting {
    int getAttack();
}
