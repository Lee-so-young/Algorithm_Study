import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj16916 {
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();

        kmp(s, p);
        System.out.println(ans);
    }

    static void kmp(String s, String p) {
        int[] pi = getPi(p);
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }
            if (s.charAt(i) == p.charAt(j)) {
                if (j == p.length() - 1) {
                    ans = 1;
                    break;
                } else
                    j++;
            }

        }
    }

    static int[] getPi(String p) {
        int[] pi = new int[p.length()];
        int j = 0;

        for (int i = 1; i < p.length(); i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }
            if (p.charAt(i) == p.charAt(j))
                pi[i] = ++j;
        }
        return pi;

    }
}
