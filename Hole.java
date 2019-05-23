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
import java.util.ArrayList;
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

}

