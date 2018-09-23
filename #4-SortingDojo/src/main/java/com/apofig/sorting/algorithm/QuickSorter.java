package com.apofig.sorting.algorithm;

import com.apofig.sorting.Array;
import com.apofig.sorting.Element;
import com.apofig.sorting.Sorter;

/**
 * User: oleksandr.baglai
 * Date: 1/17/13
 * Time: 3:25 PM
 * Sample from http://ru.wikipedia.org/wiki/%D0%91%D1%8B%D1%81%D1%82%D1%80%D0%B0%D1%8F_%D1%81%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0
 */
public class QuickSorter implements Sorter {


    public void sort(Array data) {
        int size = data.size();

        qSort(data, 0, size - 1);
    }

    public static void qSort(Array data, int low, int high) {
        int i = low;
        int j = high;
        Element<Comparable> x = data.get((low + high) / 2);  // x - опорный элемент посредине между low и high
        do {
            while (data.get(i).compareTo(x) < 0) ++i;  // поиск элемента для переноса в старшую часть
            while (data.get(j).compareTo(x) > 0) --j;  // поиск элемента для переноса в младшую часть
            if (i <= j) {
                // обмен элементов местами:
                data.swap(i, j);
                // переход к следующим элементам:
                i++;
                j--;
            }
        } while (i < j);
        if (low < j) qSort(data, low, j);
        if (i < high) qSort(data, i, high);
    }
}
