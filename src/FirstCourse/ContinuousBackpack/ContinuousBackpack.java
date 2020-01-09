package FirstCourse.ContinuousBackpack;

import java.util.Arrays;
import java.util.Scanner;

public class ContinuousBackpack {

    class Item implements Comparable<Item>{

        int cost;
        int volume;

        public Item(int cost, int volume) {
            this.cost = cost;
            this.volume = volume;
        }

        @Override
        public int compareTo(Item e) {
            double r1 = (double) cost / volume;
            double r2 = (double) e.cost / e.volume;
            return -Double.compare(r1, r2);
        }
    }

    public double run() {

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        Item[] items = new Item[number];
        int volume = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            items[i] = new Item(scanner.nextInt(), scanner.nextInt());
        }
        Arrays.sort(items);
        double res = 0;
        for (Item e : items) {
            if (e.volume <= volume) {
                res += e.cost;
                volume -= e.volume;
            } else {
                res += (double) e.cost * volume / e.volume;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        double res = new ContinuousBackpack().run();
        System.out.println(res);
    }
}
