package SecondCourse.BasicDataStructures.TreeHeight;

import java.util.*;

public class TreeHeight {

    public Integer run(int n, List<Integer> list) {

        List<Integer> find = new ArrayList<>();
        int t;
        int k;

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
        return  ((TreeSet<Integer>) res).last();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        Integer result = new TreeHeight().run(n, list);
        System.out.println(result);
    }
}
