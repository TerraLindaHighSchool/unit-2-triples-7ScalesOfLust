package com.example.bruce.triples_1_5;

import java.util.ArrayList;

public class Deck {
    private Card[] mOrderedDeck;
    private ArrayList<Card> mShuffledDeck;

    Deck(int numOfCardsInDeck){
        mShuffledDeck = new ArrayList<>();
        mOrderedDeck = new Card[numOfCardsInDeck + 1];
        populateOrderedDeckWithCards(numOfCardsInDeck);
        createShuffledDeck();
    }

    private ArrayList createShuffledDeck(){

        for(int i = 1; i < mOrderedDeck.length; i++){
            mShuffledDeck.add(mOrderedDeck[i]);
        }

        for(int i = 0; i < mShuffledDeck.size(); i++){
            int random = (int)(Math.random()*mShuffledDeck.size());
            Card temp = mShuffledDeck.get(i);
            mShuffledDeck.set(i, mShuffledDeck.get(random));
            mShuffledDeck.set(random, temp);
        }

        return mShuffledDeck;
    }

    public int getNumOfCardsInDeck(){
        return mShuffledDeck.size();
    }

    public Card getTopCard(){
        return (mShuffledDeck.size() > 0) ? mShuffledDeck.remove(0) : mOrderedDeck[0];
    }

    public Card getCard(int index){
        return mShuffledDeck.get(index);
    }

