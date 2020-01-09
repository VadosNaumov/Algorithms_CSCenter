package FirstCourse.Staircase;

import java.util.Scanner;

public class Staircase {

    int n;
    int[] a;
    int[] b;

    public int sum() {
        if (n == 1) return a[0];
        if (n == 2 && a[0] > 0) return a[0] + a[1];
        else if (n == 2) return a[1];
        int prevPrev = 0;
        int prev = 1;
        b[prevPrev] = 0;
        b[prev] = a[0];

        for (int i = 2; i < b.length; i++, prev++, prevPrev++) {
            if (b[prev] >= b[prevPrev]) {
                b[i] = b[prev] + a[i - 1];
            } else {
                b[i] = b[prevPrev] + a[i - 1];
            }
        }
        return b[b.length - 1];
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        b = new int[n + 1];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();

        System.out.println(sum());
    }

    public static void main(String[] args) {
        new Staircase().run();
    }
}
