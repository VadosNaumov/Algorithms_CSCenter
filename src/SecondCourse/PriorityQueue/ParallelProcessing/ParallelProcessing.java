package SecondCourse.PriorityQueue.ParallelProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class ParallelProcessing {

    String[] line;
    int proc;               // количество процессоров
    int amTask;             // количество задач
    long time;
    int n;
    Queue<Processor> queue; // очередь процессоров
    StringBuilder sb = new StringBuilder(); // ответ: номер процессора и время начала обработки

    public static void main(String[] args) throws IOException {
        new ParallelProcessing().run();
    }

    public void run() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        line = br.readLine().split(" ");
        proc = Integer.parseInt(line[0]);
        amTask = Integer.parseInt(line[1]);

        queue = new PriorityQueue<>(proc);
        for (int i = 0; i < proc; i++) {                 // ввод массива процессоров
            queue.add(new Processor(0, i));
        }

        line = br.readLine().split(" ");
        for (int i = 0; i < amTask; i++) {
            sb.append(queue.peek().getN()).append(" ").append(queue.peek().getTime()).append("\n");
            time = queue.peek().getTime();
            n = queue.poll().getN();
            queue.add(new Processor(time + Integer.parseInt(line[i]), n)); // обновляем время у процессора в связи с новой задачей
        }

        System.out.print(sb.toString());
    }

    private class Processor implements Comparable<Processor> {
        int n;          // номер процессора
        long time;      // время начала выполнения задачи у процессора

        public Processor(long time, int n) {
            this.n = n;
            this.time = time;
        }

        public int getN() {
            return n;
        }

        public long getTime() {
            return time;
        }

        @Override
        public int compareTo(Processor o) {
            if (time != o.getTime()) {
                return Long.compare(time, o.getTime());
            } else {
                return Long.compare(n, o.getN());
            }
        }
    }
}
