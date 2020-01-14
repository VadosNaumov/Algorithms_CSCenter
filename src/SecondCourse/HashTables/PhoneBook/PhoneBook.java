package SecondCourse.HashTables.PhoneBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    public static void main(String[] args) throws IOException {
        new PhoneBook().run();
    }

    public void run() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder res = new StringBuilder();        // результат

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);           // число запросов

        Map<Integer, String> book = new HashMap<>(); // список родителей
        for (int i = 0; i < n; i++) {                 // ввод запросов
            line = br.readLine().split(" ");
            switch (line[0]){
                case "add":                                 // добавляем новую запись
                    book.put(Integer.parseInt(line[1]), line[2]);
                    break;
                case "find":                                 // находим запись и записываем имя
                    if (book.containsKey(Integer.parseInt(line[1]))){
                        res.append(book.get(Integer.parseInt(line[1]))).append("\n");
                    } else {
                        res.append("not found\n");
                    }
                    break;
                case "del":                                 // удаляем запись
                    book.remove(Integer.parseInt(line[1]));
                    break;
            }
        }
        System.out.print(res.toString());
    }
}
