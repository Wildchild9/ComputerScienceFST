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


        System.out.println("\nHole: " + hole);

        System.out.println("\nLoading...\n");

        var apiResponseOptional = hole.apiResponse(table);

        if (apiResponseOptional.isEmpty()) {
            System.out.println("There was an error calculating the statistics for your hand.\nPlease check your connection and try again later.");
            return;
        }
        var apiResponse = apiResponseOptional.get();

        var probability = hole.getOdds(table, apiResponse);
        var topHand = hole.getTopHand(table, apiResponse);

        if (table.stage.equals(Table.Stage.river)) {
            System.out.println("\n" + Utils.underlined("Probability:") + " " + probability + "\n");
            System.out.println(Utils.underlined("Your hand:") + " " + topHand);
            return;
        }

        var averageHand = hole.getAvgHand(table, apiResponse);
        var worstHand = hole.getWorstHand(table, apiResponse);



        if (topHand.isEmpty() || averageHand.isEmpty() || worstHand.isEmpty()) {
            System.out.println("\nThere was an error calculating the statistics for your hand.\nPlease check your connection and try again later.");
            return;
        }

        System.out.println("\n" + Utils.underlined("Statistics for " + table.stage.next().get().name() + ":\n"));

        System.out.println("\n" + Utils.underlined("Probability:") + " " + probability + "\n");
        System.out.println(Utils.underlined("Best case hand:") + " " + topHand.toLowerCase());
        System.out.println(Utils.underlined("Average hand:") + " " + averageHand.toLowerCase());
        System.out.println(Utils.underlined("Worst case hand:") + " " + worstHand.toLowerCase());

        if (hole.chanceToHit(Hand.onePair, table, apiResponse).isEmpty()) {
            return;
        }

        System.out.println("\n▿ " + Utils.underlined("Chance to hit"));
        for (var hand: Hand.values()) {
            System.out.println("  - " + hand + ": " + hole.chanceToHit(hand, table, apiResponse).get() + "%\n");
        }

        System.out.println("\n▿ " + Utils.underlined("Chance to hit at least"));
        for (var hand: Hand.values()) {
            System.out.println("  - " + hand + ": " + hole.chanceToHitAtLeast(hand, table, apiResponse).get() + "%\n");

        }
    }
}
