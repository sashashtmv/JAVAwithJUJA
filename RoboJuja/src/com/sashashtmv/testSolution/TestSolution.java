package com.sashashtmv.testSolution;
import java.math.*;
import java.util.Arrays;

public class TestSolution {
    public static void main(String[] args) {
        int x = 14 & 7;
        System.out.println(x);
//        int x = 14 && 7;
//        System.out.println(x); not compile
        x = 14 | 7;
        System.out.println(x);
        x = (-14) & 7;
        System.out.println(x);
        x = (-14) | 7;
        System.out.println(x);
        x = 14 & (-7);
        System.out.println(x);
        x = 14 | (-7);
        System.out.println(x);
        x = (-14) & (-7);
        System.out.println(x);
        x = (-14) | (-7);
        System.out.println(x);


        int value = 1234567890;
        for (int k = 0; k < 32; k++) {
            value = rightShift(value);
        }
        if (value != 1234567890) {
            throw new AssertionError();
        }
        System.out.println(value);

        System.out.println(swapBits(0b0000_0001, 0, 1));
        int[] result = merge(new int[]{2, 6}, new int[]{3, 4, 5});
        for(int a : result)  System.out.print(a + " ");
        System.out.println();
        System.out.println(lookFor(1));
        for(int a : lookFor(new int[]{0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0}))  System.out.print(a + " ");

    }

    public static int[] lookFor(int[] array) {
        int temp = 0;
        int finish = 0;
        int count = 0;
        int[] result = new int[2];
        for(int i = 0; i < array.length; i++){
            if (array[i] > 0){
                count++;
                finish = i;
                if(i == array.length - 1 && count >= temp){
                    temp = count;
                    result[1] = finish;
                    result[0] = finish - count + 1;
                    count = 0;
                }
            }else if(i > 0 && array[i] <= 0 && array[i-1] > 0 && count >= temp) {
                finish = i - 1;
                temp = count;
                result[1] = finish;
                result[0] = finish - count + 1;
                count = 0;
            }//else count = 0;
        }
        if (temp == 0)  result = new int[]{};
        return result;
        /*BODY*/
    }

    public static int lookFor(int max) {
        int a = 1;
        int b = 1;
        int count = 0;
        while (a*a + b*b <= max){
            while (a*a + b*b <= max){
                count++;
                b++;
            }
            a++;
            b = 1;
        }
        return count;
        /*BODY*/
    }

    public static int rightShift(int ar) {
        if (ar % 2 != 0) return (ar >>> 1) + 0b10000000_00000000_00000000_00000000;
        else return ar >>> 1;
        /*BODY*/
    }

    public static byte swapBits(int b, int i, int j) {
        byte temp = 0b0000_0001;
        if (((b >>> i) % 2 == 1 & (b >>> j) % 2 == 0) || ((b >>> i) % 2 == 0 & (b >>> j) % 2 == 1))
            return (byte) (b ^ (temp << i) ^ (temp << j));
        else return (byte)b;

    }
    public static int[] merge(int[] fst, int[] snd) {
        int[] result = new int[fst.length + snd.length];
        int fstIndex = 0;
        int sndIndex = 0;
        int i = 0;
        if (fst.length == 0 & snd.length == 0) return result;
        if (fst.length == 0) return result = Arrays.copyOf(snd, snd.length);
        if (snd.length == 0) return result = Arrays.copyOf(fst, fst.length);

        while (i != result.length) {
            if (fst[fstIndex] < snd[sndIndex]) {
                result[i] = fst[fstIndex++];
                if(fstIndex == fst.length){
                    for(int a = sndIndex; a < snd.length; a++){
                        i++;
                        result[i] = snd[a];
                    }
                }
            }else {
                result[i] = snd[sndIndex++];
                if(sndIndex == snd.length){
                    for(int a = fstIndex; a < fst.length; a++){
                        i++;
                        result[i] = fst[a];
                    }
                }
            }
            i++;
        }
        return result;
        /*BODY*/
    }
}
