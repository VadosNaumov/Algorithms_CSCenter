package FirstCourse.VariousSummand;

import java.util.ArrayList;
import java.util.Scanner;

public class VariousSummand {

    public ArrayList<Integer> run(int number) {

        ArrayList<Integer> summand = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            if (i < number / 2) {
                summand.add(i);
                number = number - i;
            } else if ((i <= number / 2) && (number % 2 != 0)) {
                summand.add(i);
                number = number - i;
            } else if (i == number) {
                summand.add(i);
                break;
            }
        }
        return summand;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        ArrayList<Integer> summand = new VariousSummand().run(number);

        System.out.println(summand.size());
        for (Integer e : summand) {
            System.out.printf("%d ", e);
        }
    }
}
