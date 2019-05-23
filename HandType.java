package FST;
//
//  CCCJunior2018
//  HandRankingThingy
//
//  Created by Etan Ossip on 2019-05-22.
//  Copyright © 2019 Etan Ossip. All rights reserved.
//

public class HandType {

    public enum Hand {
        highCard, onePair, twoPair, threeOfAKind, fourOfAKind, fullHouse, flush, straightFlush, straight;

        public String asString() {
            switch (this) {
                case flush: return "FL";
                case onePair: return "1P";
                case twoPair: return "2P";
                case highCard: return "HC";
                case straight: return "ST";
                case fullHouse: return "FH";
                case fourOfAKind: return "4K";
                case threeOfAKind: return "3K";
                case straightFlush: return "SF";
            }
            return "What...";
        }

        @Override
        public String toString() {
            switch (this) {
                case flush: return "Flush";
                case onePair: return "One pair";
                case twoPair: return "Two pair";
                case highCard: return "High card";
                case straight: return "Straight";
                case fullHouse: return "Full house";
                case fourOfAKind: return "Four of a kind";
                case threeOfAKind: return "Three of a kind";
                case straightFlush: return "Straight flush";
                default: return "uh what?";
            }
        }
    }
}
