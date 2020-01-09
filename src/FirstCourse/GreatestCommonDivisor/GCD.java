package FirstCourse.GreatestCommonDivisor;

import java.util.Scanner;

public class GCD {

    protected long greatCD(long a, long b) {

        while (a != 0 && b != 0) {
            if (a > b){
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return (a == 0? b : a);
    }

    public void run(long a, long b) {
        System.out.println("GCD : " + greatCD(a, b));
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 2 numbers 1 ≤ a,b ≤ 2⋅10^9");
        new GCD().run(scanner.nextLong(), scanner.nextLong());

    }
}
