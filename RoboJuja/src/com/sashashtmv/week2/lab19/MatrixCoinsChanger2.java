package com.sashashtmv.week2.lab19;

public class MatrixCoinsChanger2 {
    private static final int[] coinNominals = new int[]{1, 2, 5, 10, 25, 50, 100};


    public static int getCombinations(int sum) {

        if (sum <= 0) return 0;
        int num = coinNominals.length;
        int cash[][] = new int[sum + 1][num];
        int variantsWithCurrentNominalCount, previousNominalsVariantCount;
        for (int i = 0; i < num ; i++) {
            cash[0][i] = 1;
        }
        for (int i = 1; i < sum + 1 ; i++) {
            for (int j = 0; j < num; j++) {
                int currentSum = i - coinNominals[j];
                if(currentSum >= 0){
                    variantsWithCurrentNominalCount = cash[currentSum][j];
                }else variantsWithCurrentNominalCount = 0;

                if(j >= 1){
                    previousNominalsVariantCount = cash[i][j - 1];
                }else previousNominalsVariantCount = 0;

                cash[i][j] = variantsWithCurrentNominalCount + previousNominalsVariantCount;
            }

        }
        return cash[sum][num - 1];
    }
}
