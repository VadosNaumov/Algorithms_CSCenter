package SecondCourse.HashTables.ChainHashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ChainHashing {

    private int m;

    public static void main(String[] args) throws IOException {
        new ChainHashing().run();
    }

    private long hashFunc(String text){
        long hash = 0;
        char[] letter = text.toCharArray();
        long x = 1;
        int p = 1_000_000_007;
        for (int i = 0; i < letter.length; i++) {
            hash += Math.abs((letter[i] * x) % p);
            x *= 263;
            x %= p;
        }
        return (Math.abs((hash % p) % m));
    }

    public void run() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder res = new StringBuilder();           // результат
        String[] line = br.readLine().split(" ");
        m = Integer.parseInt(line[0]);                     // размер хеш-таблицы
        line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);                 //  количество запросов

        Map<Long, Stack<String>> book = new HashMap<>();     // хеш-таблица
        for (int i = 0; i < n; i++) {                        // ввод запросов
            line = br.readLine().split(" ");
            String z = line[1];
            long w = hashFunc(z);
            switch (line[0]){
                case "add":                                 // добавляем запись в таблицу
                    if (book.containsKey(w)){
                        if (!book.get(w).contains(z)){
                            book.get(w).push(z);
                        }
                    } else {
                        book.put(w, new Stack<>());
                        book.get(w).push(z);
                    }
                    break;
                case "find":                                 // находим запись и записываем содержимое
                    if (book.containsKey(w) && book.get(w).contains(z)){
                        res.append("yes\n");
                    } else {
                        res.append("no\n");
                    }
                    break;
                case "del":                                 // удаляем запись из таблицы
                    if (book.containsKey(w)){
                        book.get(w).remove(z);
                    }
                    break;
                case "check":                                 // вывод списка i
                    long k = Long.parseLong(z);
                    if (book.containsKey(k)){
                        for (int y = book.get(k).size() - 1; y >= 0; y--) {
                            res.append(book.get(k).get(y) + " ");
                        }
                        res.deleteCharAt(res.length() - 1);
                    }
                    res.append("\n");
                    break;
            }
        }
        System.out.print(res.toString());
    }
}
