package com.apofig.sorting.algorithm;

import com.apofig.sorting.Array;
import com.apofig.sorting.Sorter;

import java.util.Arrays;

/**
 * User: oleksandr.baglai
 * Date: 1/17/13
 * Time: 3:25 PM
 * Sample from http://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0_%D0%BF%D0%B5%D1%80%D0%B5%D0%BC%D0%B5%D1%88%D0%B8%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5%D0%BC
 */
public class CocktailSorter implements Sorter {


    public void sort(Array data) {
        int size = data.size();

        //границы сортировки
        int left = 1;
        int right = size - 1;

        //место последней перестановки
        int last = size - 1;

        do {
            //Сдвигаем к концу массива "легкие элементы"
            for (int i = right; i >= left; i--) {
                if (data.get(i - 1).compareTo(data.get(i)) > 0) {
                    data.swap(i, i - 1);
                    last = i; //Запомнить место последней перестановки
                }
            }

            left = last + 1;

            //Сдвигаем к началу массива "тяжелые элементы"
            for (int i = left; i <= right; i++) {
                if (data.get(i - 1).compareTo(data.get(i)) > 0) {
                    data.swap(i, i - 1);
                    last = i; //Запомнить место последней перестановки
                }
            }

            right = last - 1;
        } while (left <= right);
    }
}
