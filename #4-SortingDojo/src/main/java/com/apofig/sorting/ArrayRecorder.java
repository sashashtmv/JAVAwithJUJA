package com.apofig.sorting;

/**
 * User: oleksandr.baglai
 * Date: 1/17/13
 * Time: 4:58 PM
 */
public interface ArrayRecorder<T extends Comparable> extends Array<T>{
    void stop();

    void record();

    Statistic getStatistic();
}
