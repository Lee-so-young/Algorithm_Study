import java.util.*;
//https://c-king.tistory.com/251

public class boj2422 {

    public static void main(String[] args) {
       int n;
       int m;
       boolean[][] map;

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x][y] = true;
            map[y][x] = true;
        }

        int cnt = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                for (int k = j + 1; k < n + 1; k++) {
                    if (map[i][j] || map[i][k] || map[j][k])
                        continue;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
