package com.javafortesters.faq.nullpointerexception;

import com.javafortesters.tddexplored.Adder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Code to illustrate an FAQ of
 * why does my code throw a null pointer exception?
 */
@Ignore("Throws Null Pointer Exception")
public class WhyCodeThrowsNullPointerExceptionTest {

    Adder adder;

    @BeforeClass
    public static void setupAdder(){

        // create an Adder that we will use in the tests
        // using BeforeClass saves having to instantiate
        // it in every @Test
        Adder adder = new Adder();
    }

    @Test
    public void canAddTwoPlusTwo(){
        Assert.assertEquals(4, adder.add(2,2));
    }

    @Test
    public void canAddMinusNumber(){
        Assert.assertEquals(2, adder.add(4,-2));
    }
}
