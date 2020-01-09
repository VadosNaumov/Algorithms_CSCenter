package FirstCourse.EditDistance;

import java.util.Scanner;

public class EditDistance {

    public String fi = "";
    public String se = "";
    public int result = 0;
    public int d[][];
    public boolean med[][];

    public int editDis(int n, int m) {
        if (n == 0 && m == 0) return 0;
        if (n == 0) return m;
        if (m == 0) return n;
        if (med[n][m]) return d[n][m];
        int r1 = editDis(n, m - 1) + 1;
        int r2 = editDis(n - 1, m) + 1;
        int r3 = editDis(n - 1, m - 1) + (fi.charAt(n - 1) == se.charAt(m - 1) ? 0 : 1);
        result = Math.min(r1, Math.min(r2, r3));
        med[n][m] = true;
        d[n][m] = result;
        return result;
    }

    public int run(String f, String s)  {
        fi = f;
        se = s;
        d = new int[fi.length() + 1][se.length() + 1];
        med = new boolean[fi.length() + 1][se.length() + 1];
        return editDis(fi.length(), se.length());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String f = scanner.next();
        String s = scanner.next();
        System.out.println(new EditDistance().run(f, s));
    }
}
