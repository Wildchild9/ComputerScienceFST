package FST;
//
//  CCCJunior2018
//  Hand
//
//  Created by Etan Ossip on 4/8/19.
//  Copyright © 2019 Etan Ossip. All rights reserved.
//

import java.util.Arrays;

public class Hand {
    Card c1;
    Card c2;
    Card c3;
    Card c4;
    Card c5;

    public Hand(Card c1, Card c2, Card c3, Card c4, Card c5) {
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
        this.c5 = c5;
    }

    public Hand(Card[] arr) {
        Testing.assertEqual(arr.length, 5);
        c1 = arr[0];
        c2 = arr[1];
        c3 = arr[2];
        c4 = arr[3];
        c5 = arr[4];
    }
;
    public Card[] cardArray() {
        Card[] arr = {c1, c2, c3, c4, c5};
        return arr;
    }

    @Override
    public String toString() {
        return Arrays.toString(cardArray());
    }
}