    private void populateOrderedDeckWithCards(int numOfCardsInDeck){
        mOrderedDeck[0] = new Card(Card.Shape.NO_SHAPE, Card.Color.NO_COLOR,0,0,
                R.drawable.blank_0_0_0, R.drawable.blank_0_0_0);
        mOrderedDeck[1] = new Card(Card.Shape.CIRCLE, Card.Color.RED,1,0,
                R.drawable.circle_red_1_0, R.drawable.circle_red_1_0_selected);
        mOrderedDeck[2] = new Card(Card.Shape.CIRCLE, Card.Color.RED,2,0,
                R.drawable.circle_red_2_0, R.drawable.circle_red_2_0_selected);
        mOrderedDeck[3] = new Card(Card.Shape.CIRCLE, Card.Color.RED,3,0,
                R.drawable.circle_red_3_0, R.drawable.circle_red_3_0_selected);
        mOrderedDeck[4] = new Card(Card.Shape.CIRCLE, Card.Color.GREEN,1,0,
                R.drawable.circle_green_1_0, R.drawable.circle_green_1_0_selected);
        mOrderedDeck[5] = new Card(Card.Shape.CIRCLE, Card.Color.GREEN,2,0,
                R.drawable.circle_green_2_0, R.drawable.circle_green_2_0_selected);
        mOrderedDeck[6] = new Card(Card.Shape.CIRCLE, Card.Color.GREEN,3,0,
                R.drawable.circle_green_3_0, R.drawable.circle_green_3_0_selected);
        mOrderedDeck[7] = new Card(Card.Shape.CIRCLE, Card.Color.BLUE,1,0,
                R.drawable.circle_blue_1_0, R.drawable.circle_blue_1_0_selected);
        mOrderedDeck[8] = new Card(Card.Shape.CIRCLE, Card.Color.BLUE,2,0,
                R.drawable.circle_blue_2_0, R.drawable.circle_blue_2_0_selected);
        mOrderedDeck[9] = new Card(Card.Shape.CIRCLE, Card.Color.BLUE,3,0,
                R.drawable.circle_blue_3_0, R.drawable.circle_blue_3_0_selected);
        mOrderedDeck[10] = new Card(Card.Shape.SQUARE, Card.Color.RED, 1, 0,
                R.drawable.square_red_1_0, R.drawable.square_red_1_0_selected);
        mOrderedDeck[11] = new Card(Card.Shape.SQUARE, Card.Color.RED, 2, 0,
                R.drawable.square_red_2_0, R.drawable.square_red_2_0_selected);
        mOrderedDeck[12] = new Card(Card.Shape.SQUARE, Card.Color.RED, 3, 0,
                R.drawable.square_red_3_0, R.drawable.square_red_3_0_selected);
        mOrderedDeck[13] = new Card(Card.Shape.SQUARE, Card.Color.GREEN, 1, 0,
                R.drawable.square_green_1_0, R.drawable.square_green_1_0_selected);
        mOrderedDeck[14] = new Card(Card.Shape.SQUARE, Card.Color.GREEN, 2, 0,
                R.drawable.square_green_2_0, R.drawable.square_green_2_0_selected);
        mOrderedDeck[15] = new Card(Card.Shape.SQUARE, Card.Color.GREEN, 3, 0,
                R.drawable.square_green_3_0, R.drawable.square_green_3_0_selected);
        mOrderedDeck[16] = new Card(Card.Shape.SQUARE, Card.Color.BLUE, 1, 0,
                R.drawable.square_blue_1_0, R.drawable.square_blue_1_0_selected);
        mOrderedDeck[17] = new Card(Card.Shape.SQUARE, Card.Color.BLUE, 2, 0,
                R.drawable.square_blue_2_0, R.drawable.square_blue_2_0_selected);
        mOrderedDeck[18] = new Card(Card.Shape.SQUARE, Card.Color.BLUE, 3, 0,
                R.drawable.square_blue_3_0, R.drawable.square_blue_3_0_selected);
        mOrderedDeck[19] = new Card(Card.Shape.TRIANGLE, Card.Color.RED, 1, 0,
                R.drawable.triangle_red_1_0, R.drawable.triangle_red_1_0_selected);
        mOrderedDeck[20] = new Card(Card.Shape.TRIANGLE, Card.Color.RED, 2, 0,
                R.drawable.triangle_red_2_0, R.drawable.triangle_red_2_0_selected);
        mOrderedDeck[21] = new Card(Card.Shape.TRIANGLE, Card.Color.RED, 3, 0,
                R.drawable.triangle_red_3_0, R.drawable.triangle_red_3_0_selected);
        mOrderedDeck[22] = new Card(Card.Shape.TRIANGLE, Card.Color.GREEN, 1, 0,
                R.drawable.triangle_green_1_0, R.drawable.triangle_green_1_0_selected);
        mOrderedDeck[23] = new Card(Card.Shape.TRIANGLE, Card.Color.GREEN, 2, 0,
                R.drawable.triangle_green_2_0, R.drawable.triangle_green_2_0_selected);
        mOrderedDeck[24] = new Card(Card.Shape.TRIANGLE, Card.Color.GREEN, 3, 0,
                R.drawable.triangle_green_3_0, R.drawable.triangle_green_3_0_selected);
        mOrderedDeck[25] = new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 1, 0,
                R.drawable.triangle_blue_1_0, R.drawable.triangle_blue_1_0_selected);
        mOrderedDeck[26] = new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 2, 0,
                R.drawable.triangle_blue_2_0, R.drawable.triangle_blue_2_0_selected);
        mOrderedDeck[27] = new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 3, 0,
                R.drawable.triangle_blue_3_0, R.drawable.triangle_blue_3_0_selected);
        if(numOfCardsInDeck > 27) {
            mOrderedDeck[28] = new Card(Card.Shape.CIRCLE, Card.Color.RED, 1, 1,
                    R.drawable.circle_red_1_1, R.drawable.circle_red_1_1_selected);
            mOrderedDeck[29] = new Card(Card.Shape.CIRCLE, Card.Color.RED, 2, 1,
                    R.drawable.circle_red_2_1, R.drawable.circle_red_2_1_selected);
            mOrderedDeck[30] = new Card(Card.Shape.CIRCLE, Card.Color.RED, 3, 1,
                    R.drawable.circle_red_3_1, R.drawable.circle_red_3_1_selected);
            mOrderedDeck[31] = new Card(Card.Shape.CIRCLE, Card.Color.GREEN, 1, 1,
                    R.drawable.circle_green_1_1, R.drawable.circle_green_1_1_selected);
            mOrderedDeck[32] = new Card(Card.Shape.CIRCLE, Card.Color.GREEN, 2, 1,
                    R.drawable.circle_green_2_1, R.drawable.circle_green_2_1_selected);
            mOrderedDeck[33] = new Card(Card.Shape.CIRCLE, Card.Color.GREEN, 3, 1,
                    R.drawable.circle_green_3_1, R.drawable.circle_green_3_1_selected);
            mOrderedDeck[34] = new Card(Card.Shape.CIRCLE, Card.Color.BLUE, 1, 1,
                    R.drawable.circle_blue_1_1, R.drawable.circle_blue_1_1_selected);
            mOrderedDeck[35] = new Card(Card.Shape.CIRCLE, Card.Color.BLUE, 2, 1,
                    R.drawable.circle_blue_2_1, R.drawable.circle_blue_2_1_selected);
            mOrderedDeck[36] = new Card(Card.Shape.CIRCLE, Card.Color.BLUE, 3, 1,
                    R.drawable.circle_blue_3_1, R.drawable.circle_blue_3_1_selected);
            mOrderedDeck[37] = new Card(Card.Shape.SQUARE, Card.Color.RED, 1, 1,
                    R.drawable.square_red_1_1, R.drawable.square_red_1_1_selected);
            mOrderedDeck[38] = new Card(Card.Shape.SQUARE, Card.Color.RED, 2, 1,
                    R.drawable.square_red_2_1, R.drawable.square_red_2_1_selected);
            mOrderedDeck[39] = new Card(Card.Shape.SQUARE, Card.Color.RED, 3, 1,
                    R.drawable.square_red_3_1, R.drawable.square_red_3_1_selected);
            mOrderedDeck[40] = new Card(Card.Shape.SQUARE, Card.Color.GREEN, 1, 1,
                    R.drawable.square_green_1_1, R.drawable.square_green_1_1_selected);
            mOrderedDeck[41] = new Card(Card.Shape.SQUARE, Card.Color.GREEN, 2, 1,
                    R.drawable.square_green_2_1, R.drawable.square_green_2_1_selected);
            mOrderedDeck[42] = new Card(Card.Shape.SQUARE, Card.Color.GREEN, 3, 1,
                    R.drawable.square_green_3_1, R.drawable.square_green_3_1_selected);
            mOrderedDeck[43] = new Card(Card.Shape.SQUARE, Card.Color.BLUE, 1, 1,
                    R.drawable.square_blue_1_1, R.drawable.square_blue_1_1_selected);
            mOrderedDeck[44] = new Card(Card.Shape.SQUARE, Card.Color.BLUE, 2, 1,
                    R.drawable.square_blue_2_1, R.drawable.square_blue_2_1_selected);
            mOrderedDeck[45] = new Card(Card.Shape.SQUARE, Card.Color.BLUE, 3, 1,
                    R.drawable.square_blue_3_1, R.drawable.square_blue_3_1_selected);
            mOrderedDeck[46] = new Card(Card.Shape.TRIANGLE, Card.Color.RED, 1, 1,
                    R.drawable.triangle_red_1_1, R.drawable.triangle_red_1_1_selected);
            mOrderedDeck[47] = new Card(Card.Shape.TRIANGLE, Card.Color.RED, 2, 1,
                    R.drawable.triangle_red_2_1, R.drawable.triangle_red_2_1_selected);
            mOrderedDeck[48] = new Card(Card.Shape.TRIANGLE, Card.Color.RED, 3, 1,
                    R.drawable.triangle_red_3_1, R.drawable.triangle_red_3_1_selected);
            mOrderedDeck[49] = new Card(Card.Shape.TRIANGLE, Card.Color.GREEN, 1, 1,
                    R.drawable.triangle_green_1_1, R.drawable.triangle_green_1_1_selected);
            mOrderedDeck[50] = new Card(Card.Shape.TRIANGLE, Card.Color.GREEN, 2, 1,
                    R.drawable.triangle_green_2_1, R.drawable.triangle_green_2_1_selected);
            mOrderedDeck[51] = new Card(Card.Shape.TRIANGLE, Card.Color.GREEN, 3, 1,
                    R.drawable.triangle_green_3_1, R.drawable.triangle_green_3_1_selected);
            mOrderedDeck[52] = new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 1, 1,
                    R.drawable.triangle_blue_1_1, R.drawable.triangle_blue_1_1_selected);
            mOrderedDeck[53] = new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 2, 1,
                    R.drawable.triangle_blue_2_1, R.drawable.triangle_blue_2_1_selected);
            mOrderedDeck[54] = new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 3, 1,
                    R.drawable.triangle_blue_3_1, R.drawable.triangle_blue_3_1_selected);
        }
        if(numOfCardsInDeck > 54) {
            mOrderedDeck[55] = new Card(Card.Shape.CIRCLE, Card.Color.RED, 1, 2,
                    R.drawable.circle_red_1_2, R.drawable.circle_red_1_2_selected);
            mOrderedDeck[56] = new Card(Card.Shape.CIRCLE, Card.Color.RED, 2, 2,
                    R.drawable.circle_red_2_2, R.drawable.circle_red_2_2_selected);
            mOrderedDeck[57] = new Card(Card.Shape.CIRCLE, Card.Color.RED, 3, 2,
                    R.drawable.circle_red_3_2, R.drawable.circle_red_3_2_selected);
            mOrderedDeck[58] = new Card(Card.Shape.CIRCLE, Card.Color.GREEN, 1, 2,
                    R.drawable.circle_green_1_2, R.drawable.circle_green_1_2_selected);
            mOrderedDeck[59] = new Card(Card.Shape.CIRCLE, Card.Color.GREEN, 2, 2,
                    R.drawable.circle_green_2_2, R.drawable.circle_green_2_2_selected);
            mOrderedDeck[60] = new Card(Card.Shape.CIRCLE, Card.Color.GREEN, 3, 2,
                    R.drawable.circle_green_3_2, R.drawable.circle_green_3_2_selected);
            mOrderedDeck[61] = new Card(Card.Shape.CIRCLE, Card.Color.BLUE, 1, 2,
                    R.drawable.circle_blue_1_2, R.drawable.circle_blue_1_2_selected);
            mOrderedDeck[62] = new Card(Card.Shape.CIRCLE, Card.Color.BLUE, 2, 2,
                    R.drawable.circle_blue_2_2, R.drawable.circle_blue_2_2_selected);
            mOrderedDeck[63] = new Card(Card.Shape.CIRCLE, Card.Color.BLUE, 3, 2,
                    R.drawable.circle_blue_3_2, R.drawable.circle_blue_3_2_selected);
            mOrderedDeck[64] = new Card(Card.Shape.SQUARE, Card.Color.RED, 1, 2,
                    R.drawable.square_red_1_2, R.drawable.square_red_1_2_selected);
            mOrderedDeck[65] = new Card(Card.Shape.SQUARE, Card.Color.RED, 2, 2,
                    R.drawable.square_red_2_2, R.drawable.square_red_2_2_selected);
            mOrderedDeck[66] = new Card(Card.Shape.SQUARE, Card.Color.RED, 3, 2,
                    R.drawable.square_red_3_2, R.drawable.square_red_3_2_selected);
            mOrderedDeck[67] = new Card(Card.Shape.SQUARE, Card.Color.GREEN, 1, 2,
                    R.drawable.square_green_1_2, R.drawable.square_green_1_2_selected);
            mOrderedDeck[68] = new Card(Card.Shape.SQUARE, Card.Color.GREEN, 2, 2,
                    R.drawable.square_green_2_2, R.drawable.square_green_2_2_selected);
            mOrderedDeck[69] = new Card(Card.Shape.SQUARE, Card.Color.GREEN, 3, 2,
                    R.drawable.square_green_3_2, R.drawable.square_green_3_2_selected);
            mOrderedDeck[70] = new Card(Card.Shape.SQUARE, Card.Color.BLUE, 1, 2,
                    R.drawable.square_blue_1_2, R.drawable.square_blue_1_2_selected);
            mOrderedDeck[71] = new Card(Card.Shape.SQUARE, Card.Color.BLUE, 2, 2,
                    R.drawable.square_blue_2_2, R.drawable.square_blue_2_2_selected);
            mOrderedDeck[72] = new Card(Card.Shape.SQUARE, Card.Color.BLUE, 3, 2,
                    R.drawable.square_blue_3_2, R.drawable.square_blue_3_2_selected);
            mOrderedDeck[73] = new Card(Card.Shape.TRIANGLE, Card.Color.RED, 1, 2,
                    R.drawable.triangle_red_1_2, R.drawable.triangle_red_1_2_selected);
            mOrderedDeck[74] = new Card(Card.Shape.TRIANGLE, Card.Color.RED, 2, 2,
                    R.drawable.triangle_red_2_2, R.drawable.triangle_red_2_2_selected);
            mOrderedDeck[75] = new Card(Card.Shape.TRIANGLE, Card.Color.RED, 3, 2,
                    R.drawable.triangle_red_3_2, R.drawable.triangle_red_3_2_selected);
            mOrderedDeck[76] = new Card(Card.Shape.TRIANGLE, Card.Color.GREEN, 1, 2,
                    R.drawable.triangle_green_1_2, R.drawable.triangle_green_1_2_selected);
            mOrderedDeck[77] = new Card(Card.Shape.TRIANGLE, Card.Color.GREEN, 2, 2,
                    R.drawable.triangle_green_2_2, R.drawable.triangle_green_2_2_selected);
            mOrderedDeck[78] = new Card(Card.Shape.TRIANGLE, Card.Color.GREEN, 3, 2,
                    R.drawable.triangle_green_3_2, R.drawable.triangle_green_3_2_selected);
            mOrderedDeck[79] = new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 1, 2,
                    R.drawable.triangle_blue_1_2, R.drawable.triangle_blue_1_2_selected);
            mOrderedDeck[80] = new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 2, 2,
                    R.drawable.triangle_blue_2_2, R.drawable.triangle_blue_2_2_selected);
            mOrderedDeck[81] = new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 3, 2,
                    R.drawable.triangle_blue_3_2, R.drawable.triangle_blue_3_2_selected);
        }
    }
}

