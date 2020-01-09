package FirstCourse.HaffmanCoding;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HaffmanCoding {

    class Node implements Comparable<Node> {

        final int sum;
        String code;

        void buildCode(String code) {
            this.code = code;
        }

        public Node(int sum) {
            this.sum = sum;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(sum, o.sum);
        }
    }

    class NodeNode extends Node {

        Node left;
        Node right;

        public NodeNode(Node left, Node right) {
            super(left.sum + right.sum);
            this.left = left;
            this.right = right;
        }

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }
    }

    class Leaf extends Node {

        char letter;

        public Leaf(char letter, int count) {
            super(count);
            this.letter = letter;
        }

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            System.out.println(letter + ": " + code);
        }
    }

    public void run() {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        Map<Character, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (dictionary.containsKey(letter)) {
                dictionary.put(letter, dictionary.get(letter) + 1);
            } else {
                dictionary.put(letter, 1);
            }
        }

        Map<Character, Node> chars = new HashMap<>();
        PriorityQueue<Node> pQ = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> elem : dictionary.entrySet()) {
            Leaf node = new Leaf(elem.getKey(), elem.getValue());
            chars.put(elem.getKey(), node);
            pQ.add(node);
        }

        int sum = 0;
        while (pQ.size() > 1) {
            Node first = pQ.poll();
            Node second = pQ.poll();
            NodeNode nodeN = new NodeNode(first, second);
            sum += nodeN.sum;
            pQ.add(nodeN);
        }

        if (dictionary.size() == 1) {
            sum = s.length();
        }

        System.out.println(dictionary.size() + " " + sum);

        Node base = pQ.poll();
        if (dictionary.size() == 1) {
            base.buildCode("0");
        } else {
            base.buildCode("");
        }

        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            resultString.append(chars.get(c).code);
        }
        System.out.println(resultString);
    }

    public static void main(String[] args) {
        new HaffmanCoding().run();
    }
}
