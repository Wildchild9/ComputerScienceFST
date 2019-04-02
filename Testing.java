package FST;

//
// Testing.java
// ComputerScience
//
// Copyright © 2019 Noah Wilder and Etan Ossip. All rights reserved.
// Last modified on 01/04/19 2:22 PM.

import java.util.Objects;
import java.util.function.Supplier;


public class Testing {
    
    public static void main(String[] args) {
        
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
