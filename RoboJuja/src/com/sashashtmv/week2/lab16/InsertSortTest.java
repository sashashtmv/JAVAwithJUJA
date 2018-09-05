package com.sashashtmv.week2.lab16;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class InsertSortTest {

    int[] mass;
    int[] expert;

    public InsertSortTest(int[] mass, int [] expert) {
        this.mass = mass;
        this.expert = expert;
    }

//    @Rule
//    public TestRule timeout = new Timeout(1000);

    @Parameterized.Parameters
    public static Collection collection() {
        return Arrays.asList(new Object[][]{{new int[]{0, 1, 6, 5, 4, 2, 3}, new int[]{0, 1, 2, 3, 4, 5, 6}}, {new int[]{1, 1}, new int[]{1, 1}},
                {new int[]{2, 1, 3}, new int[]{1, 2, 3}}});
    }

    @Test
    public void sort() {
        InsertSort selectSort = new InsertSort();
        int[] actual = selectSort.sort(mass);
        assertArrayEquals(expert, actual);

    }
}