package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.print("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }

    /**
     * @param side side's integer length
     * @return area of the square calculated by side * side
     */
    public static int SquareArea(int side) {
        return side * side;
    }
}