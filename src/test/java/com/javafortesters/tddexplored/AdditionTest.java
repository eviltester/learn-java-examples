package com.javafortesters.tddexplored;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Alan on 05/04/2017.
 */
public class AdditionTest {

    // 0+0 == 0
    // 100+1 == 101
    // -10 +4 == -6
    // -15 + 20 == 5

    @Test
    public void canAddTwoIntegers(){

        Assert.assertEquals(0, new Adder().add(0,0));
        Assert.assertEquals(101, new Adder().add(100,1));

        Assert.assertEquals(-6, new Adder().add(-10,4));
        Assert.assertEquals(5, new Adder().add(-15,20));

        Assert.assertEquals(-6, new Adder().add(4,-10));

        // Thinking through the code from a Testing perspective I can see
        // that the code does not handle values bigger than maximum int values
        // is that correct or not?
        // need to return a long for that to be the case
        //2147483647 +1 == 2147483648
        //Assert.assertTrue(2147483648L > new Adder().add(4,-10));
        //System.out.println(Integer.MAX_VALUE);
    }

}
