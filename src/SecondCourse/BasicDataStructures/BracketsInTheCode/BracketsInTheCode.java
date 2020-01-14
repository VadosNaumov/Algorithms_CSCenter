package SecondCourse.BasicDataStructures.BracketsInTheCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BracketsInTheCode {

    private Stack<Character> stack = new Stack();
    private List<Integer> list = new ArrayList<>();
    char[] brackets;
    char top;
    int x = 0;

    private boolean operate(){
        for (int i = 0; i < brackets.length; i++) {
            x++;
            if (Character.valueOf(brackets[i]).equals('(')
                    || Character.valueOf(brackets[i]).equals('[')
                    || Character.valueOf(brackets[i]).equals('{')
                    || Character.valueOf(brackets[i]).equals('}')
                    || Character.valueOf(brackets[i]).equals(']')
                    || Character.valueOf(brackets[i]).equals(')')) {

                if (Character.valueOf(brackets[i]).equals('(')
                        || Character.valueOf(brackets[i]).equals('[')
                        || Character.valueOf(brackets[i]).equals('{')) {
                    stack.push(brackets[i]);
                    list.add(i + 1);
                } else {
                    if (stack.empty()) return false;
                    top = stack.pop();
                    list.remove(list.size() - 1);
                    if ((Character.valueOf(top).equals('(') && !Character.valueOf(brackets[i]).equals(')'))
                            || (Character.valueOf(top).equals('[') && !Character.valueOf(brackets[i]).equals(']'))
                            || (Character.valueOf(top).equals('{') && !Character.valueOf(brackets[i]).equals('}'))) {
                        return false;
                    }
                }
            }
        }
        if (!stack.empty()) {
            x = list.get(0);
        }
        return stack.empty();
    }

    public String run(String s) {
        brackets = s.toCharArray();
        boolean answer = operate();
        if (answer) {
            return "Success";
        } else {
            return String.valueOf(x);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String res = new BracketsInTheCode().run(s);
        System.out.println(res);
    }
}
