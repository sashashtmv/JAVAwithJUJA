package com.apofig.sorting;

import com.apofig.sorting.algorithm.*;
import junit.framework.AssertionFailedError;
import org.junit.Test;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

/**
 * User: oleksandr.baglai
 * Date: 1/17/13
 * Time: 3:24 PM
 */
public class SortingTester {

    @Test
    public void checkAllForStableness() {
        checkAll(getDataForTesting(1000, 100)); // много дублирующихся данных
    }
    // {1a, 2a, 4, 5, 6, 2b, 1b, 2c, 2d, 3}
    // {1a, 1b, 2->a, 2->b, 2->c, 2->d, 3, 4, 5, 6} // stable
    // {1a, 1b, 2->c, 2->a, 2->d, 2->b, 3, 4, 5, 6} // nonstable

    @Test
    public void checkAllForSpeed() {
        checkAll(getDataForTesting(10000, 100000000)); // почти все данные уникальны
    }

    @Test
    public void testBrokenElement() {
        Array<Integer> data = getDataForTesting(100, 100);
        DemoSorter sorter = new DemoSorter();
        sorter.enableBrokenElement();
        try {
            test(data, sorter);
            fail();
        } catch (IllegalStateException err) {
            assertTrue(err.getMessage(), err.getMessage().contains("Cant find element"));
        }
    }

    @Test
    public void testBrokenSorting() {
        Array<Integer> data = getDataForTesting(100, 100);
        DemoSorter sorter = new DemoSorter();
        sorter.enableBrokenSorting();
        try {
            test(data, sorter);
            fail();
        } catch (IllegalStateException err) {
            assertTrue(err.getMessage(), err.getMessage().contains("Broken sorting at"));
        }
    }

    @Test
    public void testBrokenStable() {
        Array<Integer> data = getDataForTesting(100, 100);
        DemoSorter sorter = new DemoSorter();
        sorter.enableBrokenStable();
        String info = test(data, sorter);
        assertTrue(info, info.contains("Not stable"));
    }

    private void checkAll(Array<Integer> data) {
        test(data, new BubbleSorter());
        test(data, new BubbleFlaggedSorter());
        test(data, new BubbleSelectionSorter());
        test(data, new SelectionSorter());
        test(data, new CocktailSorter());
        test(data, new GnomeSorter());
        test(data, new InsertionSorter());
        test(data, new QuickSorter());
        test(data, new DualPivotQuickSorter());
        test(data, new MergeSorter());
    }

    private String test(Array<Integer> data, Sorter sorter) {
        data = copy(data);
        ArrayRecorder<Integer> sorted = new ArrayCounter<Integer>(data);
        Array<Integer> original = copy(sorted);

        sorted.record();
        sorter.sort(sorted);
        sorted.stop();

        boolean stable = validateSorting(sorted, original);

        return prepareOutput(sorter, sorted, stable);
    }

    private String prepareOutput(Sorter sorter, ArrayRecorder<Integer> sorted, boolean stable) {
//        System.out.println(original.toString());
//        System.out.println(sorted.toString());

        String output = "";
        output += "---------------------------------------------------------\n";
        output += "Sorter:" + sorter.getClass().getSimpleName() + "\n";
        if (stable) {
            output += "Stable" + "\n";
        } else {
            output += "Not stable" + "\n";
        }
        output += "Array length:" + sorted.size() + "\n";
        output += "Score:" + getScore(sorted, stable) + "\n";
        output += "Operations:" + sorted.getStatistic().print() + "\n";
        System.out.print(output);
        return output;
    }

    private boolean validateSorting(ArrayRecorder<Integer> sorted, Array<Integer> original) {
        SorterValidator validator = new SorterValidator();
        String warning = validator.assertThatSorted(sorted);
        if (warning.length() != 0) {
            throw new  IllegalStateException(warning);
        }
        warning = validator.assertThatAllElementsPresent(sorted, original);
        if (warning.length() != 0) {
            throw new  IllegalStateException(warning);
        }
        warning = validator.assertThatStableSorting(sorted);
        boolean isStable = warning.length() == 0;
        return isStable;
    }

    private Array<Integer> copy(Array<Integer> data) {
        return new ArrayImpl<Integer>(data);
    }

    public Array<Integer> getDataForTesting(int arrayLength, int maxNumber) {
        int[] result = new int[arrayLength];
        for (int index = 0; index < result.length; index ++) {
            result[index] = getRandom(maxNumber);
        }
        return new ArrayImpl<Integer>(result);
    }

    private int getRandom(int maxNumber) {
        return new Random().nextInt(maxNumber);
    }

    public double getScore(ArrayRecorder<Integer> sorted, boolean stable) {
        Statistic statistic = sorted.getStatistic();

        double score = 1000000*sorted.size()/(
                statistic.get(Operations.GET) +
                statistic.get(Operations.SIZE) +
                statistic.get(Operations.SET));

        return score;
    }
}
