package SecondCourse.PriorityQueue.BuildingHeap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuildingHeapTest {

    @Test
    void run1() {
        String expected = "\n1 4\n0 1\n1 3";
        String actual = new BuildingHeap().run(5, "5 4 3 2 1").toString();
        assertEquals(expected, actual);
    }

    @Test
    void run2() {
        String expected = "";
        String actual = new BuildingHeap().run(5, "1 2 3 4 5").toString();
        assertEquals(expected, actual);
    }
}