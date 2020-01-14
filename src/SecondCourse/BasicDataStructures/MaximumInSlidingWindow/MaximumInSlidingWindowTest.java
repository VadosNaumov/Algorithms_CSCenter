package SecondCourse.BasicDataStructures.MaximumInSlidingWindow;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaximumInSlidingWindowTest {

    @Test
    void run1() {
        List<Integer> expected = Arrays.asList(7, 7, 5, 6, 6);
        int n = 8;
        int[] arr = {2, 7, 3, 1, 5, 2, 6, 2};
        int k = 4;
        List<Integer> actual = new MaximumInSlidingWindow().run(n, arr, k);
        assertEquals(expected, actual);
    }

    @Test
    void run2() {
        List<Integer> expected = Arrays.asList(2, 1, 5);
        int n = 3;
        int[] arr = {2, 1, 5};
        int k = 1;
        List<Integer> actual = new MaximumInSlidingWindow().run(n, arr, k);
        assertEquals(expected, actual);
    }

    @Test
    void run3() {
        List<Integer> expected = Arrays.asList(9);
        int n = 3;
        int[] arr = {2, 3, 9};
        int k = 3;
        List<Integer> actual = new MaximumInSlidingWindow().run(n, arr, k);
        assertEquals(expected, actual);
    }
}