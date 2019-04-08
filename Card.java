package FST;//
//
// Card.java
// ComputerScience
//
// Copyright © 2019 Noah Wilder and Etan Ossip. All rights reserved.
// Last modified on 08/04/19 11:24 AM.

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Scanner;


public class Card implements Serializable, Comparable<Card> {

    public Rank rank;
    public Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public static Card getCardInput(Scanner from) {

        var sc = from;
        sc.useDelimiter("\n");

        System.out.println("Please input the rank of your card.");

        while (!sc.hasNext("(.+)") || !sc.match().group().matches(Rank.validRankRegex)) {
            System.out.println("Invalid rank, please try again.");
            sc.next();
        }
        var rank = Rank.from(sc.next());

        System.out.println("Please input the suit of your card.");
        while (!sc.hasNext("(.+)") || !sc.match().group().matches(Suit.validSuitRegex)) {
            System.out.println("Invalid suit, please try again.");
            sc.next();
        }
        var suit = Suit.from(sc.next());

        var card = new Card(rank, suit);

        return card;
    }

    public static final Card[] deck = Arrays.stream(Suit.values()).flatMap(s -> Arrays.stream(Rank.values()).map(r -> new Card(r, s))).toArray(Card[]::new);

    public enum Rank implements Comparable<Rank> {
        two, three, four, five, six, seven, eight, nine, ten, jack, queen, king, ace;

        public static final String validRankRegex = "(?i)^([2-9]|two|three|four|five|six|seven|eight|nine|10|ten|11|j|jack|12|queen|q|13|king|k|14|1|ace|a)$";

        public String validRegex() {
            switch (this) {
                case two: return "(?i)^(2|two)$";
                case three: return "(?i)^(3|three)$";
                case four: return "(?i)^(4|four)$";
                case five: return "(?i)^(5|five)$";
                case six: return "(?i)^(6|six)$";
                case seven: return "(?i)^(7|seven)$";
                case eight: return "(?i)^(8|eight)$";
                case nine: return "(?i)^(9|nine)$";
                case ten: return "(?i)^(10|ten)$";
                case jack: return "(?i)^(11|j|jack)$";
                case queen: return "(?i)^(12|q|queen)$";
                case king: return "(?i)^(13|k|king)$";
                case ace: return "(?i)^(14|1|a|ace)$";
                default: throw new IllegalArgumentException("Impossible");
            }
        }

        public static Rank from(String str) throws IllegalFormatException {
            for (var rank: Rank.values()) {
                if (str.toLowerCase().matches(rank.validRegex())) {
                    return rank;
                }
            }
            throw new IllegalArgumentException("Invalid string for Rank initialization");
        }

        @Override
        public String toString() {
            switch (this) {
                case two: return "2";
                case three: return "3";
                case four: return "4";
                case five: return "5";
                case six: return "6";
                case seven: return "7";
                case eight: return "8";
                case nine: return "9";
                case ten: return "10";
                case jack: return "J";
                case queen: return "Q";
                case king: return "K";
                case ace: return "A";
                default: throw new IllegalArgumentException("Impossible");
            }
        }
    }

    public enum Suit implements Comparable<Suit> {
        hearts, diamonds, spades, clubs;
        public static final String validSuitRegex = "^(♥︎|h|hearts|♦︎|d|diamonds|♠︎︎|s|spades|♣︎︎|c|clubs)$";

        public String validRegex() {
            switch (this) {
                case hearts: return "^(♥︎|h|hearts)$";
                case diamonds: return "^(♦︎|d|diamonds)$";
                case spades: return "^(♠︎︎|s|spades)$";
                case clubs: return "^(♣︎︎|c|clubs)$";
                default: throw new IllegalArgumentException("Impossible");
            }
        }

        public static Suit from(String str) throws IllegalFormatException {
            for (var suit: Suit.values()) {
                if (str.toLowerCase().matches(suit.validRegex())) {
                    return suit;
                }
            }

            throw new IllegalArgumentException("Invalid string for Suit initialization");
        }

        @Override
        public String toString() {
            switch (this) {
                case hearts: return "♥︎";
                case diamonds: return "♦︎";
                case spades: return "♠︎";
                case clubs: return "♣︎";
                default: throw new IllegalArgumentException("Impossible");
            }
        }
    }

    @Override
    public int compareTo(@NotNull Card o) {
        if (suit.equals(o.suit)) {
            return rank.compareTo(o.rank);
        } else {
            return suit.compareTo(o.suit);
        }
    }

    @Override
    public String toString() {
        return "" + rank + suit;
    }

}
