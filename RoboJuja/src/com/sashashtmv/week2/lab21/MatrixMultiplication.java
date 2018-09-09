package com.sashashtmv.week2.lab21;

import java.util.Arrays;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] one = {{1, 2}, {7, 8}, {3, 4}};
        int[][] two = {{3, 4, 5, 6}, {9, 0, 1, 2}};
        int[][] three = mul(one, two);
        System.out.println(Arrays.deepToString(three));
    }

    public static int[][] mul(int[][] fst, int[][] snd) {
        int[][] matrixMultiplication = new int[fst.length][snd[0].length];
        int sum = 0;

        for (int i = 0; i < fst.length; i++) {
            for (int k = 0; k < snd[0].length; k++) {
                for (int j = 0; j < fst[0].length; j++) {
                    sum += fst[i][j] * snd[j][k];
                }
                matrixMultiplication[i][k] = sum;
                sum = 0;
            }
        }

        /*BODY*/

        return matrixMultiplication;
    }

}
