import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumbersTest {

    @Test
    void numberSum() {
        Numbers sum = new Numbers();
        int actual = sum.numberSum(5);
        int expected = 15;
        assertEquals(expected, actual);
    }
}