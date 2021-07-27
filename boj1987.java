import java.io.*;
import java.util.*;

public class boj1987 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int r, c;
    static char[][] map;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];

        for (int i = 0; i < r; i++)
            map[i] = br.readLine().toCharArray();

        HashSet<Character> set = new HashSet<>();
        set.add(map[0][0]);//시작 칸 저장
        dfs(0, 0, 1, set);

        System.out.println(result);
    }

    public static void dfs(int x, int y, int depth, Set<Character> set) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];


            if (nx < 0 || r <= nx || ny < 0 || c <= ny)
                continue;


            if (set.contains(map[nx][ny])) {
                result = Math.max(result, depth);
                //continue;
            } else {
                set.add(map[nx][ny]);
                dfs(nx, ny, depth + 1, set);
                set.remove(map[nx][ny]);
            }
        }
    }
}
