package FirstCourse.LastDigitLargeFibonacci;

import java.util.Scanner;

public class LargeFibonacci {

    private static final int MOD = (int) (1e9);

    private int lastDigitFibonacci(int n) {

        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++) {
            int c = (a + b) % 10;
            a = b;
            b = c;
        }
        return a;
    }

    public void run(int n) {
        System.out.println(n + " Last digit : " + lastDigitFibonacci(n));
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Fibonacci number");
        new LargeFibonacci().run(scanner.nextInt());

    }
}
