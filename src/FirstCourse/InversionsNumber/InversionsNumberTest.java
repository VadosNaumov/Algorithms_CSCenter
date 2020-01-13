package FirstCourse.InversionsNumber;

import FirstCourse.HaffmanDecoding.HaffmanDecoding;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class InversionsNumberTest {

    @Test
    void separateSort1() {
        int[] first = {10, 8, 6, 2, 4, 5};
        InversionsNumber iN = new InversionsNumber();
        iN.separateSort(first);
        long actual = iN.result;
        long expected = 12;
        assertEquals(expected, actual);
    }

    @Test
    void separateSort2() {
        int[] first = {2, 3, 9, 2, 9};
        InversionsNumber iN = new InversionsNumber();
        iN.separateSort(first);
        long actual = iN.result;
        long expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void separateSort3() {
        int[] first = {1, 9, 8, 1, 4, 1};
        InversionsNumber iN = new InversionsNumber();
        iN.separateSort(first);
        long actual = iN.result;
        long expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    void separateSort4() {
        int[] first = {6, 5, 8, 6, 0, 4};
        InversionsNumber iN = new InversionsNumber();
        iN.separateSort(first);
        long actual = iN.result;
        long expected = 10;
        assertEquals(expected, actual);
    }

    @Test
    void separateSort5() {
        int[] first = {6, 2, 3, 7, 5, 8};
        InversionsNumber iN = new InversionsNumber();
        iN.separateSort(first);
        long actual = iN.result;
        long expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void separateSort6() {
        int[] first = {6, 4, 5, 0, 0, 2};
        InversionsNumber iN = new InversionsNumber();
        iN.separateSort(first);
        long actual = iN.result;
        long expected = 11;
        assertEquals(expected, actual);
    }

    @Test
    void separateSort7() {
        int[] first = {8, 9, 10, 7, 4, 0};
        InversionsNumber iN = new InversionsNumber();
        iN.separateSort(first);
        long actual = iN.result;
        long expected = 12;
        assertEquals(expected, actual);
    }

    @Test
    void separateSort8() {
        int[] first = {10, 9, 3, 8, 3, 10};
        InversionsNumber iN = new InversionsNumber();
        iN.separateSort(first);
        long actual = iN.result;
        long expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    void separateSort9() {
        int[] first = {5, 7, 0, 2, 2, 0};
        InversionsNumber iN = new InversionsNumber();
        iN.separateSort(first);
        long actual = iN.result;
        long expected = 10;
        assertEquals(expected, actual);
    }
}