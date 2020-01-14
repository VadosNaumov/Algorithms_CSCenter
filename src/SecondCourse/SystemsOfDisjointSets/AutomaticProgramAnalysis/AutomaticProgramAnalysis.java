package SecondCourse.SystemsOfDisjointSets.AutomaticProgramAnalysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AutomaticProgramAnalysis {

    List<Integer> rank;       // массив высот деревьев. в ячейке i хранится высота поддерева с корнем в вершине i
    List<Integer> parents;     // список родителей
    int fi;               // временная переменная
    int se;               // временная переменная
    int res = 1;               // временная переменная

    public static void main(String[] args) throws IOException {
        new AutomaticProgramAnalysis().run();
    }

    public void run() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line;
        line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);           // число таблиц
        int m = Integer.parseInt(line[1]);           // число равенств типа (destination i, source i)
        int d = Integer.parseInt(line[2]);           // число неравенств типа (destination i, source i)

        parents = new ArrayList<>(n);
        rank = new ArrayList<>();
        for (int i = 0; i < n; i++) {                 // ввод массива таблиц и рангов с заданными рангами
            parents.add(i + 1);
            rank.add(0);
        }
        for (int i = 0; i < m; i++) {            // ввод номеров таблиц, которые необходимо объединить
            line = br.readLine().split(" ");
            fi = Integer.parseInt(line[0]);
            se = Integer.parseInt(line[1]);
            union(fi, se);
        }
        for (int i = 0; i < d; i++) {            // ввод номеров таблиц, которые без связи
            line = br.readLine().split(" ");
            fi = Integer.parseInt(line[0]);
            se = Integer.parseInt(line[1]);
            if (find(fi) == find(se)) {
                res = 0;
            }
        }

        System.out.print(res);
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
        if (rank.get(i - 1) > rank.get(j - 1)){
            parents.set(j - 1, i);
        } else {
            parents.set(i - 1, j);
            if (rank.get(i - 1) == rank.get(j - 1)){
                rank.set(j - 1, rank.get(j - 1) + 1);
            }
        }
    }
}
