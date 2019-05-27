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


/**
 A table consisting of the played cards and the corresponding stage of the poker game.
 */
public class Table implements Serializable {

    /**
     The stage of the table.
     */
    public final Stage stage;
    private final Card[] cards;

    private Table(Stage stage, Card[] cards) {
        this.stage = stage;
        this.cards = cards;
    }

    /**
     Returns a new instance of {@code Table} with the specified number of cards. The {@code cards} collection must
     consist of either 0, 3, 4, or 5 cards to be valid.

     @param <T>   the type of collection of cards.
     @param cards the cards on the table.A table consisting of the specified cards. Returns if there are an invalid{@code
     Optional.empty()} if number of cards in {@code cards} is invalid.

     @return the optional
     */
    public static <T extends Collection<Card>> Optional<Table> of(T cards) {
        var optionalStage = Stage.of(cards.size());
        if (optionalStage.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(new Table(optionalStage.get(), cards.toArray(Card[]::new)));
    }

    /**
     Returns a new instance of {@code Table} with the specified number of cards. The {@code cards} array must consist of
     either 0, 3, 4, or 5 cards to be valid.

     @param cards the cards on the table.

     @return A table consisting of the specified cards. Returns if there are an invalid{@code Optional.empty()} if number
     of cards in {@code cards} is invalid.
     */
    public static Optional<Table> of(Card[] cards) {
        var optionalStage = Stage.of(cards.length);
        if (optionalStage.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(new Table(optionalStage.get(), cards));
    }

    /**
     The cards on the table.

     @return an array of the cards on the table.
     */
    public Card[] getCards() {
        return cards;
    }

    /**
     The stage of a poker game.
     */
    public enum Stage implements Comparable<Stage> {
        /**
         Preflop stage.
         */
        preflop,
        /**
         Flop stage.
         */
        flop,
        /**
         Turn stage.
         */
        turn,
        /**
         River stage.
         */
        river;

        /**
         The number of cards on the table at the stage.

         @return an {@code int} of the number of cards on the table.
         */
        public int numberOfCards() {
            switch (this) {
                case preflop: return 0;
                case flop:    return 3;
                case turn:    return 4;
                case river:   return 5;
                default: throw new IllegalArgumentException("Impossible");
            }
        }

        /**
         The stage where in there are the specified {@code numberOfCards} on the table.

         @param numberOfCards the number of cards corresponding to the stage.

         @return the stage with the corresponding amount of cards. Returns {@code Optional.empty()}if no valid stages
         match the number of cards provided.
         */
        public static Optional<Stage> of(int numberOfCards) {
            for (var stage: Stage.values()) {
                if (stage.numberOfCards() == numberOfCards) {
                    return Optional.of(stage);
                }
            }
            return Optional.empty();
        }

        /**
         The next stage after this current stage.

         @return the stage after this stage. Returns {@code Optional.empty()} if the current stage is{@code
         Table.Stage.river}.
         */
        public Optional<Stage> next() {
            switch (this) {
                case preflop: return Optional.of(preflop);
                case flop:    return Optional.of(flop);
                case turn:    return Optional.of(turn);
                case river:   return Optional.empty();
                default: throw new IllegalArgumentException("Impossible");
            }
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

