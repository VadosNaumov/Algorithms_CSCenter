package FirstCourse.PointsInSegments;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class PointsInSegmentsTest {

    @Test
    void run1() {
        SortedMap<Integer, Integer> map = new TreeMap<>();
        map.put(3, 1);
        map.put(5, 2);
        map.put(6, 3);
        ArrayList<Integer> actual = new PointsInSegments().run(map);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(3));
        assertEquals(expected, actual);
    }

    @Test
    void run2() {
        SortedMap<Integer, Integer> map = new TreeMap<>();
        map.put(7, 4);
        map.put(3, 1);
        map.put(5, 2);
        map.put(6, 5);
        ArrayList<Integer> actual = new PointsInSegments().run(map);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(3, 6));
        assertEquals(expected, actual);
    }

    @Test
    void run3() {
        SortedMap<Integer, Integer> map = new TreeMap<>();
        map.put(2, 1);
        map.put(4, 3);
        map.put(6, 5);
        map.put(8, 7);
        map.put(10, 9);
        ArrayList<Integer> actual = new PointsInSegments().run(map);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10));
        assertEquals(expected, actual);
    }
}