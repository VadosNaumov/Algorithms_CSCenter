package SecondCourse.BasicDataStructures.BracketsInTheCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BracketsInTheCodeTest {

    @Test
    void run1() {
        String expected = "Success";
        String line = "([](){([])})";
        BracketsInTheCode bc = new BracketsInTheCode();
        String actual = bc.run(line);
        assertEquals(expected, actual);
    }

    @Test
    void run2() {
        String expected = "5";
        String line = "()[]}";
        BracketsInTheCode bc = new BracketsInTheCode();
        String actual = bc.run(line);
        assertEquals(expected, actual);
    }

    @Test
    void run3() {
        String expected = "7";
        String line = "{{[()]]";
        BracketsInTheCode bc = new BracketsInTheCode();
        String actual = bc.run(line);
        assertEquals(expected, actual);
    }

    @Test
    void run4() {
        String expected = "19";
        String line = "(ert)y[ui][f{d}ff](fd[]{}ww[";
        BracketsInTheCode bc = new BracketsInTheCode();
        String actual = bc.run(line);
        assertEquals(expected, actual);
    }

    @Test
    void run5() {
        String expected = "10";
        String line = "foo(bar[i);";
        BracketsInTheCode bc = new BracketsInTheCode();
        String actual = bc.run(line);
        assertEquals(expected, actual);
    }
}