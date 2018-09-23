package com.apofig.sorting.algorithm;

import com.apofig.sorting.Array;
import com.apofig.sorting.Sorter;

/**
 * User: oleksandr.baglai
 * Date: 1/17/13
 * Time: 3:25 PM
 * First sample from http://ru.wikipedia.org/wiki/%D0%93%D0%BD%D0%BE%D0%BC%D1%8C%D1%8F_%D1%81%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0
 */
public class GnomeSorter implements Sorter {


    public void sort(Array data) {
        int size = data.size();

        int i = 1;
        int j = 2;
        while (i < size) {
            //для сортировки по убыванию поменяйте знак сравнения на >=
            if (data.get(i - 1).compareTo(data.get(i)) <= 0) {
                i = j;
                j = j + 1;
            } else {
                data.swap(i - 1, i);
                i = i - 1;
                if (i == 0) {
                    i = j;
                    j = j + 1;
                }
            }
        }
    }
}
