package FST;

//
// Hole.java
// ComputerScience
//
// Copyright © 2019 Noah Wilder and Etan Ossip. All rights reserved.
// Last modified on 15/04/19 2:36 PM.

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 A hole containing a player's two cards.
 */
public class Hole implements Serializable {

    /**
     The first card in the hole.
     */
    Card c1;
    /**
     The second card in the hole.
     */
    Card c2;

    /**
     An array consisting of both cards of the hole.

     @return An array consisting of both cards of the hole.
     */
    public Card[] cardArray() {
        return new Card[] {c1, c2};
    }

    /**
     A new instance of {@code Hole} consisting of {@code c1} and {@code c2}.

     @param c1 the first card of the hole.
     @param c2 the second card of the hole.
     */
    public Hole(Card c1, Card c2) {
        this.c1 = c1;
        this.c2 = c2;

    }

    /**
     Returns the response of the API call.

     @param withTable the table with which to make the API call.

     @return An optional of the API response. Returns {@code Optional.empty()} if an error occurs during the API call.
     */
    public Optional<HttpResponse<JsonNode>> apiResponse(Table withTable) {
        var table = withTable;


        var holeStr = "hole=" + Arrays.stream(cardArray()).map(c -> (c.rank.equals(Card.Rank.ten) ? "T" : c.rank.toString().toUpperCase()) + ("" + c.suit.name().charAt(0)).toLowerCase()).collect(Collectors.joining("%2C"));
        var tableStr = table.stage.equals(Table.Stage.preflop) ? "" : "board=" + Arrays.stream(table.getCards()).map(c -> (c.rank.equals(Card.Rank.ten) ? "T" : c.rank.toString().toUpperCase()) + ("" + c.suit.name().charAt(0)).toLowerCase()).collect(Collectors.joining("%2C")) + "&";
        var stageStr = table.stage.toString().toLowerCase();

        try {
            return Optional.of(Unirest.get("https://sf-api-on-demand-poker-odds-v1.p.rapidapi.com/" + stageStr + "?" + tableStr + holeStr)
                                      .header("X-RapidAPI-Host", "sf-api-on-demand-poker-odds-v1.p.rapidapi.com")
                                      .header("X-RapidAPI-Key", "c9032d8530msh14c10fbe1d1fd9ep19fed9jsnf53e3d5f90a0")
                                      .asJson());
        }
        catch (Exception e) {
            return Optional.empty();
        }

    }

    /**
     Returns the odds of winning on the next stage.

     @param withTable the cards on the table of the poker game.
     @param response  the response to the call to the Poker Odds API.

     @return a {@code double} of the probability of winning during the next stage.
     */
    public double getOdds(Table withTable, HttpResponse<JsonNode> response) {

        var table = withTable;
        double avgOdds;


        if (table.stage.equals(Table.Stage.preflop)) {
            avgOdds = response.getBody().getObject()
                              .getJSONObject("data")
                              .getJSONObject("ranking")
                              .getJSONObject("average")
                              .getDouble("rank_top_percent");
        } else if (table.stage.equals(Table.Stage.river)) {
            avgOdds = response.getBody().getObject()
                              .getJSONObject("data")
                              .getJSONObject("winning")
                              .getDouble("probability");
            avgOdds *= 100;

        } else {
            avgOdds = response.getBody().getObject()
                              .getJSONObject("data")
                              .getJSONObject("winning")
                              .getJSONObject("average")
                              .getDouble("probability");
            avgOdds *= 100;

        }
        return avgOdds;

    }


    /**
     The best hand possible on the next stage.

     @param withTable the table with which to calculate the statistic with the hole.
     @param response  the response to the call to the Poker Odds API.

     @return a {@code String} of the best hand possible on the next stage.
     */
    public String getTopHand(Table withTable, HttpResponse<JsonNode> response) {
        var table = withTable;

        String topHand;


        if (table.stage.equals(Table.Stage.preflop)) {
            topHand = response.getBody().getObject()
                    .getJSONObject("data")
                    .getJSONObject("ranking")
                    .getJSONObject("best")
                    .getString("hand_name");
        } else if (table.stage.equals(Table.Stage.river)) {
            topHand = response.getBody().getObject()
                    .getJSONObject("data")
                    .getJSONObject("me")
                    .getString("hand_name");
        } else {
            topHand = response.getBody().getObject()
                    .getJSONObject("data")
                    .getJSONObject("me")
                    .getJSONObject("ranking")
                    .getJSONObject("best")
                    .getString("hand_name");
        }


        return topHand;
    }

