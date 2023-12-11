package org.turnBasedFighting.game;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Army implements Iterable<IUnit> {
    // Identifier
    private static int idCounter = 0;
    private final int id = ++idCounter;

    // Data structure to store units
    private final Deque<UnitInArmy> troops = new ArrayDeque<>();

    private class UnitInArmy implements IUnitInArmy {
        final IUnit unit;
        IUnitInArmy nextUnit;

        public UnitInArmy(IUnit unit) {
            this.unit = Objects.requireNonNull(unit);
        }

        public void setNextUnit(IUnitInArmy nextUnit) {
            this.nextUnit = Objects.requireNonNull(nextUnit);
        }

        @Override
        public Optional<IUnit> getNextUnit() {
            return Optional.ofNullable(nextUnit);
        }

        @Override
        public boolean isAlive() {
            return unit.isAlive();
        }

        @Override
        public int getHealth() {
            return unit.getHealth();
        }

        @Override
        public int getAttack() {
            return unit.getAttack();
        }

        @Override
        public void hit(IHittable target) {
            unit.hit(target);
        }

        @Override
        public boolean acceptDamage(int damage) {
            return unit.acceptDamage(damage);
        }

        @Override
        public String toString() {
            return unit.toString();
        }
    }

    public Army addUnits(Supplier<IUnit> unitFactory, int number) {
        IntStream.rangeClosed(1, number).forEach(i -> {
            IUnit unit = unitFactory.get();
            var unitInArmy = new UnitInArmy(unit);
            Optional.ofNullable(troops.peekLast())
                    .ifPresent(last -> last.setNextUnit(unitInArmy));

            troops.add(unitInArmy);
        });
        return this;
    }

    public Army addUnits(UnitType unitClass, int number) {
        return this.addUnits(unitClass::make, number);
    }

    @Override
    public Iterator<IUnit> iterator() {
        return new FirstAliveIterator();
    }

    private class FirstAliveIterator implements Iterator<IUnit> {
        @Override
        public boolean hasNext() {
            while (!troops.isEmpty() && !troops.peek().isAlive()) {
                troops.poll();
            }
            return !troops.isEmpty();
        }

        @Override
        public IUnit next() {
            if (!hasNext()) throw new NoSuchElementException();
            return troops.peek();
        }
    }

    @Override
    public String toString() {
        String armyName = getClass().getSimpleName().toUpperCase();
        return armyName + "#" + id +
                "{troops=" + troops + "}";
    }
}
