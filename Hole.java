package FST;
//
//  CCCJunior2018
//  Hole
//
//  Created by Etan Ossip on 4/15/19.
//  Copyright © 2019 Etan Ossip. All rights reserved.
//

public class Hole {

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
}
