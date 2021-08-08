package com.eviltester.java.iteration;

import org.junit.Test;

public class IterationTest {

    @Test
    public void whileLoopExample(){
        int count=0;
        while(count<10){
            System.out.println("While " + count);
            count++;
        }

    }

    @Test
    public void forLoopExample(){
        for(int count = 4; count<10; count++){
            System.out.println("For " + count);
        }
    }

    @Test
    public void doWhileLoopExample(){
        int count=0;
        do {
            System.out.println("Do While " + count);
            count++;
        }while(count<10);
    }

    // syntax differences
    // what if miss out count++
    // other incrementing count+=2 etc.
    // for using existing variable
    // for without increment?
    // for without condition?
    // while == 0 to, do while == 1 to
    // explain for isn't really a for (initialise;check;next) statements with , e.g. count++, count+=2
    // break to exit loop (ugh with label)
}
