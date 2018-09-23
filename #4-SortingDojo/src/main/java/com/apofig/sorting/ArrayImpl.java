package com.apofig.sorting;

import java.util.Arrays;

/**
 * User: oleksandr.baglai
 * Date: 1/17/13
 * Time: 4:11 PM
 */
public class ArrayImpl<T extends Comparable> implements Array<T>{

    private Element<T>[] elements;

    public ArrayImpl(Array<T> data) {
        elements = new Element[data.size()];

        for (int index = 0; index < data.size(); index++) {
            elements[index] = data.get(index);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }


    public Element<T> get(int index) {
        return new Element<T>(elements[index]);
    }

    public ArrayImpl(int[] result) {
        elements = new Element[result.length];

        for (int index = 0; index < result.length; index++) {
            elements[index] = new Element(index, result[index]);
        }
    }


    public int size() {
        return elements.length;
    }


    public void swap(int i, int j) {
        Element temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }


    public void set(int index, T value) {
        elements[index].setData(value);
    }


    public void copy(int fromIndex, int toIndex) {
        elements[toIndex] = elements[fromIndex];
    }


    public void set(int index, Element key) {
        elements[index] = key;
    }


    public int compare(int index1, int index2) {
        return get(index1).getData().compareTo(get(index2).getData());
    }

}
