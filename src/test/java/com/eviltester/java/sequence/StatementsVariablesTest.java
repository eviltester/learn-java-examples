package com.eviltester.java.sequence;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StatementsVariablesTest {

    public static final String aField = "A Field Value";

    @Test
    public void exampleOfStatementsAndVariables(){

        int aMethodVariable = 1;

        aMethodVariable = aMethodVariable + 1;

        assertEquals("A Field Value2",
                     aField + aMethodVariable);
        assertEquals(3, aMethodVariable + 1);

    }

}


// a field is a variable at the class level
// public means it is accessible outside the class
// static means it is accessible even when the class is not instantiated as an Object
// demonstrate accessors, class creation, static access, method calls in scratchpad
// demonstrate difference between instantiation and assignment
// + += -= *=
