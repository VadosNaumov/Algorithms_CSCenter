package FirstCourse.InversionsNumber;

import java.util.Scanner;

public class InversionsNumber {

    long result;

    private int[] mergeArra(int[] a, int [] b) {
        int z = 0;
        int v = 0;
        int[] merArra = new int[a.length + b.length];
        for (int i = 0; i < merArra.length; i++) {
            if (v == b.length || (z < a.length && a[z] <= b[v])) {
                merArra[i] = a[z];
                z++;
            } else {
                merArra[i] = b[v];
                v++;
                result += a.length - z;
            }
        }
        return merArra;
    }

    public int[] separateSort(int[] a){
        if (a.length == 1) return a;
        int z = a.length / 2;
        int v = a.length - z;
        int[] first = new int[z];
        int[] second = new int[v];
        System.arraycopy(a, 0, first, 0, z);
        System.arraycopy(a, z, second, 0, v);
        first = separateSort(first);
        second = separateSort(second);
        return mergeArra(first, second);
    }

    public void run() {

        Scanner scanner = new Scanner(System.in);
        int sizeArray = scanner.nextInt();
        int[] data = new int[sizeArray];
        for (int i = 0; i < sizeArray; i++) {
            data[i] = scanner.nextInt();
        }
        separateSort(data);
        System.out.println(result);
    }

    public static void main(String[] args) {
        new InversionsNumber().run();
    }
}
