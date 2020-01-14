package SecondCourse.BasicDataStructures.TreeHeight;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreeHeightTest {

    @Test
    void run1() {
        int n = 5;
        List<Integer> list = new ArrayList<>(Arrays.asList(-1, 0, 4, 0, 3));
        Integer expected = 4;
        Integer actual = new TreeHeight().run(n, list);
        assertEquals(expected, actual);
    }

    @Test
    void run2() {
        int n = 5;
        List<Integer> list = new ArrayList<>(Arrays.asList(4, -1, 4, 1, 1));
        Integer expected = 3;
        Integer actual = new TreeHeight().run(n, list);
        assertEquals(expected, actual);
    }

    @Test
    void run3() {
        int n = 10;
        List<Integer> list = new ArrayList<>(Arrays.asList(9, 7, 5, 5, 2, 9, 9, 9, 2, -1));
        Integer expected = 4;
        Integer actual = new TreeHeight().run(n, list);
        assertEquals(expected, actual);
    }
}