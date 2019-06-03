package FST;

//
// Testing.java
// ComputerScience
//
// Copyright © 2019 Noah Wilder and Etan Ossip. All rights reserved.
// Last modified on 01/04/19 2:22 PM.

import java.util.Objects;
import java.util.function.Supplier;


/**
 A class where testing is conducted.
 */
public class Testing {

    /**
     The entry point of application.

     @param args the input arguments
     */
    public static void main(String[] args) {

        assertEqual(Utils.joined(new int[] {1, 2, 3, 4, 5, 6}, "-"), "1-2-3-4-5-6");

        assertEqual(Utils.graphemeClustersCount("2̲3̲4̲"), 3);

        precondition(Utils.contains(4, new long[]{1, 2, 3, 4, 5, 6, 7}));

        assertEqual(Utils.padLeft("Hello, World!", 15), "  Hello, World!");

        var hole = new Hole(new Card(Card.Rank.ace, Card.Suit.spades),
                            new Card(Card.Rank.king, Card.Suit.spades));

        var table = Table.of(new Card[] {
                new Card(Card.Rank.queen, Card.Suit.spades),
                new Card(Card.Rank.jack, Card.Suit.spades),
                new Card(Card.Rank.three, Card.Suit.diamonds),
                new Card(Card.Rank.seven, Card.Suit.clubs),
                new Card(Card.Rank.ten, Card.Suit.spades)
        });

        precondition(table.isPresent());

        assertEqual(table.get().stage, Table.Stage.river);

        var request1 = hole.apiResponse(table.get());

        if (request1.isPresent()) {

            assertEqual(hole.getOdds(table.get(), request1.get()), 100.0);

        }

        var emptyTable = Table.of(new Card[]{ });

        precondition(emptyTable.isPresent());

        assertEqual(emptyTable.get().stage, Table.Stage.preflop);

        var request2 = hole.apiResponse(emptyTable.get());

        if (request2.isPresent()) {

            var chanceToHitAtLeast = hole.chanceToHitAtLeast(Hand.highCard, emptyTable.get(), request2.get());

            precondition(chanceToHitAtLeast.isPresent());

            assertEqual(chanceToHitAtLeast.get(), 100.0);

            assertNotEqual(hole.chanceToHit(Hand.straight, emptyTable.get(), request2.get()), 100.0);

        }

        assertEqual(Card.deck().length, 52);

        assertGreaterThan(Hand.flush, Hand.straight);

        assertLessThan(Hand.twoPair, Hand.fullHouse);

        System.out.println("All tests passed.");

    }


    /**
     Checks that {@code condition} is {@code true}, otherwise an  {@code AssertionError} is thrown.

     @param condition the condition to check.
     */
    public static void precondition(boolean condition) {
        if (!condition) {
            throw new AssertionError();
        }
    }

    /**
     Checks that {@code condition} evaluates to {@code true}, otherwise an  {@code AssertionError} is thrown.

     @param condition the condition to check.
     */
    public static void precondition(Supplier<Boolean> condition) {
        if (!condition.get()) {
            throw new AssertionError();
        }
    }

    /**
     Asserts that {@code o1} is equal to {@code o2}. If the assertion fails, an {@code AssertionError} is thrown.

     @param o1 the first object being checked for equality.
     @param o2 the second object being checked for equality.
     */
    public static void assertEqual(Object o1, Object o2) {
        if (!Objects.equals(o1, o2)) {
            throw new AssertionError();
        }
    }

    /**
     Asserts that {@code o1} is not equal to {@code o2}. If the assertion fails, an {@code AssertionError} is thrown.

     @param o1 the first object being checked for inequality.
     @param o2 the second object being checked for inequality.
     */
    public static void assertNotEqual(Object o1, Object o2) {
        if (Objects.equals(o1, o2)) {
            throw new AssertionError();
        }
    }

    /**
     Asserts that {@code o1} is less than {@code o2}. If the assertion fails, an {@code AssertionError} is thrown.

     @param <T> the type of an object being compared to an object of type {@code U}.
     @param <U> the type of an object being compared to by an object of type {@code T}.
     @param o1  the object being checked if it is less than {@code o2}.
     @param o2  the object being compared to by {@code o1.}
     */
    public static <T extends Comparable<U>, U> void assertLessThan(T o1, U o2) {
        if (!(o1.compareTo(o2) < 0)) {
            throw new AssertionError();
        }
    }

    /**
     Asserts that {@code o1} is greater than {@code o2}. If the assertion fails, an {@code AssertionError} is thrown.

     @param <T> the type of an object being compared to an object of type {@code U}.
     @param <U> the type of an object being compared to by an object of type {@code T}.
     @param o1  the object being checked if it is greater than {@code o2}.
     @param o2  the object being compared to by {@code o1.}
     */
    public static <T extends Comparable<U>, U> void assertGreaterThan(T o1, U o2) {
        if (!(o1.compareTo(o2) > 0)) {
            throw new AssertionError();
        }
    }

    /**
     Asserts that {@code o1} is less than or equal to {@code o2}. If the assertion fails, an {@code AssertionError} is
     thrown.

     @param <T> the type of an object being compared to an object of type {@code U}.
     @param <U> the type of an object being compared to by an object of type {@code T}.
     @param o1  the object being checked if it is less than or equal to {@code o2}.
     @param o2  the object being compared to by {@code o1.}
     */
    public static <T extends Comparable<U>, U> void assertLessThanOrEqual(T o1, U o2) {
        if (!(o1.compareTo(o2) <= 0)) {
            throw new AssertionError();
        }
    }

    /**
     Asserts that {@code o1} is greater than or equal to {@code o2}. If the assertion fails, an {@code AssertionError} is
     thrown.

     @param <T> the type of an object being compared to an object of type {@code U}.
     @param <U> the type of an object being compared to by an object of type {@code T}.
     @param o1  the object being checked if it is greater than or equal to {@code o2}.
     @param o2  the object being compared to by {@code o1.}
     */
    public static <T extends Comparable<U>, U> void assertGreaterThanOrEqual(T o1, U o2) {
        if (!(o1.compareTo(o2) >= 0)) {
            throw new AssertionError();
        }
    }
}
