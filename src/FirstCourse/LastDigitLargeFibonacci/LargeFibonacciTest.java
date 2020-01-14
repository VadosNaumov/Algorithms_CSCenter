package FirstCourse.LastDigitLargeFibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargeFibonacciTest {

    @Test
    void lastDigitFibonacci1() {
        int n = 10;
        int expected = 5;
        int actual = new LargeFibonacci().lastDigitFibonacci(n);
        assertEquals(expected, actual);
    }

    @Test
    void lastDigitFibonacci2() {
        int n = 696352;
        int expected = 9;
        int actual = new LargeFibonacci().lastDigitFibonacci(n);
        assertEquals(expected, actual);
    }

    @Test
    void lastDigitFibonacci3() {
        int n = 2;
        int expected = 1;
        int actual = new LargeFibonacci().lastDigitFibonacci(n);
        assertEquals(expected, actual);
    }

}