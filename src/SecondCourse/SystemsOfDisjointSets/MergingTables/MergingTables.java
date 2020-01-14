package SecondCourse.SystemsOfDisjointSets.MergingTables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MergingTables {

    String[] line;
    int n;               // число таблиц
    int m;             // число запросов типа (destination i, source i)
    List<Integer> rank;       // массив ранга деревьев. в ячейке i хранится ранг поддерева с корнем в вершине i
    List<Integer> parents;     // список родителей
    int fi;               // временная переменная
    int se;               // временная переменная
    int temp;               // временная переменная
    int res = 0;               // временная переменная
    StringBuilder sb = new StringBuilder(); // ответ: макс размер таблицы после соответствующего объединения

    public static void main(String[] args) throws IOException {
        new MergingTables().run();
    }

    public void run() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);           // число таблиц
        m = Integer.parseInt(line[1]);           // число запросов типа (destination i, source i)
        parents = new ArrayList<>(n);
        rank = new ArrayList<>();
        line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {                 // ввод массива таблиц с заданными рангами
            temp = Integer.parseInt(line[i]);
            rank.add(temp);
            if (temp > res) res = temp;
            parents.add(i + 1);
        }

        for (int i = 0; i < m; i++) {            // ввод номеров таблиц, которые необходимо объединить
            line = br.readLine().split(" ");
            fi = Integer.parseInt(line[0]);
            se = Integer.parseInt(line[1]);
            union(fi, se);
            sb.append(res).append("\n");
        }

        System.out.print(sb.toString());
    }

    private int getParent(int i){
        if (parents.isEmpty()) return -1;
        return parents.get(i - 1);
    }

    private int find (int i){
        while (i != getParent(i)){
            i = getParent(i);
        }
        return i;
    }

    private void union(int i, int j) {
        i = find(i);
        j = find(j);
        if (i == j) return;
        temp = rank.get(i - 1) + rank.get(j - 1);
        if (rank.get(i - 1) > rank.get(j - 1)){
            parents.set(j - 1, i);
            rank.set(i - 1, temp);
        } else {
            parents.set(i - 1, j);
            rank.set(j - 1, temp);
        }
        if (temp > res) res = temp;
    }
}
