package com.example.bruce.triples_1_5;

public class Card {

    private Shape mShape;
    private Color mColor;;
    private int mAlpha, mNumber, mImage, mSelectedImage;
    private boolean mIsSelected = false;

    public enum Shape{
        SQUARE, CIRCLE, TRIANGLE, NO_SHAPE
    }

    public enum Color{
        BLUE, RED, GREEN, NO_COLOR
    }

    public Card(Shape shape, Color color, int alpha, int number, int image, int selectedImage){
        mAlpha = alpha;
        mColor = color;
        mShape = shape;
        mNumber = number;
        mImage = image;
        mSelectedImage = selectedImage;
    };

    /********************************************
     * Getters
     ********************************************/

    public Shape getShape(){
        return mShape;
    }

    public Color getColor(){
        return mColor;
    }

    public int getAlpha(){
        return mAlpha;
    }

    public int getNumber() {
        return mNumber;
    }

    public int getImageID() {
        return mImage;
    }

    public int getSelectedImageID() {
        return mSelectedImage;
    }

    public boolean getIsSelected(){
        return mIsSelected;
    }

    /********************************************
    *End of Getters
    ********************************************/

    public void setIsSelected(boolean isSelected){
        mIsSelected = isSelected;
    }
}


