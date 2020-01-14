package FirstCourse.PointsInSegments;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class PointsInSegments {

    public ArrayList<Integer> run(SortedMap<Integer, Integer> input) {

        ArrayList<Integer> result = new ArrayList<>();
        while (!input.isEmpty()) {
            result.add(input.firstKey());
            int k = input.firstKey();
            input.remove(k);
            while (true && !input.isEmpty()) {
                if (input.get(input.firstKey()) <= k) {
                    input.remove(input.firstKey());
                } else break;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        SortedMap<Integer, Integer> segment = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter number of segments");
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
//            System.out.println("Enter left and right ends of segment number = " + i);
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            if (!((segment.containsKey(right)) && (segment.get(right) > left))) {
                segment.put(right, left);
            }
        }

        ArrayList<Integer> result = new PointsInSegments().run(segment);
        System.out.println(result.size());
        for (Object e : result.toArray()) {
            System.out.printf("%d ", e);
        }
    }
}
