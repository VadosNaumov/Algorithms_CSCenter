package SecondCourse.BasicDataStructures.TreeHeight;

import java.util.*;

public class TreeHeight {
    public void run() {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        List<Integer> find = new ArrayList<>();
        int t;
        int k = 0;
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        for (int i = 0; i < n; i++) {
            t = 1;
            k = i;
            while (list.get(k) != -1){
                k = list.get(k);
                if (find.size() > k) {
                    t += find.get(k);
                    break;
                } else t++;
            }
            find.add(t);
        }

        Set<Integer> res = new TreeSet<>(find);
        System.out.println(((TreeSet<Integer>) res).last());
    }

    public static void main(String[] args) {
        new TreeHeight().run();
    }
}
