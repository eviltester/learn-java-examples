package com.javafortesters.scratchpad;

import org.junit.Test;

/**
 * This is where I do adhoc demo stuff
 */
public class ScratchpadTest {


    @Test
    public void doSomething(){
        int anInt = 100;
        long aLong = 200;

        anInt = (int) Long.MAX_VALUE;
        System.out.println("i " + anInt + " l " + Long.MAX_VALUE);

        String[] anArray = {};
    }


}
