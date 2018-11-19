package com.example.bruce.triples_1_5;

import android.content.Context;
import java.util.ArrayList;

public class GameModel {
    private Deck deck;
    private ArrayList<Card> mCardOnBoard;
    private ArrayList<Integer> mSelectedCards;
    private long mStartTime;

    private int mScore, mTriplesRemaining, mLevel, mNumOfCardsInDeck;

    GameModel(int numOfCardsInDeck, int level){
        deck = new Deck(numOfCardsInDeck);
        mNumOfCardsInDeck = numOfCardsInDeck;
        mLevel = level;
        mCardOnBoard = new ArrayList<>();
        mSelectedCards = new ArrayList<>();
        mStartTime = System.currentTimeMillis();
    }

/*************************************************
 * Getters and Setters
 *************************************************/

        public Card getCardOnBoard(int index){
            return mCardOnBoard.get(index);
        }

        public int getNumOfCardsSelected(){
            return mSelectedCards.size();
        }

        public int getSelectedCardIndex(int index){
            return mSelectedCards.get(index);
        }

        public void setStartTime(){
            mStartTime = 0;
        }

        public void setTriplesRemaining(){
            mTriplesRemaining --;
        }

        public int getNumOfCardsInDeck(){
            return mNumOfCardsInDeck;
        }

        public int getLevel(){
            return mLevel;
        }

        public int getScore() {
            return mScore;
        }

        public void setScore(int score) {
            mScore = score;
        }
    /*************************************************
     * Methods that place cards to board
     *************************************************/
    protected void addCardToBoard(){
        mCardOnBoard.add(deck.getTopCard());
    }

    protected void replaceCardOnBoard(int index){
        mCardOnBoard.set(index, deck.getTopCard());
    }

    /*************************************************
     * Methods that keep track of selected cards
     *************************************************/

    protected void addSelectedCardIndex(int cardIndex){
        mSelectedCards.add(cardIndex);
    }

    protected void removeSelectedCardIndex(int cardIndex){
        mSelectedCards.remove(new Integer(cardIndex));
    }

    protected void resetSelectedCardIndices(){
        int length = mSelectedCards.size();
        for(int i = length; i > 0; i--){
            mSelectedCards.remove(i - 1);
        }
    }

    /*************************************************
     * Scoring
     *************************************************/
    protected int updateScore() {
        long time = (mStartTime - System.currentTimeMillis());
        setScore(getScore() + ((int)time / 100));;
        return mScore;
    }

    /*************************************************
     * Methods that determine play
     *************************************************/

    protected boolean isTriple(int firstCard, int secondCard, int thirdCard){
        int shapeIsSame, colorIsSame, numberIsSame, alphaIsSame, isSame;

        shapeIsSame = (mCardOnBoard.get(firstCard).getShape().ordinal() + mCardOnBoard.get(secondCard).getShape().ordinal() + mCardOnBoard.get(thirdCard).getShape().ordinal()) % 3;

        colorIsSame = (mCardOnBoard.get(firstCard).getColor().ordinal() + mCardOnBoard.get(secondCard).getColor().ordinal() + mCardOnBoard.get(thirdCard).getColor().ordinal()) % 3;

        numberIsSame = (mCardOnBoard.get(firstCard).getNumber() + mCardOnBoard.get(secondCard).getNumber() + mCardOnBoard.get(thirdCard).getNumber()) % 3;

        alphaIsSame = (mCardOnBoard.get(firstCard).getAlpha() + mCardOnBoard.get(secondCard).getAlpha() + mCardOnBoard.get(thirdCard).getAlpha()) % 3;

        isSame = shapeIsSame + colorIsSame + numberIsSame + alphaIsSame;

        return (isSame == 0) ? true : false;
    }

    protected boolean playIsPossible(){
        boolean isPossible = false;
        int length = mCardOnBoard.size();

            for (int f = 0; f < length; f++) {
                for (int s = 0; s < length; s++) {
                    for (int t = 0; t < length; t++) {
                        if(isTriple(f, s, t)){
                            isPossible = true;
                        }
                    }
                }
            }
        return isPossible;
    }

    protected String getGameOverMessage(Context context){
        String message = context.getString(R.string.game_over);
        if(mTriplesRemaining > 0)
            message = "      " + message + "\n" + context.getString(R.string.play_not_possible);
        return message;
    }
}




