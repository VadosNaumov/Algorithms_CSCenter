package SecondCourse.PriorityQueue.BuildingHeap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BuildingHeap {

    Integer size;           // размер кучи
    int temp;               // временная переменная
    int minIndex;           // минимальный i
    int l;                  // левый ребенок
    int r;                  // правый ребенок
    List<Integer> fi;
    int count = 0;              // счетчик
    StringBuilder sb = new StringBuilder();

    private int parent(int i){
        return (i - 1) / 2;
    }

    private int leftChild(int i){
        return 2 * i + 1;
    }

    private int rightChild(int i){
        return 2 * i + 2;
    }

    private void siftUp(int i){
        while (i > 0 && fi.get(parent(i)) > fi.get(i)){
            temp = fi.get(i);
            fi.set(i, fi.get(parent(i)));
            fi.set(parent(i), temp);
            i = parent(i);
        }
    }

    private void siftDown(int i) {
        minIndex = i;
        l = leftChild(i);
        if (l < size && fi.get(l) < fi.get(minIndex)){
            minIndex = l;
        }
        r = rightChild(i);
        if (r < size && fi.get(r) < fi.get(minIndex)){
            minIndex = r;
        }
        if (i != minIndex) {
            count++;
            sb.append("\n").append(i).append(" ").append(minIndex);
            temp = fi.get(minIndex);
            fi.set(minIndex, fi.get(i));
            fi.set(i, temp);
            siftDown(minIndex);
        }
    }

    private void buildHeap(List<Integer> he) {
        size = he.size();
        for (int i = (size - 1) / 2; i >= 0; i--) {
            siftDown(i);
        }
    }

    public StringBuilder run(Integer n, String str) {

        String[] line = str.split(" ");
        Integer size = n;
        fi = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            fi.add(Integer.parseInt(line[i]));
        }

        buildHeap(fi);
        System.out.print(count);
        return sb;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        String line = br.readLine();

        StringBuilder result = new BuildingHeap().run(n, line);
        System.out.println(result.toString());
    }
}
