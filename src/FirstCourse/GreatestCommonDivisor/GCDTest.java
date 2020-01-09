package FirstCourse.GreatestCommonDivisor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GCDTest {

    @Test
    public void greatCD1() {
        long first = 18;
        long second = 35;
        long actual = new GCD().greatCD(first, second);
        long expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void greatCD2() {
        long first = 14159572;
        long second = 63967072;
        long actual = new GCD().greatCD(first, second);
        long expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void greatCD3() {
        long first = 60;
        long second = 45;
        long actual = new GCD().greatCD(first, second);
        long expected = 15;
        assertEquals(expected, actual);
    }

    @Test
    public void greatCD4() {
        long first = 8;
        long second = 24;
        long actual = new GCD().greatCD(first, second);
        long expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    public void greatCD5() {
        long first = 19;
        long second = 2185;
        long actual = new GCD().greatCD(first, second);
        long expected = 19;
        assertEquals(expected, actual);
    }
}