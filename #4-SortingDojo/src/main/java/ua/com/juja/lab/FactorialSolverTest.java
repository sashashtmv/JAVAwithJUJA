package ua.com.juja.lab;

/**
 * Created by indigo on 17.07.2000.
 */
public class FactorialSolverTest {
    public static void main(String[] args) {
        validate(0, 1);
        validate(1, 1);
        validate(2, 1);
        validate(14, 377);
        validate(60, 1548008755920L);
    }

    private static void validate(int number, long result) {
        long actual = FactorialSolver.f(number);
        if (actual != result) {
            System.out.println("Expected F(" + number + ")=" + result + " but was " + actual);
        }
    }
}
