package FST;

//
// Hand.java
// ComputerScience
//
// Copyright © 2019 Noah Wilder and Etan Ossip. All rights reserved.
// Last modified on 23/05/19 10:50 AM.


/**
 The classification of a poker hand.
 */
public enum Hand implements Comparable<Hand> {
    /**
     High card.
     */
    highCard,
    /**
     One pair.
     */
    onePair,
    /**
     Two pair.
     */
    twoPair,
    /**
     Three of a kind.
     */
    threeOfAKind,
    /**
     Straight.
     */
    straight,
    /**
     Flush.
     */
    flush,
    /**
     Full house.
     */
    fullHouse,
    /**
     Four of a kind.
     */
    fourOfAKind,
    /**
     Straight flush.
     */
    straightFlush;


    /**
     Returns an identification string of the hand for API call.

     @return An identification string.
     */
    public String identifier() {
        switch (this) {
            case flush:
                return "FL";
            case onePair:
                return "1P";
            case twoPair:
                return "2P";
            case highCard:
                return "HC";
            case straight:
                return "ST";
            case fullHouse:
                return "FH";
            case fourOfAKind:
                return "4K";
            case threeOfAKind:
                return "3K";
            case straightFlush:
                return "SF";
            default:
                throw new IllegalArgumentException("Unreachable statement");
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case flush:
                return "Flush";
            case onePair:
                return "One pair";
            case twoPair:
                return "Two pair";
            case highCard:
                return "High card";
            case straight:
                return "Straight";
            case fullHouse:
                return "Full house";
            case fourOfAKind:
                return "Four of a kind";
            case threeOfAKind:
                return "Three of a kind";
            case straightFlush:
                return "Straight flush";
            default:
                throw new IllegalArgumentException("Unreachable statement");
        }
    }
}
