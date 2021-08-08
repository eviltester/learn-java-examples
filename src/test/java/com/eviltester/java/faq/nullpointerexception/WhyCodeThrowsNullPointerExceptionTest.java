package com.eviltester.java.faq.nullpointerexception;

import com.eviltester.java.tddexplored.Adder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Code to illustrate an FAQ of
 * why does my code throw a null pointer exception?
 */
public class WhyCodeThrowsNullPointerExceptionTest {

    Adder adder;

    @BeforeClass
    public static void setupAdder(){

        // create an Adder that we will use in the tests
        // using BeforeClass saves having to instantiate
        // it in every @Test
        // this creates a new 'adder' variable local to this method
        // it does not assign a variable to the field `adder`
        Adder adder = new Adder();
    }

    // the tests are using the field `adder` which has not been initialised
    // so this throws a null pointer
    @Test(expected = NullPointerException.class)
    public void canAddTwoPlusTwo(){
        Assert.assertEquals(4, adder.add(2,2));
    }

    @Test(expected = NullPointerException.class)
    public void canAddMinusNumber(){
        Assert.assertEquals(2, adder.add(4,-2));
    }

    @Test(expected = NullPointerException.class)
    public void adderAssignedNullHenceNullPointer(){
        Adder adder=null;
        // there might be a lot more code between and we didn't notice
        Assert.assertEquals(2, adder.add(4,-2));
    }

    @Test(expected = NullPointerException.class)
    public void assignedInConditionalBlockSoNotAlways(){
        Adder adder=null;
        int age=17;

        // this type of code can be a source of intermittency
        // if the 'else' condition is not handled adder is not assigned
        if(age>17){
            adder = new Adder();
        }

        Assert.assertEquals(2, adder.add(4,-2));
    }
}
