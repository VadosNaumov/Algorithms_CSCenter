package FirstCourse.VariousSummand;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VariousSummandTest {

    @Test
    void run1() {
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> actual = new VariousSummand().run(6);
        assertEquals(expected, actual);
    }

    @Test
    void run2() {
        List<Integer> expected = new ArrayList<>(Arrays.asList(1));
        List<Integer> actual = new VariousSummand().run(1);
        assertEquals(expected, actual);
    }

    @Test
    void run3() {
        List<Integer> expected = new ArrayList<>(Arrays.asList(2));
        List<Integer> actual = new VariousSummand().run(2);
        assertEquals(expected, actual);
    }

    @Test
    void run4() {
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 3));
        List<Integer> actual = new VariousSummand().run(4);
        assertEquals(expected, actual);
    }

    @Test
    void run5() {
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 6));
        List<Integer> actual = new VariousSummand().run(9);
        assertEquals(expected, actual);
    }

    @Test
    void run6() {
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 7));
        List<Integer> actual = new VariousSummand().run(13);
        assertEquals(expected, actual);
    }
}