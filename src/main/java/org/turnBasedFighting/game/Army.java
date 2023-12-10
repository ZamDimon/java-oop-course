package org.turnBasedFighting.game;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Army implements Iterable<IUnit> {
    public Army addUnits(Supplier<IUnit> unitFactory, int number) {
        return this;
    }

    public Army addUnits(@org.jetbrains.annotations.NotNull UnitClass unitClass, int number) {
        return this;
    }

    @Override
    public Iterator<IUnit> iterator() {
        return new FirstAliveIterator();
    }

    private class FirstAliveIterator implements Iterator<IUnit> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public IUnit next() {
            return null;
        }
    }
}
