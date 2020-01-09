package FirstCourse.SmallFibonacciNumber;

import java.util.Scanner;

public class Fibonacci {

    private static final int MOD = (int) (1e9);

    private int fibonacci(int n) {
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++) {
            int c = (a + b) % MOD;
            a = b;
            b = c;
        }
        return a;
    }

    public void run(int n) {
        System.out.println(n + " Fib : " + fibonacci(n));
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Fibonacci number");
        new Fibonacci().run(scanner.nextInt());

    }
}
