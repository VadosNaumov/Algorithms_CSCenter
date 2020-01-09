package FirstCourse.HaffmanDecoding;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HaffmanDecoding {


    public String decoding(Map<String, Character> alphabet, String text){

        StringBuilder resultString = new StringBuilder();
        StringBuilder interim = new StringBuilder();
        char[] ara = text.toCharArray();
        interim.append(ara[0]);
        for (int i = 1; i < ara.length; i++) {
            if (alphabet.containsKey(interim.toString())){
                resultString.append(alphabet.get(interim.toString()));
                interim.delete(0, interim.length());
            }
            interim.append(ara[i]);
        }
        resultString.append(alphabet.get(interim.toString()));
        return resultString.toString();
    }


    public void run()  {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String[] par = line1.split(" ");
        int quantity = Integer.parseInt(par[0]);
        int stringLength = Integer.parseInt(par[1]);
        Map<String, Character> alphabet = new HashMap<>();
        for (int i = 0; i < quantity; i++) {
            String line = scanner.nextLine();
            char letter = line.charAt(0);
            String codeLetter = line.substring(3);
            alphabet.put(codeLetter, letter);
        }
        String text = scanner.nextLine();

        System.out.println(decoding(alphabet, text));
    }

    public static void main(String[] args)  {
        new HaffmanDecoding().run();
    }
}
