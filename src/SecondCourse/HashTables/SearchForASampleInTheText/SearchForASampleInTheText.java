package SecondCourse.HashTables.SearchForASampleInTheText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SearchForASampleInTheText {

    int p = 1_000_000_007;      //большое простое число
    int x = 777_666_555;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pattern = br.readLine();
        String text = br.readLine();
        System.out.println(new SearchForASampleInTheText().run(pattern, text));
    }

    public static long pow(int x, int i, int p) {
        long result = 1;
        for (int j = 1; j <= i; j++) {
            result = ((result % p) * (x % p)) % p;
        }
        return result;
    }

    private int hashFunc(char[] letter) {
        long result = 0;
        long pow = 1;
        for (int i = letter.length - 1; i >= 0; i--) {
            result = (result % p + ((letter[i] % p) * pow) % p + p) % p;
            pow = (((pow % p) * (x % p)) % p + p) % p;
        }
        return (int) (result);
    }

    public String run(String pattern, String text) {

        StringBuilder sb = new StringBuilder();
        char[] chPatt = pattern.toCharArray();
        int k = pattern.length();
        long pattHash = hashFunc(chPatt);
        char[] chText = text.toCharArray();
        long big = pow(x, k - 1, p);          //самая большая степень x

        char[] tempo = new char[k];
        System.arraycopy(chText, 0, tempo, 0, k);

        long w = hashFunc(tempo);
        long temp = w;
        if (w == pattHash) {
            if (Arrays.equals(tempo, chPatt)) {
                sb.append(0 + " ");
            }
        }

        int n = text.length() - k;
        outer:
        for (int i = 1; i <= n; i++) {
            w = (((((temp % p - (chText[i - 1] % p) * (big % p)) % p + p) % p) * x % p) % p + p) % p + chText[i + k - 1] % p;
            temp = w;
            if (w == pattHash) {
                for (int j = 0; j < k; j++) { //при совпадении хэшей, проверяются крайние символы
                    if (chPatt[j] != chText[i + j] || chPatt[k - j - 1] != chText[i + k - j - 1]) {
                        continue outer;
                    }
                }
                sb.append(i + " ");
            }
        }
        return sb.toString();
    }
}
