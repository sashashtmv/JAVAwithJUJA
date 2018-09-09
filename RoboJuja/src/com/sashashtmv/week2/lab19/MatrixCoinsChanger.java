package com.sashashtmv.week2.lab19;

// Пробуем рефакторить код

public class MatrixCoinsChanger {

    private static final int[] coinNominals = new int[]{1, 2, 5, 10, 25, 50};

//    public static void main(String[] args) {
//        System.out.println(getCombinations(5));
//    }
    public static int getCombinations(int sum) {

        if (sum <= 0) return 0;
        int nominalsCount = coinNominals.length;
        int combinations[][] = new int[sum + 1][nominalsCount];
        for (int i = 0; i < nominalsCount ; i++) {
            combinations[0][i] = 1;
        }
        for (int number = 1; number <= sum; number++) {
            for (int nominalsIndex = 0; nominalsIndex < nominalsCount; nominalsIndex++) {
                int current = 0;
                if(coinNominals[nominalsIndex] <= number){
                    int rest = number - coinNominals[nominalsIndex];
                    current = combinations[rest][nominalsIndex];
                }

                int previous = 0;// nominals varaints count
                if(nominalsIndex >= 1){
                    previous = combinations[number][nominalsIndex - 1];
                }
            // разменять N-ку монетками a0, a1, a2, a5, ... ,an =
                // количество комбинаций как разменять N-ку монетками a0, a1, a2, a5, ... ,an-1
                    // при условии, что n > 0
                    // +
                // количество комбинаций, как разменять N-ку - текуший номинал an(10)
                    // при условии, что разницы >= 0
                combinations[number][nominalsIndex] = current + previous;
                //debug(combinations, coinNominals);
            }

        }
        return combinations[sum][nominalsCount - 1];
    }

    private static void debug(int[][] cash, int [] coinNominals) {
        String result = "\t\t";
        for (int x = 0; x < coinNominals.length; x++) {
            result += coinNominals[x] + "\t";
        }
        result += "\n";
        for (int y = 0; y < cash.length; y++) {
            result += "[" + y + "] \t";
            for (int x = 0; x < coinNominals.length; x++) {
                result += cash[y][x] + "\t";
            }
            result += "\n";
        }
        System.out.println(result);
    }
}
