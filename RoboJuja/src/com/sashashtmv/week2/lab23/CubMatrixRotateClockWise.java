package com.sashashtmv.week2.lab23;

import java.util.Arrays;

public class CubMatrixRotateClockWise {
    public static void main(String[] args) {
        int[][][] base = {{{1, 2}, {3, 4}}, {{5, 6},{10, 11}, {7, 8, 9}} };
        int [][][] base1 = {{{1}}};
        System.out.println(Arrays.deepToString(rotateClockwise(base)));
    }

    public static int[][][] rotateClockwise(int[][][] arg) {
        try {
            int[][][] result = new int[arg.length][arg[0].length][arg[0][0].length];
            if (arg.length==1 && arg[0].length == 1 && arg[0][0].length == 1)return arg;
            if(arg.length == arg[0].length && arg.length == arg[1][1].length&& arg.length == arg[1].length) {

                for (int i = 0; i < arg.length; i++) {
                    for (int j = 0; j < arg.length; j++) {
                        for (int k = 0; k < arg.length; k++)
                            result[j][i][k] = arg[k][j][i];
                    }
                }
                return result;
            }
            else return null;

        } catch (Exception e) {
            return null;
        }
    }
}
