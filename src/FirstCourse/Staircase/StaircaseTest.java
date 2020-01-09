package FirstCourse.Staircase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaircaseTest {

    @Test
    void sum1() {
        int[] x = {2, -1};
        Staircase staircase = new Staircase();
        staircase.a = x;
        staircase.n = x.length;
        staircase.b = new int[staircase.n + 1];
        int actual = staircase.sum();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void sum2() {
        int[] x = {1, 2};
        Staircase staircase = new Staircase();
        staircase.a = x;
        staircase.n = x.length;
        staircase.b = new int[staircase.n + 1];
        int actual = staircase.sum();
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    void sum3() {
        int[] x = {-1, 2, 1};
        Staircase staircase = new Staircase();
        staircase.a = x;
        staircase.n = x.length;
        staircase.b = new int[staircase.n + 1];
        int actual = staircase.sum();
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    void sum4() {
        int[] x = {0, 0, 0, 4, 6, -5};
        Staircase staircase = new Staircase();
        staircase.a = x;
        staircase.n = x.length;
        staircase.b = new int[staircase.n + 1];
        int actual = staircase.sum();
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void sum5() {
        int[] x = {-64, -16, -13, -9, -48};
        Staircase staircase = new Staircase();
        staircase.a = x;
        staircase.n = x.length;
        staircase.b = new int[staircase.n + 1];
        int actual = staircase.sum();
        int expected = -73;
        assertEquals(expected, actual);
    }

    @Test
    void sum6() {
        int[] x = {3, 4, 10, 10, 0, -6, -10, 0};
        Staircase staircase = new Staircase();
        staircase.a = x;
        staircase.n = x.length;
        staircase.b = new int[staircase.n + 1];

        int actual = staircase.sum();
        int expected = 21;
        assertEquals(expected, actual);
    }
}