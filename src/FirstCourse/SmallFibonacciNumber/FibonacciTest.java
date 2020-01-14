package FirstCourse.SmallFibonacciNumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void fibonacci1() {
        int n = 3;
        int expected = 2;
        int actual = new Fibonacci().fibonacci(n);
        assertEquals(expected, actual);
    }

    @Test
    void fibonacci2() {
        int n = 10;
        int expected = 55;
        int actual = new Fibonacci().fibonacci(n);
        assertEquals(expected, actual);
    }

    @Test
    void fibonacci3() {
        int n = 1;
        int expected = 1;
        int actual = new Fibonacci().fibonacci(n);
        assertEquals(expected, actual);
    }
}