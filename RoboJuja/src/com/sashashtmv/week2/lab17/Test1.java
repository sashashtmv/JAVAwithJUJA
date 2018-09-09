package com.sashashtmv.week2.lab17;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.*;

public class Test1 extends Stack<Integer> {

    /* ПЕРЕМЕШИВАЕМ СПИСОК ИЗ ЧЕТЫРЕХ ЭЛЕМЕНТОВ */

    private final String role;
    private final List<String> actualHistory;

    public Test1(String role, List<String> actualHistory) {
        this.role = role;
        this.actualHistory = actualHistory;
    }

    public Integer push(Integer value) {
        actualHistory.add(role + ".push(" + value + ")");
        return super.push(value);
    }

    public Integer pop() {
        actualHistory.add(role + ".pop()");
        return super.pop();
    }

    public static void main(String[] args) {
        // в переменную actualHistory будем записывать
        // РЕАЛЬНЫЕ вызовы методов класса Stack
        List<String> actualHistory = new ArrayList<>();

        Stack<Integer> from = new Test1("from", actualHistory);
        Stack<Integer> help = new Test1("help", actualHistory);
        Stack<Integer> to = new Test1("to", actualHistory);

        // надо перенести четыре диска ('1', '2', '3', '4') с 'from' на 'to'
        from.push(4);
        from.push(3);
        from.push(2);
        from.push(1);

        // вызываем тестируемый метод
        HanoiSolver.exchange(from, help, to, 4);

        // в переменную expectedHistory записываем какая последовательность
        // вызовов методов Stack ДОЛЖНА БЫЛА БЫТЬ
        List<String> expectedHistory = Arrays.asList(
                // это начальная загрузка данными (на 'from')
                "from.push(4)", "from.push(3)", "from.push(2)", "from.push(1)",
                // переносим '1'+'2'+'3' с 'from' -> на 'help'
                "from.pop()", "help.push(1)",
                "from.pop()", "to.push(2)",
                "help.pop()", "to.push(1)",
                "from.pop()", "help.push(3)",
                "to.pop()", "from.push(1)",
                "to.pop()", "help.push(2)",
                "from.pop()", "help.push(1)",
                // переносим '4' с 'from' -> на 'to'
                "from.pop()", "to.push(4)",
                // переносим '1'+'2'+'3' с 'help' -> на 'to'
                "help.pop()", "to.push(1)",
                "help.pop()", "from.push(2)",
                "to.pop()", "from.push(1)",
                "help.pop()", "to.push(3)",
                "from.pop()", "help.push(1)",
                "from.pop()", "to.push(2)",
                "help.pop()", "to.push(1)"
        );
        // сравниваем - совпадают ли РЕАЛЬНАЯ и ТРЕБУЕМАЯ
        // последовательности вызовов методов класса Stack
        if (!actualHistory.equals(expectedHistory)) {
            throw new AssertionError("expectedHistory = " + expectedHistory + " but actualHistory = " + actualHistory);
        }

        System.out.print("OK");
    }
}