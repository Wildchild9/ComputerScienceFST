package FST;

//
//
// Card.java
// ComputerScience
//
// Copyright © 2019 Noah Wilder and Etan Ossip. All rights reserved.
// Last modified on 08/04/19 11:24 AM.

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 A card with a rank and a suit.
 */
public class Card implements Serializable, Comparable<Card> {

    /**
    The rank of the card.
     */
    public Rank rank;

    /**
     The suit of the card.
     */
    public Suit suit;

    /**
     Constructs a card with the specified rank and suit.

     @param rank the rank of the card.
     @param suit the suit of the card.

     */
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
        new ArrayList<Integer>(43);
    }

    /**
     Gets information to instantiate a new {@code Card} object from the given {@code Scanner} object.
     */
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

    /**
     A card composed of a random suit and rank.

     @return a new pseudorandomly generated {@code Card} object.
     */
    public static Card random() {
        var randomRank = Rank.values()[ThreadLocalRandom.current().nextInt(Rank.values().length)];
        var randomSuit = Suit.values()[ThreadLocalRandom.current().nextInt(Suit.values().length)];

        return new Card(randomRank, randomSuit);
    }

    /**
     A full deck containing all 52 distinct cards sorted by suit then rank.
     */
    public static final Card[] deck = Arrays.stream(Suit.values()).flatMap(s -> Arrays.stream(Rank.values()).map(r -> new Card(r, s))).toArray(Card[]::new);

    /**
     The rank of a card.
     */
    public enum Rank implements Comparable<Rank> {
        two, three, four, five, six, seven, eight, nine, ten, jack, queen, king, ace;

        /**
         A regex string that if matched, ensures that a string is a valid rank.
         */
        public static final String validRankRegex = '(' + Arrays.stream(Rank.values()).map(Rank::validRegex).collect(Collectors.joining("|")) + ')';

        /**
         A regex string that if matched, is a valid {@code String} of the rank.

         @return A regex string that validates a string of the rank.
         */
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

        /**
         The rank of the given string.

         @param str the string of the {@code Rank}.

         @return the rank of the given string.

         @throws IllegalFormatException if {@code str} is an not match any of the ranks. Throws when {@code str} does not match {@code Rank.validRankRegex}.
         */
        public static Rank from(String str) throws IllegalFormatException {
            for (var rank: Rank.values()) {
                if (str.toLowerCase().matches(rank.validRegex())) {
                    return rank;
                }
            }
            throw new IllegalArgumentException("Invalid string for Rank initialization");
        }

        /**
         A textual representation of the rank.

         @return a string describing the rank.
         */
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

    /**
     The suit of a card.
     */
    public enum Suit implements Comparable<Suit> {
        spades, hearts, diamonds, clubs;

        /**
         A regex string that if matched, ensures that a string is a valid suit.
         */
        public static final String validSuitRegex = '(' + Arrays.stream(Suit.values()).map(Suit::validRegex).collect(Collectors.joining("|")) + ')';

        /**
         A regex string that if matched, is a valid {@code String} of the suit.

         @return A regex string that validates a string of the suit.
         */
        public String validRegex() {
            switch (this) {
                case hearts: return "(?i)^(♥︎|h|hearts)$";
                case diamonds: return "(?i)^(♦︎|d|diamonds)$";
                case spades: return "(?i)^(♠︎︎|s|spades)$";
                case clubs: return "(?i)^(♣︎︎|c|clubs)$";
                default: throw new IllegalArgumentException("Impossible");
            }
        }

        /**
         The suit of the given string.

         @param str the string of the {@code Suit}.

         @return the suit of the given string.

         @throws IllegalFormatException if {@code str} is an not match any of the suits. Throws when {@code str} does not match {@code Suit.validSuitRegex}.
         */
        public static Suit from(String str) throws IllegalFormatException {
            for (var suit: Suit.values()) {
                if (str.toLowerCase().matches(suit.validRegex())) {
                    return suit;
                }
            }

            throw new IllegalArgumentException("Invalid string for Suit initialization");
        }

        /**
         A textual representation of the suit.

         @return a string describing the suit.
         */
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

    /**
     The deck of cards with its cards shuffled.

     @param deck the array of cards to shuffle.

     @return an array containing the cards of the deck in a shuffled order.
     */
    public static Card[] shuffling(Card[] deck) {
        if (deck.length <= 1) return deck;
        var list = Arrays.asList(deck);
        Collections.shuffle(list);
        return list.toArray(Card[]::new);
    }

    /**
     Returns a hash code for this card.

     @return a hash code value for this {@code Card} object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }

    /**
     Compares two cards by suit then by rank.

     @param o the {@code Card} object to be compared.

     @return a negative integer, zero, or a positive integer as this {@code Card} object is less than, equal to, or greater than the specified {@code Card} object.

     @throws NullPointerException if the specified {@code Card} object is null.
     */
    @Override
    public int compareTo(Card o) {
        if (this.rank.equals(o.rank)) {
            return this.suit.compareTo(o.suit);
        } else {
            return this.rank.compareTo(o.rank);
        }
    }

    /**
     Indicates whether some object is equal to this card.

     @param obj the object to be checked against this card for equality.

     @return {@code true} if this object is the same as the {@code obj} argument; {@code false} otherwise.

     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Card)) return false;
        var card = (Card) obj;
        return rank == card.rank && suit == card.suit;
    }

    /**
     A textual representation of the card.

     @return a string describing the card.
     */
    @Override
    public String toString() {
        return "" + rank + suit;
    }

}
