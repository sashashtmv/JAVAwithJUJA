package ua.com.juja.lab;

/**
 * Created by indigo on 17.07.2000.
 */
public class FibonacciSolver1 {
    static long[] cache = new long[100000];

    public static long f(int n) {
        if (n <= 2) {
            cache[n] = 1;
            return 1;
        }

        for (int index = 0; index <= n; index++) {
            if (cache[index] == 0) {
                cache[index] = cache[index - 1] + cache[index - 2];
            }
        }

        return cache[n];
    }
}
