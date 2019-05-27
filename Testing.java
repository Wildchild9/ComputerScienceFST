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
