package FirstCourse.Calculator;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Calculator {

    int n;
    int med1 = 0;
    int med2 = 0;
    int med3 = 0;
    int res = 0;
    Set<Integer> a = new TreeSet<>();
    int[] b;

    private int calculate() {
        a.add(n);
        if (n == 1) return 0;
        if (n == 2) {
            a.add(1);
            return 1;
        }
        if (n == 3) {
            a.add(1);
            return 1;
        }
        b[0] = 0;
        b[1] = 0;
        b[2] = 1;
        b[3] = 1;
        for (int i = 4; i < b.length; i++) {
            if (i % 3 == 0) {
                med3 = b[i / 3] + 1;
            } else {
                med3 = 100;
            }
            if (i % 2 == 0) {
                med2 = b[i / 2] + 1;
            } else {
                med2 = 100;
            }
            med1 = b[i - 1] + 1;
            b[i] = Math.min(med3, Math.min(med1, med2));
        }
        res = n;
        a.add(res);
        while (true) {
            med3 = med1 = med2 = res;
            if (res % 3 == 0) med3 = res / 3;
            if (res % 2 == 0) med2 = res / 2;
            med1 = res - 1;

            res = (b[med3] <= Math.min(b[med1], b[med2]) ? med3 : (b[med2] <= b[med1] ? med2 : med1));
            a.add(res);
            if (res == 1) break;
        }
        return b[n];
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        b = new int[n + 1];
        System.out.println(calculate());
        for (int ele : a) {
            System.out.printf("%d ", ele);
        }
    }

    public static void main(String[] args) {
        new Calculator().run();
    }
}
