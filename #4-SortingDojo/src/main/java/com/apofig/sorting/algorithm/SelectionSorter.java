package com.apofig.sorting.algorithm;

import com.apofig.sorting.Array;
import com.apofig.sorting.Sorter;

/**
 * User: oleksandr.baglai
 * Date: 1/17/13
 * Time: 3:25 PM
 * First sample from http://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0_%D0%BF%D1%83%D0%B7%D1%8B%D1%80%D1%8C%D0%BA%D0%BE%D0%BC
 */
public class SelectionSorter implements Sorter {


    public void sort(Array data) {
        int size = data.size();

        /* внешний цикл. i – позиция первого неотсортированного элемента на данной итерации */
        for (int i = 0; i < size - 1; i++) {
            int min = i; /* min – позиция минимального элемента */

            /* внутренний цикл. если найден элемент строго меньший текущего минимального, записываем его индекс как минимальный */
            for (int j = i + 1; j < size; j++) {
                if (data.get(j).compareTo(data.get(min)) < 0) {
                    min = j;
                }
            }
            if (min != i) { /* минимальный элемент не является первым неотсортированным, обмен нужен */
                data.swap(i, min);
            }
        }
    }
}
