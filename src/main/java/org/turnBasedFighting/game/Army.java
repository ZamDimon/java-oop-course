package org.turnBasedFighting.game;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Army implements Iterable<IUnit> {
    // Identifier
    private static int idCounter = 0;
    private final int id = ++idCounter;

    // Data structure to store units
    private final Queue<IUnit> troops = new ArrayDeque<>();

    public Army addUnits(Supplier<IUnit> unitFactory, int number) {
        IntStream.rangeClosed(1, number).forEach(i -> troops.add(unitFactory.get()));
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
