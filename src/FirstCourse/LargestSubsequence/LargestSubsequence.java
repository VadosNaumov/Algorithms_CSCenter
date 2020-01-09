package FirstCourse.LargestSubsequence;

import java.util.Scanner;

public class LargestSubsequence {

    public void run()  {
        Scanner scanner = new Scanner(System.in);
        int sizeArray = scanner.nextInt();
        int[] data = new int[sizeArray];
        int[] build = new int[sizeArray];
        int[] prev = new int[sizeArray];
        data[0] = scanner.nextInt();
        build[0] = 1;
        prev[0] = -1;
        for (int i = 1; i < sizeArray; i++) {
            data[i] = scanner.nextInt();
            build[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < i; j++) {
                if ((data[i] >= data[j] && data[i] % data[j] == 0) && (build[j] + 1) > build[i]) {
                    build[i] = build[j] + 1;
                    prev[i] = j;
                }
            }
        }
        int max = build[0];
        for (int i = 1; i < sizeArray; i++) {
            if (build[i] > max) {
                max = build[i];
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        new LargestSubsequence().run();
    }
}
