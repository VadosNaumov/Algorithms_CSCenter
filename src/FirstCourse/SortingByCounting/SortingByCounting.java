package FirstCourse.SortingByCounting;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SortingByCounting {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int sizeArray = scanner.nextInt();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i + 1, 0);
        }
        for (int i = 0; i < sizeArray; i++) {
            int c = scanner.nextInt();
            map.put(c, map.get(c) + 1);
        }

        int[] data = new int[sizeArray];
        int count = 0;
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j < map.get(i); j++) {
                data[count++] = i;
            }
        }

        for (int el : data) {
            System.out.printf(el + " ");
        }
    }

    public static void main(String[] args) {
        new SortingByCounting().run();
    }
}
