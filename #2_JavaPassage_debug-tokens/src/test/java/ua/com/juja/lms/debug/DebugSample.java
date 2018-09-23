package ua.com.juja.lms.debug;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by indigo on 2017-04-26.
 */
public class DebugSample {

    @Test
    public void legacyCode() {
        List<String> list = new LinkedList<String>() {{
            add("four");
            add("three");
            add("two");
            add("one");
        }};

        Collections.sort(list);

        assertEquals("[one, two, three, four]", list.toString());
    }

    @Test
    public void legacyCode_arraysSort() {
        String[] array = new String[]{"four", "three", "two", "one"};

        Arrays.sort(array);

        assertEquals("[one, two, three, four]", Arrays.toString(array));
    }

    @Test
    public void stepInto() {
        if (isA() && isB() && isC()) {
            System.out.println("Ok!");
        }
    }

    @Test
    public void exceptionBreakpoints() {
        try {
            someMethod();
        } catch (RuntimeException e) {
            System.out.println("!!!!!!!!!!! Это самое место...");
            System.out.println(e);
        }
    }

    private void someMethod() {
        throw new RuntimeException("Juja is awesome!!!");
    }

    public boolean isB() {
        return true;
    }

    public boolean isA() {
        return true;
    }

    public boolean isC() {
        return true;
    }

    private int field = 3;

    @Test
    public void changeField() {
        System.out.println(field);
        method2();
    }

    private void method2() {
        field = 3;
    }
}
