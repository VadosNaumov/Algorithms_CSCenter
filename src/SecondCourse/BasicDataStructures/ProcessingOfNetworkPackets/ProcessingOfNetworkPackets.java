package SecondCourse.BasicDataStructures.ProcessingOfNetworkPackets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class ProcessingOfNetworkPackets {

    public static void main(String[] args) throws IOException {

        int size; // размер буфера
        int k;    // число пакетов
        int time = 0;   // время текущее
        int occup = 0; // занятость буфера
        int ar;   // время начала пакета
        int du; // продолжительность

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line;
        line = br.readLine().split(" ");
        size = Integer.parseInt(line[0]);
        k = Integer.parseInt(line[1]);
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new ArrayDeque<>(size);

        if (k == 0) {
            System.out.println();
        } else {
            for (int i = 0; i < k; i++) {
                line = br.readLine().split(" ");
                ar = Integer.parseInt(line[0]);
                du = Integer.parseInt(line[1]);

                if (!q.isEmpty() && ar >= q.peekFirst()) {
                    occup--;
                    q.removeFirst();
                }

                if (size > occup) {
                    occup++;
                    if (time >= ar) {
                        sb.append(time + "\n");
                        time += du;
                    } else {
                        sb.append(ar + "\n");
                        time = ar + du;
                    }
                    q.add(time);
                } else {
                    sb.append("-1\n");
                }
            }
            System.out.println(sb.toString());
        }
    }

}
