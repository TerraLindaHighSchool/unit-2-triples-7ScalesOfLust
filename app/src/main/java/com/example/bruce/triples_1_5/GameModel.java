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
        mLevel = level;
        mNumOfCardsInDeck = numOfCardsInDeck;
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

    /*************************************************
     * Methods that place cards to board
     *************************************************/
    protected void addCardToBoard(){
        mCardOnBoard.add(0, deck.getTopCard());
    }

    protected void replaceCardOnBoard(int index){
        // to be implemented
    }

    /*************************************************
     * Methods that keep track of selected cards
     *************************************************/

    protected void addSelectedCardIndex(int cardIndex){
        // to be implemented
    }

    protected void removeSelectedCardIndex(int cardIndex){
        // to be implemented
    }

    protected void resetSelectedCardIndices(){
        // to be implemented
    }

    /*************************************************
     * Scoring
     *************************************************/
    protected int updateScore() {
        // to be implemented
        return -1; // temporary placeholder until implementation
    }

    /*************************************************
     * Methods that determine play
     *************************************************/

    protected boolean isTriple(int firstCard, int secondCard, int thirdCard){
        // to be implemented
        return true; // temporary placeholder until implementation
    }

    protected boolean playIsPossible(){
        // to be implemented
        return true;  // temporary placeholder until implementation
    }

    protected String getGameOverMessage(Context context){
        String message = context.getString(R.string.game_over);
        if(mTriplesRemaining > 0)
            message = "      " + message + "\n" + context.getString(R.string.play_not_possible);
        return message;
    }
}




