package SecondCourse.BasicDataStructures.MaximumInSlidingWindow;

import java.util.*;

public class MaximumInSlidingWindow {

    public List<Integer> run(int n, int[] arr, int k) {

        // Очередь будет хранить индексы полезных элементов в каждом окне
        // и поддерживать убывающий порядок значений спереди назад в Qi

        Deque<Integer> Qi = new LinkedList<>();
        List<Integer> listResult = new ArrayList<>();

        // Обрабатываем первые k (первое окно) элементов массива
        int i;
        for (i = 0; i < k; ++i) {

            // Каждый прошлый элемент, который меньше теперешнего, удаляем из Qi

            while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()]) {
                Qi.removeLast(); // Remove from rear
            }
            // Добавляем новый элемент в Qi
            Qi.addLast(i);
        }

        // Обрабатываем оставшиеся элементы
        for (; i < n; ++i) {
            // Печатаем первый элемент в queue так как он крупнейший из предыдущего окна
            listResult.add(arr[Qi.peek()]);
            // Удаляем элемент который выходит за рамки окна
            while ((!Qi.isEmpty()) && Qi.peek() <= i - k) {
                Qi.removeFirst();
            }
            // Удаляем все элементы меньшие чем текущий
            while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()]) {
                Qi.removeLast();
            }
            // Добавляем текущий элемент в конец Qi
            Qi.addLast(i);
        }

        //  максимум из последнего окна
        listResult.add(arr[Qi.peek()]);
        return listResult;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();

        List<Integer> result = new MaximumInSlidingWindow().run(n, arr, k);
        System.out.println(result);
    }

}
