package FirstCourse.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    public void run()  {

        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().split(" ");
        String[] line2 = scanner.nextLine().split(" ");

        int sizeFirst = Integer.parseInt(line1[0]);
        int[] first = new int[sizeFirst];
        for (int i = 1; i <= sizeFirst; i++) {
            first[i - 1] = Integer.parseInt(line1[i]);
        }

        int sizeSecond = Integer.parseInt(line2[0]);
        StringBuilder sb = new StringBuilder();
        int k;

        for (int i = 1; i <= sizeSecond; i++) {
            k = Arrays.binarySearch(first, Integer.parseInt(line2[i])) + 1;
            if (k < 1) {
                sb.append(-1).append(" ");
            } else {
                sb.append(k).append(" ");
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args)  {
        new BinarySearch().run();
    }
}
