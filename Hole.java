package FST;

//
// Hole.java
// ComputerScience
//
// Copyright © 2019 Noah Wilder and Etan Ossip. All rights reserved.
// Last modified on 15/04/19 2:36 PM.

import java.io.Serializable;


public class Hole implements Serializable {

    Card c1;
    Card c2;

    public Card[] cardArray() {
        return new Card[] {c1, c2};
    }

    public Hole(Card c1, Card c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public String toString() {
        return c1 + ", " + c2;
    }

//    public Optional<Double> getOdds(Table withTable) {
//        var table = withTable;
//
//
//    }
}
