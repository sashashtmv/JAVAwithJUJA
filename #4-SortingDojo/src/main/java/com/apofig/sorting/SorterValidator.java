package com.apofig.sorting;

import java.util.Collection;
import java.util.LinkedList;

import static junit.framework.Assert.assertTrue;

/**
 * User: oleksandr.baglai
 * Date: 1/17/13
 * Time: 9:36 PM
 */
public class SorterValidator {

    public String assertThatStableSorting(Array<Integer> data) {
        Collection<String> warnings = new LinkedList<String>();
        int index = 0;
        while (index < data.size() - 1) {
            if (data.compare(index, index + 1) == 0) {
                Element<Integer> element1 = data.get(index);
                Element<Integer> element2 = data.get(index + 1);

                if (element1.getId() > element2.getId()) {
                    warnings.add(String.format("Not stable at data[%s]=I%s.%s <> data[%s]=I%s.%s",
                            index, element1.getId(), element1.getData(),
                            index + 1, element2.getId(), element2.getData()));
                }
            }

            index++;
        }
        return listToString(warnings);
    }

    public String assertThatAllElementsPresent(Array<Integer> data, Array<Integer> original) {
        Collection<String> warnings = new LinkedList<String>();
        for (int index = 0; index < data.size(); index++) {
            Element<Integer> element = original.get(index);
            if (!isPresent(data, element)) {
                warnings.add(String.format("Cant find element original[%s]=I%s.%s in sorted array",
                        index, element.getId(), element.getData()));
            }
        }
        return listToString(warnings);
    }

    private boolean isPresent(Array<Integer> data, Element<Integer> element) {
        for (int index = 0; index < data.size(); index++) {
            if (data.get(index).equals(element)) {
                return true;
            }
        }
        return false;
    }

    public String assertThatSorted(Array<Integer> data) {
        Collection<String> warnings = new LinkedList<String>();
        for (int index = 0; index < data.size() - 1; index ++) {
            if (data.compare(index, index + 1) > 0) {
                warnings.add(String.format("Broken sorting at data[%s]=%s !< data[%s]=%s",
                        index, data.get(index).getData(), index + 1, data.get(index+1).getData()));
            }
        }
        return listToString(warnings);
    }

    private String listToString(Collection<String> warnings) {
        return warnings.toString().replaceAll(",", "\n").replaceAll("\\[", "").replaceAll("\\]", "");
    }
}
