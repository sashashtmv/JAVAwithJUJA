package com.apofig.sorting;

import com.apofig.sorting.algorithm.BubbleSorter;

/**
 * User: oleksandr.baglai
 * Date: 1/17/13
 * Time: 3:25 PM
 * First sample from http://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0_%D0%BF%D1%83%D0%B7%D1%8B%D1%80%D1%8C%D0%BA%D0%BE%D0%BC
 */
public class DemoSorter extends BubbleSorter implements Sorter {

    private boolean brokenStable = false;
    private boolean brokenSorting = false;
    private boolean brokenElement = false;

    @Override
    public void sort(Array data) {
        super.sort(data);

        if (brokenStable) {
            brokenStable(data);
        }
        if (brokenSorting) {
            brokenSorting(data);
        }
        if (brokenElement) {
            brokenElement(data);
        }
    }

    public void enableBrokenStable() {
        brokenStable = true;
    }

    public void enableBrokenSorting() {
        brokenSorting = true;
    }

    public void enableBrokenElement() {
        brokenElement = true;
    }

    private void brokenElement(Array data) {
        data.set(0, -1);
    }

    private void brokenSorting(Array data) {
        data.swap(0, data.size() - 1);
    }

    private void brokenStable(Array data) {
        for (int i=0; i < data.size() - 1; i++) {
            if (data.get(i).compareTo(data.get(i+1)) == 0) {
                data.swap(i, i+1);
            }
        }
    }
}
