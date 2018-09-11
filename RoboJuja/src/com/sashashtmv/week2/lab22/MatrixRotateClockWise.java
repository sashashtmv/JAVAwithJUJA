package com.sashashtmv.week2.lab22;

import java.util.Arrays;

public class MatrixRotateClockWise {

    public static void main(String[] args) {
        int[][] base = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(rotateClockwise(base)));
    }

    public static int[][] rotateClockwise(int[][] arg) {
        try {
            int l = arg.length;
            int[][] result = new int[arg.length][arg[0].length];
            for (int i = 0; i < arg.length; i++) {
                for (int j = 0; j < arg[0].length; j++) {
                    result[j][i] = arg[l - 1][j];
                }
                l--;
            }
            return result;

        } catch (Exception e) {
            return null;
        }
    }
}
