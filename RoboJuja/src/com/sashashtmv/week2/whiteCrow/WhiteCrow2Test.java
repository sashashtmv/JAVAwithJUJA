package com.sashashtmv.week2.whiteCrow;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


import static org.junit.Assert.*;
    @RunWith(Parameterized.class)
public class WhiteCrow2Test {
        // аргументы для параметров, используемых в методе для тестов
    int[] mass;
    int res;
        // конструктор обязателен для передачи аргументов в аннотацию @RunWith
        public WhiteCrow2Test(int[] mass, int res) {
            this.mass = mass;
            this.res = res;
        }

        @Rule
    public TestRule timeout = new Timeout(100);

    @Parameterized.Parameters
    public static Collection collection(){
        return Arrays.asList(new Object[][]{{new int[]{1,1},-1},{new int[]{1,2},0},{new int[]{1,1,2,2,3,3,4},6}});
    }
    //@Test(expected = ArithmeticException.class)
    @Test
    public void find() {
        WhiteCrow2 tests = new WhiteCrow2();
        //int[] arrays = {1, 2, 1, 2, 3, 3, 4, 4, 5, 6};
        int actual = tests.find(mass);
        //int res = 8;
        assertEquals(res, actual);
    }
}