package FST;


//
// Main.java
// ComputerScience
//
// Copyright © 2019 Noah Wilder and Etan Ossip. All rights reserved.
// Last modified on 06/05/19 12:27 PM.


import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        var sc = new Scanner(System.in);

        var header = "Poker Hand Odds Calculator";

        System.out.println('┌' + "─".repeat(header.length()));
        System.out.println('│' + header + '\n');

        System.out.println("What is the first card in your hand?");
        var c1 = Card.getCardInput(sc);

        System.out.println("\nWhat is the second card in your hand?");
        var c2 = Card.getCardInput(sc, c1);

        var hole = new Hole(c1, c2);

        System.out.println("\nHole: " + hole);

        System.out.println("\nHow many cards are on the table (0, 3, 4, or 5)");
        var numberOfCards = Utils.nextValidInt(sc, "There must be either 0, 3, 4, or 5 cards on the table. Please try again.", x -> x == 0 || x >= 3 && x <= 5);

        var tableCards = new ArrayList<Card>();

        var usedCards = new ArrayList<Card>(tableCards.size() + 2);
        usedCards.add(c1);
        usedCards.add(c2);

        var ordinalNumbers = new String[]{"first", "second", "third", "fourth", "fifth"};

        for (var i = 0; i < numberOfCards; i++) {
            System.out.println("\nPlease input the " + ordinalNumbers[i] + " card on the table");

            var card = Card.getCardInput(sc, usedCards);
            usedCards.add(card);
            tableCards.add(card);
        }

        var stage = Table.Stage.of(numberOfCards).orElseThrow();

        var table = Table.of(tableCards, stage).orElseThrow();

        System.out.println("\n" + table);

        var probability = hole.getOdds(table);
        var topHand = hole.getTopHand(table);
        var averageHand = hole.getTopHand(table);
        var worstHand = hole.getTopHand(table);

        System.out.println("\nHole: " + hole);


        if (probability.isEmpty() || topHand.isEmpty() || averageHand.isEmpty() || worstHand.isEmpty()) {
            System.out.println("\nThere was a problem calculating the odds of your poker hand. Please check your connection and try again later.");
            return;
        }

        System.out.println("\n" + Utils.underlined("Probability:") + " " + probability.get() + "\n");
        System.out.println("\n" + Utils.underlined("Best case hand:") + " " + topHand.get() + "\n");
        System.out.println("\n" + Utils.underlined("Average hand:") + " " + averageHand.get() + "\n");
        System.out.println("\n" + Utils.underlined("Worst case hand:") + " " + worstHand.get() + "\n");

        if (hole.chanceToHit(HandType.Hand.onePair, table).isEmpty()) {
            return;
        }

        for (HandType.Hand h: HandType.Hand.values()) {
            System.out.println("\n" + Utils.underlined("Chance to hit " + h) + " " + hole.chanceToHit(h, table).get() + "%\n");
        }

        for (HandType.Hand h: HandType.Hand.values()) {
            System.out.println("\n" + Utils.underlined("Chance to hit at least " + h) + " " + hole.chanceToHitAtLeast(h, table).get() + "%\n");
        }
    }
}
