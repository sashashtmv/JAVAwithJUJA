package com.sashashtmv.week2.lab16;

/*
реализована не оптимально, так как внутренний цикл while
- ищет позицию для вставки, перебирая последовательно элементы, при этом он
- поэлементно "смещает" массив.

В целях оптимизации перепишите алгоритм:
1. Ищите позицию для вставки элемента бинарным поиском (Arrays.binarySearch(...)).
2. Найдя позицию - смещайте всю часть массива за один вызов (System.arraycopy(...)).
В моих экспериментах эти две оптимизации ускорили сортировку в 2.2-2.6 раза. Скорость сортировки измерял данным кодом

import java.util.Random;

public class App {
    public static void main(String[] args) {
        int[] array = new int[256 * 1024];
        Random rnd = new Random(0);
        for (int k = 0; k < array.length; k++) {
            array[k] = rnd.nextInt();
        }
        long t1 = System.nanoTime();
        InsertionSorter.sort(array);
        System.out.println("A:" + (System.nanoTime() - t1) / 1_000_000);
    }
}
 */

import java.util.Arrays;

public class InsertSort {

    public static int[] sort(int[] arr) {
        int[] temp = arr.clone();


//        for(int a: arr) System.out.print(a + "  ");
//        System.out.println();
        for (int k = 1; k < arr.length; k++) {
            if (arr[k-1] > arr[k]) {
                int minIndex = -Arrays.binarySearch(temp,0, k-1, arr[k])-1;
                System.out.println(minIndex);
                System.arraycopy(arr, k, temp, minIndex, arr.length - k);
                System.arraycopy(arr, k-1, temp, arr.length - 1, 1);
            }
        }
        return temp;
    }
}
