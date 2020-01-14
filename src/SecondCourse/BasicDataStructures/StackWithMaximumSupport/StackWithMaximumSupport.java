package SecondCourse.BasicDataStructures.StackWithMaximumSupport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackWithMaximumSupport {

    public static void main(String[] args) throws IOException {
        new StackWithMaximumSupport().run();
    }

    public void run() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line;
        int k;           // считываемое число
        int temp = -1;    // последний максимум
        Stack<Integer> fi = new Stack<>();
        Stack<Integer> se = new Stack<>();

        line = br.readLine().split(" ");    // ввод количества операций
        int size = Integer.parseInt(line[0]);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            line = br.readLine().split(" ");    // ввод операций формата "push 200" "pop" "max"
            if (line[0].equals("push")) {
                k = Integer.parseInt(line[1]);
                fi.add(k);
                if (k > temp) {
                    temp = k;
                }
                se.add(temp);
            } else if (line[0].equals("pop")) {
                fi.pop();
                se.pop();
                k = se.peek();
                if (k < temp) {
                    temp = k;
                }
            } else if (line[0].equals("max")) {
                sb.append(temp + "\n");
            }
        }

        System.out.println(sb.toString());
    }
}
