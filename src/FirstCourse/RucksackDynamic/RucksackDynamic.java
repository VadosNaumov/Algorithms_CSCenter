package FirstCourse.RucksackDynamic;

import java.util.Scanner;

public class RucksackDynamic {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        int res = 0;

        int[][] dd = new int[w + 1][n + 1];
        for (int i = 0; i <= w; i++) {
            dd[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dd[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                dd[j][i] = dd[j][i - 1];
                if (a[i - 1] <= j){
                    dd[j][i] = Math.max(dd[j][i - 1], dd[j - a[i - 1]][i - 1] + a[i - 1]);
                }
            }
        }
        res = dd[w][n];
        System.out.println(res);
    }


    public static void main(String[] args) {
        new RucksackDynamic().run();
    }
}
