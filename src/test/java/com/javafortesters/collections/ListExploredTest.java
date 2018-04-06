package com.javafortesters.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ListExploredTest {

    @Test
    public void canExploreList(){

        //List<String> strings= new ArrayList<>();
        List<String> strings= new Vector<>();

        Assert.assertEquals(0,strings.size());
        strings.add("Test");
        Assert.assertEquals(1,strings.size());


    }

    @Test
    public void canFillAList(){

        List<String>strings = new ArrayList<>();

        fillList(strings,40);

        Assert.assertEquals(40, strings.size());
        Assert.assertEquals("String0", strings.get(0));
        Assert.assertEquals("String39", strings.get(39));

        strings.clear();
        Assert.assertEquals(0, strings.size());


    }

    private void fillList(Collection<String> strings, int howMany) {
        for(int x=0; x<howMany; x++){
            strings.add("String"+x);
        }
    }
}
