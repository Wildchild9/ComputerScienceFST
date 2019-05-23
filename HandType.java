package FST;
//
//  CCCJunior2018
//  HandRankingThingy
//
//  Created by Etan Ossip on 2019-05-22.
//  Copyright © 2019 Etan Ossip. All rights reserved.
//

public class HandType {

    public enum Hands {
        HighCard, OnePair, TwoPair, ThreeOfAKind, FourOfAKind, FullHouse, Flush, StraightFlush, Straight;

        public String asString() {
            switch (this) {
                case Flush: return "FL";
                case OnePair: return "1P";
                case TwoPair: return "2P";
                case HighCard: return "HC";
                case Straight: return "ST";
                case FullHouse: return "FH";
                case FourOfAKind: return "4K";
                case ThreeOfAKind: return "3K";
                case StraightFlush: return "SF";
            }
            return "What...";
        }
    }
}
