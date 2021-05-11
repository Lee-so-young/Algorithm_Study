import java.util.Scanner;

public class boj11724 {
    static int n, m;
    static int[] visited;
    static int map[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n + 1][n + 1];
        visited = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x][y] = map[y][x] = 1;
        }
        int cnt = 1;

        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {
                dfs(i, cnt);
                cnt++;
            }
        }
        System.out.println(cnt - 1);
    }

    public static void dfs(int x, int cnt) {
        visited[x] = cnt;
        for (int i = 1; i < n + 1; i++) {
            if (map[x][i] == 1 && visited[i] == 0)
                dfs(i, cnt);
        }
    }

}
