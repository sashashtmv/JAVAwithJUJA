package com.apofig.sorting.algorithm;

import com.apofig.sorting.Array;
import com.apofig.sorting.Element;
import com.apofig.sorting.Sorter;

/**
 * Sample from http://iaroslavski.narod.ru/quicksort/DualPivotQuicksort.pdf
 *
 * @author Vladimir Yaroslavskiy
 * @version 2009.09.17 m765.817
 */
public class DualPivotQuickSorter implements Sorter {


    public void sort(Array data) {
        int size = data.size();

        sort(data, 0, size);
    }

    private static final int DIST_SIZE = 13;
    private static final int TINY_SIZE = 17;

    public static void sort(Array data, int fromIndex, int toIndex) {
        rangeCheck(data.size(), fromIndex, toIndex);
        dualPivotQuicksort(data, fromIndex, toIndex - 1);
    }

    private static void rangeCheck(int length, int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
        }
        if (fromIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(fromIndex);
        }
        if (toIndex > length) {
            throw new ArrayIndexOutOfBoundsException(toIndex);
        }
    }

    private static void dualPivotQuicksort(Array data, int left, int right) {
        int len = right - left;
        if (len < TINY_SIZE) { // insertion sort on tiny array
            for (int i = left + 1; i <= right; i++) {
                for (int j = i; j > left && data.compare(j, j - 1) < 0; j--) {
                    data.swap(j - 1, j);
                }
            }
            return;
        }
// median indexes
        int sixth = len / 6;
        int m1 = left + sixth;
        int m2 = m1 + sixth;
        int m3 = m2 + sixth;
        int m4 = m3 + sixth;
        int m5 = m4 + sixth;
// 5-element sorting network
        if (data.compare(m1, m2) > 0) {
            data.swap(m1, m2);
        }
        if (data.compare(m4, m5) > 0) {
            data.swap(m4, m5);
        }
        if (data.compare(m1, m3) > 0) {
            data.swap(m1, m3);
        }
        if (data.compare(m2, m3) > 0) {
            data.swap(m2, m3);
        }
        if (data.compare(m1, m4) > 0) {
            data.swap(m1, m4);
        }
        if (data.compare(m3, m4) > 0) {
            data.swap(m3, m4);
        }
        if (data.compare(m2, m5) > 0) {
            data.swap(m2, m5);
        }
        if (data.compare(m2, m3) > 0) {
            data.swap(m2, m3);
        }
        if (data.compare(m4, m5) > 0) {
            data.swap(m4, m5);
        }
// pivots: [ < pivot1 | pivot1 <= && <= pivot2 | > pivot2 ]
        Element<Comparable> pivot1 = data.get(m2);
        Element<Comparable> pivot2 = data.get(m4);
        boolean diffPivots = pivot1.compareTo(pivot2) != 0;
        data.copy(left, m2);
        data.copy(right, m4);
// center part pointers
        int less = left + 1;
        int great = right - 1;
// sorting
        if (diffPivots) {
            for (int k = less; k <= great; k++) {
                Element<Comparable> x = data.get(k);
                if (x.compareTo(pivot1) < 0) {
                    data.copy(less, k);
                    data.set(less++, x);
                } else {
                    if (x.compareTo(pivot2) > 0) {
                        while (data.get(great).compareTo(pivot2) > 0 && k < great) {
                            great--;
                        }
                        data.copy(great, k);
                        data.set(great--, x);
                        x = data.get(k);
                        if (x.compareTo(pivot1) < 0) {
                            data.copy(less, k);
                            data.set(less++, x);
                        }
                    }
                }
            }
        } else {
            for (int k = less; k <= great; k++) {
                Element<Comparable> x = data.get(k);
                if (x.compareTo(pivot1) == 0) {
                    continue;
                }
                if (x.compareTo(pivot1) < 0) {
                    data.copy(less, k);
                    data.set(less++, x);
                } else {
                    while (data.get(great).compareTo(pivot2) > 0 && k < great) {
                        great--;
                    }
                    data.copy(great, k);
                    data.set(great--, x);

                    x = data.get(k);
                    if (x.compareTo(pivot1) < 0) {
                        data.copy(less, k);
                        data.set(less++, x);
                    }
                }
            }
        }
// swap
        data.copy(less - 1, left);
        data.set(less - 1, pivot1);
        data.copy(great + 1, right);
        data.set(great + 1, pivot2);
// left and right parts
        dualPivotQuicksort(data, left, less - 2);
        dualPivotQuicksort(data, great + 2, right);
// equal elements
        if (great - less > len - DIST_SIZE && diffPivots) {
            for (int k = less; k <= great; k++) {
                Element<Comparable> x = data.get(k);
                if (x.compareTo(pivot1) == 0) {
                    data.copy(less, k);
                    data.set(less++, x);
                } else if (x.compareTo(pivot2) == 0) {
                    data.copy(great, k);
                    data.set(great--, x);
                    x = data.get(k);
                    if (x.compareTo(pivot1) == 0) {
                        data.copy(less, k);
                        data.set(less++, x);
                    }
                }
            }
        }
        // center part
        if (diffPivots) {
            dualPivotQuicksort(data, less, great);
        }
    }
}

