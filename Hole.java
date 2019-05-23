package FST;

//
// Hole.java
// ComputerScience
//
// Copyright © 2019 Noah Wilder and Etan Ossip. All rights reserved.
// Last modified on 15/04/19 2:36 PM.

import kong.unirest.Unirest;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;


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

    public Optional<Double> getOdds(Table withTable) {
        var table = withTable;

        var holeStr = "hole=" + Arrays.stream(cardArray()).map(c -> (c.rank.equals(Card.Rank.ten) ? "T" : c.rank.toString().toUpperCase()) + ("" + c.suit.name().charAt(0)).toLowerCase()).collect(Collectors.joining("%2C"));
        var tableStr = table.stage.equals(Table.Stage.preflop) ? "" : "board=" + Arrays.stream(table.getCards()).map(c -> (c.rank.equals(Card.Rank.ten) ? "T" : c.rank.toString().toUpperCase()) + ("" + c.suit.name().charAt(0)).toLowerCase()).collect(Collectors.joining("%2C")) + "&";
        var stageStr = table.stage.toString().toLowerCase();

        double avgOdds;
        try {
            var response = Unirest.get("https://sf-api-on-demand-poker-odds-v1.p.rapidapi.com/" + stageStr + "?" + tableStr + holeStr)
                                  .header("X-RapidAPI-Host", "sf-api-on-demand-poker-odds-v1.p.rapidapi.com")
                                  .header("X-RapidAPI-Key", "c9032d8530msh14c10fbe1d1fd9ep19fed9jsnf53e3d5f90a0")
                                  .asJson();

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
        } catch (Exception e) {
            return Optional.empty();
        }

        return Optional.of(avgOdds);

    }

    public Optional<String> getTopHand(Table withTable) {
        var table = withTable;

        var holeStr = "hole=" + Arrays.stream(cardArray()).map(c -> (c.rank.equals(Card.Rank.ten) ? "T" : c.rank.toString().toUpperCase()) + ("" + c.suit.name().charAt(0)).toLowerCase()).collect(Collectors.joining("%2C"));
        var tableStr = table.stage.equals(Table.Stage.preflop) ? "" : "board=" + Arrays.stream(table.getCards()).map(c -> (c.rank.equals(Card.Rank.ten) ? "T" : c.rank.toString().toUpperCase()) + ("" + c.suit.name().charAt(0)).toLowerCase()).collect(Collectors.joining("%2C")) + "&";
        var stageStr = table.stage.toString().toLowerCase();

        String topHand;
        try {
            var response = Unirest.get("https://sf-api-on-demand-poker-odds-v1.p.rapidapi.com/" + stageStr + "?" + tableStr + holeStr)
                    .header("X-RapidAPI-Host", "sf-api-on-demand-poker-odds-v1.p.rapidapi.com")
                    .header("X-RapidAPI-Key", "c9032d8530msh14c10fbe1d1fd9ep19fed9jsnf53e3d5f90a0")
                    .asJson();

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
        } catch (Exception e) {
            return Optional.empty();
        }

        return Optional.of(topHand);
    }

    public Optional<String> getAvgHand(Table withTable) {
        var table = withTable;

        var holeStr = "hole=" + Arrays.stream(cardArray()).map(c -> (c.rank.equals(Card.Rank.ten) ? "T" : c.rank.toString().toUpperCase()) + ("" + c.suit.name().charAt(0)).toLowerCase()).collect(Collectors.joining("%2C"));
        var tableStr = table.stage.equals(Table.Stage.preflop) ? "" : "board=" + Arrays.stream(table.getCards()).map(c -> (c.rank.equals(Card.Rank.ten) ? "T" : c.rank.toString().toUpperCase()) + ("" + c.suit.name().charAt(0)).toLowerCase()).collect(Collectors.joining("%2C")) + "&";
        var stageStr = table.stage.toString().toLowerCase();

        String topHand;
        try {
            var response = Unirest.get("https://sf-api-on-demand-poker-odds-v1.p.rapidapi.com/" + stageStr + "?" + tableStr + holeStr)
                    .header("X-RapidAPI-Host", "sf-api-on-demand-poker-odds-v1.p.rapidapi.com")
                    .header("X-RapidAPI-Key", "c9032d8530msh14c10fbe1d1fd9ep19fed9jsnf53e3d5f90a0")
                    .asJson();

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
        } catch (Exception e) {
            return Optional.empty();
        }

        return Optional.of(topHand);
    }

    public Optional<String> getWorstHand(Table withTable) {
        var table = withTable;

        var holeStr = "hole=" + Arrays.stream(cardArray()).map(c -> (c.rank.equals(Card.Rank.ten) ? "T" : c.rank.toString().toUpperCase()) + ("" + c.suit.name().charAt(0)).toLowerCase()).collect(Collectors.joining("%2C"));
        var tableStr = table.stage.equals(Table.Stage.preflop) ? "" : "board=" + Arrays.stream(table.getCards()).map(c -> (c.rank.equals(Card.Rank.ten) ? "T" : c.rank.toString().toUpperCase()) + ("" + c.suit.name().charAt(0)).toLowerCase()).collect(Collectors.joining("%2C")) + "&";
        var stageStr = table.stage.toString().toLowerCase();

        String topHand;
        try {
            var response = Unirest.get("https://sf-api-on-demand-poker-odds-v1.p.rapidapi.com/" + stageStr + "?" + tableStr + holeStr)
                    .header("X-RapidAPI-Host", "sf-api-on-demand-poker-odds-v1.p.rapidapi.com")
                    .header("X-RapidAPI-Key", "c9032d8530msh14c10fbe1d1fd9ep19fed9jsnf53e3d5f90a0")
                    .asJson();

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
        } catch (Exception e) {
            return Optional.empty();
        }

        return Optional.of(topHand);
    }

    public Optional<Double> chanceToHit(HandType.Hand hand, Table withTable) {
        var table = withTable;

        var holeStr = "hole=" + Arrays.stream(cardArray()).map(c -> (c.rank.equals(Card.Rank.ten) ? "T" : c.rank.toString().toUpperCase()) + ("" + c.suit.name().charAt(0)).toLowerCase()).collect(Collectors.joining("%2C"));
        var tableStr = table.stage.equals(Table.Stage.preflop) ? "" : "board=" + Arrays.stream(table.getCards()).map(c -> (c.rank.equals(Card.Rank.ten) ? "T" : c.rank.toString().toUpperCase()) + ("" + c.suit.name().charAt(0)).toLowerCase()).collect(Collectors.joining("%2C")) + "&";
        var stageStr = table.stage.toString().toLowerCase();

        Double hitChance;
        try {
            var response = Unirest.get("https://sf-api-on-demand-poker-odds-v1.p.rapidapi.com/" + stageStr + "?" + tableStr + holeStr)
                    .header("X-RapidAPI-Host", "sf-api-on-demand-poker-odds-v1.p.rapidapi.com")
                    .header("X-RapidAPI-Key", "c9032d8530msh14c10fbe1d1fd9ep19fed9jsnf53e3d5f90a0")
                    .asJson();

            if (table.stage.equals(Table.Stage.preflop)) {
                hitChance = response.getBody().getObject()
                        .getJSONObject("data")
                        .getJSONObject("hit")
                        .getDouble(hand.asString()) * 100.0;
            } else if (table.stage.equals(Table.Stage.river)) {
                var handString = response.getBody().getObject()
                        .getJSONObject("data")
                        .getJSONObject("me")
                        .getString("hit");
                hitChance = handString.equals(hand.asString()) ? 100.0 : 0.0;
            } else {
                hitChance = response.getBody().getObject()
                        .getJSONObject("data")
                        .getJSONObject("me")
                        .getJSONObject("hit")
                        .getDouble(hand.asString()) * 100.0;
            }
        } catch (Exception e) {
            return Optional.empty();
        }

        return Optional.of(hitChance);
    }

    public Optional<Double> chanceToHitAtLeast(HandType.Hand hand, Table withTable) {
        var table = withTable;

        var holeStr = "hole=" + Arrays.stream(cardArray()).map(c -> (c.rank.equals(Card.Rank.ten) ? "T" : c.rank.toString().toUpperCase()) + ("" + c.suit.name().charAt(0)).toLowerCase()).collect(Collectors.joining("%2C"));
        var tableStr = table.stage.equals(Table.Stage.preflop) ? "" : "board=" + Arrays.stream(table.getCards()).map(c -> (c.rank.equals(Card.Rank.ten) ? "T" : c.rank.toString().toUpperCase()) + ("" + c.suit.name().charAt(0)).toLowerCase()).collect(Collectors.joining("%2C")) + "&";
        var stageStr = table.stage.toString().toLowerCase();

        Double hitChance;
        try {
            var response = Unirest.get("https://sf-api-on-demand-poker-odds-v1.p.rapidapi.com/" + stageStr + "?" + tableStr + holeStr)
                    .header("X-RapidAPI-Host", "sf-api-on-demand-poker-odds-v1.p.rapidapi.com")
                    .header("X-RapidAPI-Key", "c9032d8530msh14c10fbe1d1fd9ep19fed9jsnf53e3d5f90a0")
                    .asJson();

            if (table.stage.equals(Table.Stage.preflop)) {
                hitChance = response.getBody().getObject()
                        .getJSONObject("data")
                        .getJSONObject("hit_at_least")
                        .getDouble(hand.asString()) * 100.0;
            } else if (table.stage.equals(Table.Stage.river)) {
                var handString = response.getBody().getObject()
                        .getJSONObject("data")
                        .getJSONObject("me")
                        .getString("hit");
                hitChance = 0.0;

                if (hand.asString().equals("HC")) {
                    hitChance = 100.0;
                } else if (hand.asString().equals("1P")) {
                    if (handString.equals("2P") || handString.equals("3K") || handString.equals("4K") || handString.equals("FH")) {
                        hitChance = 100.0;
                    }
                } else if (hand.asString().equals("2P")) {
                    if (handString.equals("FH")) {
                        hitChance = 100.0;
                    } else {
                        hitChance = 0.0;
                    }
                } else if (hand.asString().equals("ST") || hand.asString().equals("FL")) {
                    if (handString.equals("SF")) {
                        hitChance = 100.0;
                    }
                } else if (hand.asString().equals("3K")) {
                    if (handString.equals("4K")) {
                        hitChance = 100.0;
                    }
                }

                if (hand.asString().equals(handString)) {
                    hitChance = 100.0;
                }
            } else {
                hitChance = response.getBody().getObject()
                        .getJSONObject("data")
                        .getJSONObject("me")
                        .getJSONObject("hit_at_least")
                        .getDouble(hand.asString()) * 100.0;
            }
        } catch (Exception e) {
            return Optional.empty();
        }

        return Optional.of(hitChance);
    }
}
