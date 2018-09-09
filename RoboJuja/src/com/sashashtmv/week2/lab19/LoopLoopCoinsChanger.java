package com.sashashtmv.week2.lab19;

public class LoopLoopCoinsChanger {
    private static final int[] coinNominals = new int[]{1, 2, 5, 10, 25, 50, 100};

    public static void main(String[] args) {
        System.out.println(getCombinations(5));
        System.out.println(getCombinations(10));
        System.out.println(getCombinations(25));
        System.out.println(getCombinations(50));
        System.out.println(getCombinations(100));
    }

    private static int getCombinations(int amountForExchange) {
        long count = 0;
        int countVariant = 0;
        int stack = 0;
        if(amountForExchange <= 0) return 0;
        for (int i100 = 0; i100 <= amountForExchange/100 ; i100++) {
            for (int i50 = 0; i50 <= amountForExchange/50 ; i50++) {
                for (int i25 = 0; i25 <= amountForExchange/25 ; i25++) {
                    for (int i10 = 0; i10 <= amountForExchange/10 ; i10++) {
                        for (int i5 = 0; i5 <= amountForExchange/5 ; i5++) {
                            for (int i2 = 0; i2 <= amountForExchange/2 ; i2++) {
                                for (int i1 = 0; i1 <= amountForExchange ; i1++) {
                                    stack = (i100*100 + i50*50 + i25*25 + i10*10 + i5*5 + i2*2 + i1*1);
                                    count++;
                                    if(stack == amountForExchange){
                                        countVariant++;
                                    }

                                }

                            }

                        }

                    }

                }

            }

        }
        System.out.println("Общее количество операций алгоритма: " + count);
        return countVariant;

    }
}
