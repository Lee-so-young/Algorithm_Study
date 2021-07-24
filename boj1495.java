
import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1495 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] vol = new int[n + 1];
        boolean[][] dp = new boolean[n + 1][m + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            vol[i] = Integer.parseInt(st.nextToken());


        //두번째 곡부터 계산
        for (int i = 1; i <= n; i++)
            Arrays.fill(dp[i], false);

        //초기값 설정
        dp[0][s] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (dp[i - 1][j]) {
                    if (j + vol[i] <= m) {
                        dp[i][j + vol[i]] = true;
                    }
                    if (0 <= j - vol[i]) {
                        dp[i][j - vol[i]] = true;
                    }
                }
            }
        }

        int ans = -1;

        for (int i = 0; i <= m; i++) {
            if (dp[n][i])
                ans = Math.max(ans, i);
        }

        System.out.println(ans);
    }

}