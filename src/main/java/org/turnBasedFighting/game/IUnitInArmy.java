package org.turnBasedFighting.game;

import java.util.Optional;

public interface IUnitInArmy extends IUnit {
    Optional<IUnit> getNextUnit();
}
