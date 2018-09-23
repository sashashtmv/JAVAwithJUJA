package com.apofig.sorting.algorithm;

import com.apofig.sorting.Array;
import com.apofig.sorting.Element;
import com.apofig.sorting.Sorter;

/**
 * User: oleksandr.baglai
 * Date: 1/17/13
 * Time: 3:25 PM
 * Sample from http://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0_%D0%B2%D1%81%D1%82%D0%B0%D0%B2%D0%BA%D0%B0%D0%BC%D0%B8
 */
public class InsertionSorter implements Sorter {


    public void sort(Array data) {
        int size = data.size();

        for (int i = 1; i < size; i++) {
            Element key = data.get(i);
            int j = i - 1;
            while (j >= 0 && data.get(j).compareTo(key) > 0) {
                data.copy(j, j + 1);
                j = j - 1;
            }
            data.set(j + 1, key);
        }
    }
}
