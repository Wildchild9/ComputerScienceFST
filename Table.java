package FST;


//
// Table.java
// ComputerScience
//
// Copyright © 2019 Noah Wilder and Etan Ossip. All rights reserved.
// Last modified on 02/05/19 4:26 PM.


import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public class Table implements Serializable {

    public final Stage stage;
    private final Card[] cards;

    private Table(Stage stage, Card[] cards) {
        this.stage = stage;
        this.cards = cards;
    }

    public static <T extends Collection<Card>> Optional<Table> of(T cards, Stage stage) {
        if (cards.size() != stage.numberOfCards()) {
            return Optional.empty();
        }
        return Optional.of(new Table(stage, cards.toArray(Card[]::new)));
    }
    public static Optional<Table> of(Card[] cards, Stage stage) {
        if (cards.length != stage.numberOfCards()) {
            return Optional.empty();
        }
        return Optional.of(new Table(stage, cards));
    }

    public Card[] getCards() {
        return cards;
    }

    public enum Stage implements Comparable<Stage> {
        preflop, flop, turn, river;

        public int numberOfCards() {
            switch (this) {
                case preflop: return 0;
                case flop:    return 3;
                case turn:    return 4;
                case river:   return 5;
                default: throw new IllegalArgumentException("Impossible");
            }
        }

        public static Optional<Stage> of(int numberOfCards) {
            for (var stage: Stage.values()) {
                if (stage.numberOfCards() == numberOfCards) {
                    return Optional.of(stage);
                }
            }
            return Optional.empty();
        }

        @Override
        public String toString() {
            switch (this) {
                case preflop: return "Pre-flop";
                case flop:    return "Flop";
                case turn:    return "Turn";
                case river:   return "River";
                default: throw new IllegalArgumentException("Impossible");
            }
        }
    }


    @Override
    public String toString() {
        var str = new StringBuilder();
        str.append("══════════════════════════\n");
        str.append(Utils.padCentered(Utils.underlined(stage.toString()), 26)).append("\n");
        str.append(" ".repeat(26)).append("\n");

        var cardLine = new StringBuilder();
        for (var card: cards) {
            cardLine.append(" ").append(card.toString()).append(" ");
        }

        str.append(Utils.padCentered(cardLine.toString(), 26)).append("\n");
        str.append("══════════════════════════");

        return str.toString();
    }

}
/*
 ╔══════════════════════════╗
 ║           F̲l̲o̲p̲           ║
 ║                          ║
 ║ ╭──╮ ╭──╮ ╭──╮ ╭──╮ ╭──╮ ║
 ║ │4♥│ │7♣│ │8♦│ │9♠│ │A♦│ ║
 ║ ╰──╯ ╰──╯ ╰──╯ ╰──╯ ╰──╯ ║
 ╚══════════════════════════╝
 ╔══════════════════════════╗
 ║           F̲l̲o̲p̲           ║
 ║                          ║
 ║ ╭──╮ ╭──╮ ╭──╮ ╭──╮ ╭──╮ ║
 ║ │4♥│ │7♣│ │8♦│ │  │ │  │ ║
 ║ ╰──╯ ╰──╯ ╰──╯ ╰──╯ ╰──╯ ║
 ╚══════════════════════════╝
 */