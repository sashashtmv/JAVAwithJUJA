package com.apofig.sorting;

/**
 * User: oleksandr.baglai
 * Date: 1/17/13
 * Time: 4:05 PM
 */
public interface Array<T extends Comparable> {

    /**
     * Размер массива. Сложность 1*SIZE
     */
    int size();

    /**
     * Меняет местами две ячейки массива. Сложность 2*SET + 2*GET
     */
    void swap(int index1, int index2);

    /**
     * Возвращает элемент по индексу из массива. Сложность 1*GET
     */
    Element<T> get(int index);

    /**
     * Устанавливает элемент массива по индексу. Сложность 1*SET
     */
    void set(int index, T value);

    /**
     * Копирует элемент массива из одной позиции в другую. Сложность 1*SET + 1*GET
     */
    void copy(int fromIndex, int toIndex);

    /**
     * Устанавливает элемент массива по индексу. Сложность 1*SET
     */
    void set(int index, Element data);

    /**
     * Сравнивает два элемента. Сложность 2*GET
     */
    int compare(int index1, int index2);
}
