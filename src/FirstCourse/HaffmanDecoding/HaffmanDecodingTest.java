package FirstCourse.HaffmanDecoding;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HaffmanDecodingTest {

    @Test
    void decoding1() {
        Map<String, Character> alphabet = new HashMap<>();
        alphabet.put("0", 'a');
        alphabet.put("10", 'b');
        alphabet.put("110", 'c');
        alphabet.put("111", 'd');
        String cipher = "01001100100111";
        String actual = new HaffmanDecoding().decoding(alphabet, cipher);
        String expected = "abacabad";
        assertEquals(actual, expected);
    }

    @Test
    void decoding2() {
        Map<String, Character> alphabet = new HashMap<>();
        alphabet.put("0", 'a');
        String cipher = "0";
        String actual = new HaffmanDecoding().decoding(alphabet, cipher);
        String expected = "a";
        assertEquals(actual, expected);
    }

    @Test
    void decoding3() {
        Map<String, Character> alphabet = new HashMap<>();
        alphabet.put("0", 'a');
        String cipher = "000";
        String actual = new HaffmanDecoding().decoding(alphabet, cipher);
        String expected = "aaa";
        assertEquals(actual, expected);
    }

    @Test
    void decoding4() {
        Map<String, Character> alphabet = new HashMap<>();
        alphabet.put("00", 'a');
        alphabet.put("1", 'b');
        alphabet.put("01", 'c');
        String cipher = "1011001011";
        String actual = new HaffmanDecoding().decoding(alphabet, cipher);
        String expected = "bcbabcb";
        assertEquals(actual, expected);
    }

    @Test
    void decoding5() {
        Map<String, Character> alphabet = new HashMap<>();
        alphabet.put("1", 'a');
        alphabet.put("01", 'b');
        alphabet.put("00", 'c');
        String cipher = "0001111111";
        String actual = new HaffmanDecoding().decoding(alphabet, cipher);
        String expected = "cbaaaaaa";
        assertEquals(actual, expected);
    }
}