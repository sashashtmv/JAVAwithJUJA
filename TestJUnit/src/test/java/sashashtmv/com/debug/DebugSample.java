package sashashtmv.com.debug;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by indigo on 2017-04-26.
 */
public class DebugSample {

    @Rule
    public TestRule timeout = new Timeout(100);

    @Test
    public void legacyCode() {
        List<String> list = new LinkedList<String>() {{
            add("four");
            add("three");
            add("two");
            add("one");
        }};

        Collections.sort(list);

        assertEquals("[four, one, three, two]", list.toString());
    }

    @Test
    public void legacyCode_arraysSort() {
        String[] array = new String[]{"four", "three", "two", "one"};

        Arrays.sort(array);

        assertEquals("[four, one, three, two]", Arrays.toString(array));
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
