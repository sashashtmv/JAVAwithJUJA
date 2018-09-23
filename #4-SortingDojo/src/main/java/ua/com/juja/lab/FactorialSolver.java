package ua.com.juja.lab;

/**
 * Created by indigo on 17.07.2000.
 */
public class FactorialSolver {
    public static long f(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        return f(n - 1) + f(n - 2);
    }
}