    /**
     The average hand possible on the next stage.

     @param withTable the table with which to calculate the statistic with the hole.
     @param response  the response to the call to the Poker Odds API.

     @return a {@code String} of the average hand on the next stage.
     */
    public String getAvgHand(Table withTable, HttpResponse<JsonNode> response) {
        var table = withTable;

        String topHand;


        if (table.stage.equals(Table.Stage.preflop)) {
            topHand = response.getBody().getObject()
                    .getJSONObject("data")
                    .getJSONObject("ranking")
                    .getJSONObject("average")
                    .getString("hand_name");
        } else if (table.stage.equals(Table.Stage.river)) {
            topHand = response.getBody().getObject()
                    .getJSONObject("data")
                    .getJSONObject("me")
                    .getString("hand_name");
        } else {
            topHand = response.getBody().getObject()
                    .getJSONObject("data")
                    .getJSONObject("me")
                    .getJSONObject("ranking")
                    .getJSONObject("average")
                    .getString("hand_name");
        }


        return topHand;
    }

    /**
     The worst hand possible on the next stage.

     @param withTable the table with which to calculate the statistic with the hole.
     @param response  the response to the call to the Poker Odds API.

     @return a {@code String} of the worst hand possible on the next stage.
     */
    public String getWorstHand(Table withTable, HttpResponse<JsonNode> response) {
        var table = withTable;

        String topHand;


        if (table.stage.equals(Table.Stage.preflop)) {
            topHand = response.getBody().getObject()
                    .getJSONObject("data")
                    .getJSONObject("ranking")
                    .getJSONObject("worst")
                    .getString("hand_name");
        } else if (table.stage.equals(Table.Stage.river)) {
            topHand = response.getBody().getObject()
                    .getJSONObject("data")
                    .getJSONObject("me")
                    .getString("hand_name");
        } else {
            topHand = response.getBody().getObject()
                    .getJSONObject("data")
                    .getJSONObject("me")
                    .getJSONObject("ranking")
                    .getJSONObject("worst")
                    .getString("hand_name");
        }


        return topHand;
    }

    /**
     The chance to hit the {@code hand}.

     @param hand      the hand to get the chance to hit for.
     @param withTable the table with which to calculate the statistic with the hole.
     @param response  the response to the call to the Poker Odds API.

     @return An optional of the chance to hit the specified hand. Returns {@code Optional.empty()}if the stage of the
     table is the {@code Table.Stage.river}.
     */
    public Optional<Double> chanceToHit(Hand hand, Table withTable, HttpResponse<JsonNode> response) {
        var table = withTable;

        double hitChance;


        if (table.stage.equals(Table.Stage.preflop)) {
            hitChance = response.getBody().getObject()
                    .getJSONObject("data")
                    .getJSONObject("hit")
                    .getDouble(hand.identifier()) * 100.0;
        } else if (table.stage.equals(Table.Stage.river)) {
            return Optional.empty();
        } else {
            hitChance = response.getBody().getObject()
                    .getJSONObject("data")
                    .getJSONObject("me")
                    .getJSONObject("hit")
                    .getDouble(hand.identifier()) * 100.0;
        }


        return Optional.of(hitChance);
    }

    /**
     The chance to hit at least the {@code hand}.

     @param hand      the hand to get the chance to hit at least for.
     @param withTable the table with which to calculate the statistic with the hole.
     @param response  the response to the call to the Poker Odds API.

     @return An optional of the chance to hit at least the specified hand. Returns {@code Optional.empty()}if the stage
     of the table is the {@code Table.Stage.river}.
     */
    public Optional<Double> chanceToHitAtLeast(Hand hand, Table withTable, HttpResponse<JsonNode> response) {
        var table = withTable;

        double hitChance;

        if (table.stage.equals(Table.Stage.preflop)) {
            hitChance = response.getBody().getObject()
                    .getJSONObject("data")
                    .getJSONObject("hit_at_least")
                    .getDouble(hand.identifier()) * 100.0;
        } else if (table.stage.equals(Table.Stage.river)) {
            return Optional.empty();
        } else {
            hitChance = response.getBody().getObject().getJSONObject("data").getJSONObject("me").getJSONObject("hit_at_least").getDouble(hand.identifier()) * 100.0;
        }


        return Optional.of(hitChance);
    }

    @Override
    public String toString() {
        return c1 + ", " + c2;
    }
}

