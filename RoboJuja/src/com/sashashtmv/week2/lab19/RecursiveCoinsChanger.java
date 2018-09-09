package com.sashashtmv.week2.lab19;

// требует доработки

public class RecursiveCoinsChanger {
    private static final int[] coinNominals = new int[]{1, 2, 5, 10, 25, 50};

    public static void main(String[] args) {
        System.out.println(getCombinations(5));
        System.out.println(getCombinations(10));
        System.out.println(getCombinations(25));
        System.out.println(getCombinations(50));
        System.out.println(getCombinations(100));
    }

    private static int getCombinations(int cashValue) {
        return findCombination(coinNominals.length-1, cashValue,new int[coinNominals.length]);
    }

    private static int findCombination(int nominalIndex, int cashValue, int[] combinations) {
        int sum = 0;
        int variantsCount = 0;
        while (sum < cashValue){
            if(nominalIndex > 0){
                variantsCount += findCombination(nominalIndex - 1, cashValue, combinations);
                clearLowNominalsCount(nominalIndex, combinations);
            }
            combinations[nominalIndex]++;
            sum = calcSum(combinations);
            if(sum == cashValue){
                variantsCount++;
            }
        }
        return variantsCount;
    }

    private static int calcSum(int[] combinations) {
        int summ = 0;
        for(int i = 0; i < combinations.length; i ++){
            summ = coinNominals[i] * combinations[i];
            return summ;
        }
        return summ;
    }

    private static int clearLowNominalsCount(int nominalIndex, int[] combinations) {
        nominalIndex = 0;
        for(int i : combinations){
            if(i == 0)nominalIndex++;
        }
        return nominalIndex;
    }
}
