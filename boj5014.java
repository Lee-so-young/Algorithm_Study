import java.util.*;

public class boj5014 {
    static int f, s, g, u, d;
    static int visited[];
    static Queue<Integer> q = new LinkedList<Integer>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        f = sc.nextInt();//건물 층수
        s = sc.nextInt();//지금 있는 곳
        g = sc.nextInt();//회사 있는 곳
        u = sc.nextInt();//올라갈 수 있는 층수
        d = sc.nextInt();//내려갈 수 있는 층수
        visited = new int[f + 1];
        q.add(s);
        visited[s] = 1;
        bfs(f, s, g, u, d);
    }

    static void bfs(int f, int s, int g, int u, int d) {


        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == g) {
                System.out.println(visited[now] - 1);
            }

            if (now + u <= f && visited[now + u] == 0) {
                visited[now + u] = visited[now] + 1;
                q.add(now + u);
            }

            if (now - d > 0 && visited[now - d] == 0) {
                visited[now - d] = visited[now] + 1;
                q.add(now - d);
            }
        }

        if (visited[g] == 0)
            System.out.println("use the stairs");
    }
}
