package com.sashashtmv.week2.lab19;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatrixCoinsChangerTest {

    @Test
    public void Test(){
        assertEquals(4, MatrixCoinsChanger.getCombinations(5));
        assertEquals(11, MatrixCoinsChanger.getCombinations(10));
        assertEquals(65, MatrixCoinsChanger.getCombinations(25));
        assertEquals(407, MatrixCoinsChanger.getCombinations(50));
        assertEquals(3953, MatrixCoinsChanger.getCombinations(100));
        assertEquals(94800, MatrixCoinsChanger.getCombinations(225));
        assertEquals(18199, MatrixCoinsChanger.getCombinations(150));
        assertEquals(-1768803393, MatrixCoinsChanger.getCombinations(10000));

    }
}
