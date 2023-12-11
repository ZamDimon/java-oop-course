package org.turnBasedFighting.game;

public interface IHittable extends IHealthable {
    boolean acceptDamage(int damage);
}
