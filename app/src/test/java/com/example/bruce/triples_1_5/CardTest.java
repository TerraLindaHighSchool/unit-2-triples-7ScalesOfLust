package com.example.bruce.triples_1_5;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void getShape() {
        Card[] card = {
                new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 1, 2, 0, 0),
                new Card(Card.Shape.CIRCLE, Card.Color.BLUE, 1, 2, 0, 0),
                new Card(Card.Shape.SQUARE,  Card.Color.BLUE, 1, 2, 0, 0),
                new Card(Card.Shape.NO_SHAPE, Card.Color.BLUE, 1, 2, 0, 0)
        };
        Card.Shape[] expected = {
                Card.Shape.TRIANGLE,
                Card.Shape.CIRCLE,
                Card.Shape.SQUARE,
                Card.Shape.NO_SHAPE
        };

        Card.Shape[] actual= new Card.Shape[4];

        for(int i = 0; i < 4; i++)
            actual[i] = card[i].getShape();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getColor() {
        Card[] card = {
                new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 1, 2, 0, 0),
                new Card(Card.Shape.CIRCLE, Card.Color.RED, 1, 2, 0, 0),
                new Card(Card.Shape.SQUARE, Card.Color.GREEN, 1, 2, 0, 0),
                new Card(Card.Shape.NO_SHAPE, Card.Color.NO_COLOR, 1, 2, 0, 0)
        };
        Card.Color[] expected = {
                Card.Color.BLUE,
                Card.Color.RED,
                Card.Color.GREEN,
                Card.Color.NO_COLOR
        };
        Card.Color[] actual= new Card.Color[4];
        for(int i = 0; i < 4; i++)
            actual[i] = card[i].getColor();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getAlpha() {
        Card[] card = {
                new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 0, 2, 0, 0),
                new Card(Card.Shape.CIRCLE, Card.Color.RED, 1, 2, 0, 0),
                new Card(Card.Shape.SQUARE, Card.Color.GREEN, 2, 2, 0, 0)
        };
        int[] expected = {0, 1, 2};
        int[] actual= new int[3];
        for(int i = 0; i < 3; i++)
            actual[i] = card[i].getAlpha();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getNumber() {
        Card[] card = {
                new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 1, 1, 0, 0),
                new Card(Card.Shape.CIRCLE, Card.Color.RED, 2, 2, 0, 0),
                new Card(Card.Shape.SQUARE, Card.Color.GREEN, 0, 3, 0, 0)
        };
        int[] expected = {1, 2, 3};
        int[] actual= new int[3];
        for(int i = 0; i < 3; i++)
            actual[i] = card[i].getNumber();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getIsSelected() {
        Card card = new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 1, 2, 0, 0);
        boolean expected = false;
        boolean actual=  card.getIsSelected();
        assertTrue(expected == actual);
    }

    @Test
    public void setIsSelected() {
        Card card = new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 1, 2, 0, 0);
        card.setIsSelected(true);
        boolean actual=  card.getIsSelected();
        assertTrue(actual == true);
    }

    @Test
    public void getImageID() {
        Card[] card = {
                new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 1, 1, R.drawable.triangle_blue_1_1, 0),
                new Card(Card.Shape.CIRCLE, Card.Color.RED, 2, 2, R.drawable.circle_red_2_2, 0),
                new Card(Card.Shape.SQUARE, Card.Color.GREEN, 0, 3, R.drawable.square_green_3_0, 0)
        };
        int[] expected = { R.drawable.triangle_blue_1_1, R.drawable.circle_red_2_2, R.drawable.square_green_3_0};
        int[] actual= new int[3];
        for(int i = 0; i < 3; i++)
            actual[i] = card[i].getImageID();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getSelectedImageID() {
            Card[] card = {
                    new Card(Card.Shape.TRIANGLE, Card.Color.BLUE, 1, 1, R.drawable.triangle_blue_1_1, R.drawable.triangle_blue_1_1_selected),
                    new Card(Card.Shape.CIRCLE, Card.Color.RED, 2, 2, R.drawable.circle_red_2_2, R.drawable.circle_red_2_2_selected),
                    new Card(Card.Shape.SQUARE, Card.Color.GREEN, 0, 3, R.drawable.square_green_3_0, R.drawable.square_green_3_0_selected)
            };
            int[] expected = { R.drawable.triangle_blue_1_1_selected, R.drawable.circle_red_2_2_selected, R.drawable.square_green_3_0_selected};
            int[] actual = new int[3];
            for(int i = 0; i < 3; i++)
                actual[i] = card[i].getSelectedImageID();

            assertArrayEquals(expected, actual);
    }

}