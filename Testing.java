package FST;

//
// Testing.java
// ComputerScience
//
// Copyright © 2019 Noah Wilder and Etan Ossip. All rights reserved.
// Last modified on 01/04/19 2:22 PM.

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Supplier;


public class Testing {
    
    public static void main(String[] args) {

        var thing = "";

        var sc = new Scanner(System.in);

        var header = "Poker Hand Odds Calculator";

        System.out.println('┌' + "─".repeat(header.length()));
        System.out.println('│' + header);

        System.out.println("What is the first card in your hand");
        var c1 = Card.getCardInput(sc);

        System.out.println("What is the second card in your hand");
        var c2 = Card.getCardInput(sc, c1);

        var hole = new Hole(c1, c2);

        System.out.println("How many cards are on the table (0, 3, 4, or 5)");
        var amt = Utils.nextValidInt(sc, "There must be either 0, 3, 4, or 5 cards on the table. Please try again.", (x) -> x == 0 || (x >= 3 && x <= 5));

        var board = new ArrayList<Card>();

        var ordinalNums = new String[] {"first", "second", "third", "fourth", "fifth"};

        for (int i = 0; i < amt; i++) {
            System.out.println("Please input the " + ordinalNums[i] + " card on the board");
            var usedCards = new ArrayList<Card>(board.size() + 2);
            usedCards.addAll(board);
            usedCards.add(c1);
            usedCards.add(c2);
            board.add(Card.getCardInput(sc, usedCards));
        }
        

        
    }


    // Testing method suite
    public static void precondition(boolean condition) {
        if (!condition) {
            throw new AssertionError();
        }
    }
    public static void precondition(Supplier<Boolean> condition) {
        if (!condition.get()) {
            throw new AssertionError();
        }
    }
    public static void assertEqual(Object o1, Object o2) {
        if (!Objects.equals(o1, o2)) {
            throw new AssertionError();
        }
    }
    public static void assertNotEqual(Object o1, Object o2) {
        if (Objects.equals(o1, o2)) {
            throw new AssertionError();
        }
    }
    public static <T extends Comparable<U>, U> void assertLessThan(T o1, U o2) {
        if (!(o1.compareTo(o2) < 0)) {
            throw new AssertionError();
        }
    }
    public static <T extends Comparable<U>, U> void assertGreaterThan(T o1, U o2) {
        if (!(o1.compareTo(o2) > 0)) {
            throw new AssertionError();
        }
    }
    public static <T extends Comparable<U>, U> void assertLessThanOrEqual(T o1, U o2) {
        if (!(o1.compareTo(o2) <= 0)) {
            throw new AssertionError();
        }
    }
    public static <T extends Comparable<U>, U> void assertGreaterThanOrEqual(T o1, U o2) {
        if (!(o1.compareTo(o2) >= 0)) {
            throw new AssertionError();
        }
    }
}
