package com.javafortesters.selection;

import org.junit.Test;

public class SelectionTest {

    @Test
    public void anIf(){
        int a = 2, b = 3, c = 1;

        if((a+c)== b){
            System.out.println("equal");
        }else{
            System.out.println("not equal");
        }
    }

    // note the new instantiation
    // nested ifs
    // ifs without braces
    // boolean operators on ints and strings etc.

    @Test
    public void aSwitch(){

        int a=10;

        switch(a){
            case 1:
                System.out.println("a == 1");
                break;
            case 2:
                System.out.println("a == 2");
                break;
            case 3:
                System.out.println("a == 3");
                break;
            default:
                System.out.println("a == 4");
                break;
        }
    }

    // switch on strings requires 1.7
    // if you remove break it falls through
    // no default - no match

}
