package com.example.bruce.triples_1_5;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    private final int MAX_IMAGES = 18;
    private ImageView[] mImageArray = new ImageView[MAX_IMAGES];
    private TextView mTextCardsRemaining, mTextScore, mTextHighScore;
    private Button mButtonQuit;
    private GameModel game;
    private Animation wobble, slideDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Get level from UI and assign number of cards on board and in deck
        int level = getIntent().getIntExtra("Level",1);
        int numCardsOnBoard = 12;  //default cards on board
        int numCardsInDeck = 81;  //default cards in deck
        switch(level){
            case 1: numCardsOnBoard = 15;
                numCardsInDeck = 27;
                break;
            case 2: numCardsOnBoard = 12;
                numCardsInDeck = 27;
                break;
            case 3: numCardsOnBoard = 18;
                numCardsInDeck = 54;
                break;
            case 4: numCardsOnBoard = 15;
                numCardsInDeck = 81;
                break;
            case 5: numCardsOnBoard = 12;
                numCardsInDeck = 81;
                break;
        }

        // set board features
        mTextCardsRemaining = findViewById(R.id.TextView_CardsRemaining);
        mTextScore = findViewById(R.id.TextView_Score);
        mTextHighScore = findViewById(R.id.TextView_High_Score);
        mButtonQuit = findViewById(R.id.Button_Quit);
        setImageViewArray();
        setAnimationsAndListener();
        game = new GameModel(numCardsInDeck, level);
        beginGame(numCardsOnBoard);
        listenForUI(numCardsOnBoard);
    }

    /*************************************************
     * Begin Game and deals cards onto board
     *************************************************/
    private void beginGame(int numCardsOnBoard){
        mButtonQuit.setText(R.string.quit);
        updateAndDeclareScores(true);
        game.setStartTime();
        for(int i = numCardsOnBoard; i < MAX_IMAGES; i++)
            mImageArray[i].setVisibility(View.GONE);
        for(int imageIndex = 0; imageIndex < numCardsOnBoard; imageIndex++){
            game.addCardToBoard();
            mImageArray[imageIndex].setImageResource(game.getCardOnBoard(imageIndex).getImageID());
        }
        if(!game.playIsPossible()) gameOver();
        updateCardsRemaining();
    }

    /*************************************************
     * Begin Round Listeners
     *************************************************/
    protected void listenForUI(int numCardsOnBoard) {
        for (int imageIndex = 0; imageIndex < numCardsOnBoard; imageIndex++) {
            final int index = imageIndex;
            mImageArray[imageIndex].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Card cardSelected = game.getCardOnBoard(index);
                    // Card already selected, so this unselects it ******************
                    if (cardSelected.getIsSelected()) {
                        mImageArray[index].setImageResource(cardSelected.getImageID());
                        cardSelected.setIsSelected(false);
                        game.removeSelectedCardIndex(index);
                        // Card being selected  *******************************************
                    } else {
                        mImageArray[index].setImageResource(cardSelected.getSelectedImageID());
                        cardSelected.setIsSelected(true);
                        game.addSelectedCardIndex(index);
                    }
                    // Checks to see if 3 cards have been selected **************************
                    if (game.getNumOfCardsSelected() == 3)
                        endRound();
                }
            });
            mButtonQuit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

    private void setAnimationsAndListener(){
        wobble = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.wobble);
        slideDown = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_down);
        slideDown.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation anim)
            {
            }
            public void onAnimationRepeat(Animation anim)
            {
            }
            public void onAnimationEnd(Animation anim)
            {
                int index;
                for(int i = 3; i > 0; i--){
                    index = game.getSelectedCardIndex(i - 1);
                    mImageArray[index].setImageResource(game.getCardOnBoard(index).getImageID());
                    game.setStartTime();
                }
                game.resetSelectedCardIndices();
                if(!game.playIsPossible()) gameOver();
            }
        });
    }

    /*************************************************
     * If triple, begins next round
     *************************************************/
    private void endRound(){
        int index;
        if (game.isTriple(game.getSelectedCardIndex(0), game.getSelectedCardIndex(1),
                game.getSelectedCardIndex(2))) {
            for(int i = 3; i > 0; i--){
                index = game.getSelectedCardIndex(i - 1);
                if(game.getNumOfCardsInDeck() == 0) mImageArray[index].setVisibility(View.GONE);
                game.replaceCardOnBoard(index);
            }
            for(int i = 3; i > 0; i--){
                index = game.getSelectedCardIndex(i - 1);
                mImageArray[index].startAnimation(slideDown);
            }
            game.setTriplesRemaining();
            updateCardsRemaining();
            updateAndDeclareScores(false);
        }
        else {
            for(int i = 3; i > 0; i--){
                index = game.getSelectedCardIndex(i - 1);
                mImageArray[index].startAnimation(wobble);
                mImageArray[index].setImageResource(game.getCardOnBoard(index).getImageID());
            }
            game.resetSelectedCardIndices();
        }
    }

    /*************************************************
     * Displays end game messages
     *************************************************/
    private void gameOver(){
        String message = game.getGameOverMessage(getApplicationContext());
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    /*************************************************
     * Game Updates
     *************************************************/

    protected void updateAndDeclareScores(boolean isBegin) {
        SharedPreferences prefs = getSharedPreferences("Triples", MODE_PRIVATE);
        SharedPreferences.Editor editor;editor = prefs.edit();
        int highScore = prefs.getInt("High Score", 0);
        int currentScore = 0;
        if(!isBegin) currentScore = game.updateScore();
        String score = "Score: " + currentScore;
        mTextScore.setText(score);
        String highScoreStr = "Current High Score: " + highScore;
        if (currentScore > highScore) {
            editor.putInt("High Score", currentScore);
            editor.apply();
            highScoreStr = "Current High Score: " + currentScore;
        }
        mTextHighScore.setText(highScoreStr);
    }

    protected void updateCardsRemaining(){
        String cardsRemaining = "Cards in Deck: " + game.getNumOfCardsInDeck();
        mTextCardsRemaining.setText(cardsRemaining);
    }

    /*************************************************
     * Sets ImageView ID to Array of ImageViews
     *************************************************/

    private void setImageViewArray(){
        mImageArray[0] = findViewById(R.id.imageView_0_0);
        mImageArray[1] = findViewById(R.id.imageView_0_1);
        mImageArray[2] = findViewById(R.id.imageView_0_2);
        mImageArray[3] = findViewById(R.id.imageView_1_0);
        mImageArray[4] = findViewById(R.id.imageView_1_1);
        mImageArray[5] = findViewById(R.id.imageView_1_2);
        mImageArray[6] = findViewById(R.id.imageView_2_0);
        mImageArray[7] = findViewById(R.id.imageView_2_1);
        mImageArray[8] = findViewById(R.id.imageView_2_2);
        mImageArray[9] = findViewById(R.id.imageView_3_0);
        mImageArray[10] = findViewById(R.id.imageView_3_1);
        mImageArray[11] = findViewById(R.id.imageView_3_2);
        mImageArray[12] = findViewById(R.id.imageView_4_0);
        mImageArray[13] = findViewById(R.id.imageView_4_1);
        mImageArray[14] = findViewById(R.id.imageView_4_2);
        mImageArray[15] = findViewById(R.id.imageView_5_0);
        mImageArray[16] = findViewById(R.id.imageView_5_1);
        mImageArray[17] = findViewById(R.id.imageView_5_2);
    }
}
