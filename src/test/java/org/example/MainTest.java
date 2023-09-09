package org.example;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

import static java.util.AbstractMap.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @org.junit.jupiter.api.Test
    void squareArea() {
        Map<Integer, Integer> tests = new HashMap<>();
        tests.put(2, 4);
        tests.put(3, 9);
        tests.put(4, 16);

        for (Map.Entry<Integer, Integer> test : tests.entrySet()) {
            assertEquals(test.getValue(), Main.SquareArea(test.getKey()));
        }
    }
}