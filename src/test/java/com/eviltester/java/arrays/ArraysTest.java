package com.eviltester.java.arrays;

import org.junit.Assert;
import org.junit.Test;

public class ArraysTest {

    private class Snake{
        int length=0;
    }



    private class Board{

        private Snake[] snakes;

        Board(int numberOfSnakes){
            this.snakes = new Snake[numberOfSnakes];
        }
    }

    @Test
    public void whenICreateABoardTheArrayIsCreated(){

        Board withSixSnakes = new Board(6);
        Assert.assertEquals(6, withSixSnakes.snakes.length);
    }

    @Test
    public void butThereAreNoSnakesOnTheBoard(){

        Board withSixSnakes = new Board(3);
        Assert.assertEquals(3, withSixSnakes.snakes.length);
        Assert.assertNull(withSixSnakes.snakes[0]);
        Assert.assertNull(withSixSnakes.snakes[1]);
        Assert.assertNull(withSixSnakes.snakes[2]);

    }

}
