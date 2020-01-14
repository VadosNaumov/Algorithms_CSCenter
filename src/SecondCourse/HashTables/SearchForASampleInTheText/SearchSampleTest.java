package SecondCourse.HashTables.SearchForASampleInTheText;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchSampleTest {

    @Test
    public void run1() {
        String pattern = "aba";
        String text = "abacaba";
        String actual = new SearchForASampleInTheText().run(pattern, text);
        String expected = "0 4 ";
        assertEquals(expected, actual);
    }

    @Test
    public void run2() {
        String pattern = "Test";
        String text = "testTesttesT";
        String actual = new SearchForASampleInTheText().run(pattern, text);
        String expected = "4 ";
        assertEquals(expected, actual);
    }

    @Test
    public void run3() {
        String pattern = "aaaaa";
        String text = "baaaaaaa";
        String actual = new SearchForASampleInTheText().run(pattern, text);
        String expected = "1 2 3 ";
        assertEquals(expected, actual);
    }

    @Test
    public void run4() {
        String pattern = "aaa";
        String text = "baabbbaaabbbaaabbbaaa";
        String actual = new SearchForASampleInTheText().run(pattern, text);
        String expected = "6 12 18 ";
        assertEquals(expected, actual);
    }

    @Test
    public void run5() {
        String pattern = "aaab";
        String text = "aaaaaaab";
        String actual = new SearchForASampleInTheText().run(pattern, text);
        String expected = "4 ";
        assertEquals(expected, actual);
    }

    @Test
    public void run6() {
        String pattern = "aaab";
        String text = "aaab";
        String actual = new SearchForASampleInTheText().run(pattern, text);
        String expected = "0 ";
        assertEquals(expected, actual);
    }

    @Test
    public void run7() {
        String pattern = "aaab";
        String text = "aaac";
        String actual = new SearchForASampleInTheText().run(pattern, text);
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    public void run8() {
        String pattern = "tesTt";
        String text = "texTttssTttestttssTttesTttssTttestttssTttesTttssTttestttssTttesTttssTttestttssTttesTttssTttestttssTttesTttssTttestttssTttesTttssTttestttssTttesTttssTttestttssTttesTttssTttestttssTttesTttssTttestttssTttesTttssTttestttssTttesTttssTttestttssTt";
        String actual = new SearchForASampleInTheText().run(pattern, text);
        String expected = "20 40 60 80 100 120 140 160 180 200 220 ";
        assertEquals(expected, actual);
    }
}