package FirstCourse.EditDistance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditDistanceTest {

    @Test
    void editDis1() {
        EditDistance eD = new EditDistance();
        String fi = "short";
        String se = "ports";
        int expected = 3;
        int actual = eD.run(fi, se);
        assertEquals(expected, actual);
    }

    @Test
    void editDis2() {
        EditDistance eD = new EditDistance();
        String fi = "sh";
        String se = "sh";
        int expected = 0;
        int actual = eD.run(fi, se);
        assertEquals(expected, actual);
    }

    @Test
    void editDis3() {
        EditDistance eD = new EditDistance();
        String fi = "sh";
        String se = "shlopq";
        int expected = 4;
        int actual = eD.run(fi, se);
        assertEquals(expected, actual);
    }

    @Test
    void editDis4() {
        EditDistance eD = new EditDistance();
        String fi = "s";
        String se = "123shas";
        int expected = 6;
        int actual = eD.run(fi, se);
        assertEquals(expected, actual);
    }

    @Test
    void editDis5() {
        EditDistance eD = new EditDistance();
        String fi = "";
        String se = "five";
        int expected = 4;
        int actual = eD.run(fi, se);
        assertEquals(expected, actual);
    }
}