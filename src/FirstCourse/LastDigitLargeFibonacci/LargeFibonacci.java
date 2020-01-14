package FirstCourse.LastDigitLargeFibonacci;

import java.util.Scanner;

public class LargeFibonacci {

    public int lastDigitFibonacci(int n) {

        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++) {
            int c = (a + b) % 10;
            a = b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Fibonacci number");
        int res = new LargeFibonacci().lastDigitFibonacci(scanner.nextInt());
        System.out.println(res);

    }
}
