package FirstCourse.QueuePriority;

import java.util.*;

public class QueuePriority {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int nCommand = Integer.parseInt(scanner.nextLine());
        PriorityQueue<Integer> pQ = new PriorityQueue<>(nCommand, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        List<Integer> list = new Vector<>();
        for (int i = 0; i < nCommand; i++) {
            String line = scanner.nextLine();
            if (line.equals("ExtractMax")) {
                list.add(pQ.poll());
            } else {
                String[] par = line.split(" ");
                int number = Integer.parseInt(par[1]);
                pQ.add(number);
            }
        }
        for (Integer elements : list) {
            System.out.println(elements);
        }
    }

    public static void main(String[] args) {
        new QueuePriority().run();
    }
}
