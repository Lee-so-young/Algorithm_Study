import java.util.Scanner;

public class boj2606 {

    static int com;
    static int num;
    static int map[][];
    static boolean visited[];
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        com = sc.nextInt();
        num = sc.nextInt();

        map = new int[com + 1][com + 1];
        visited = new boolean[com + 1];

        for (int i = 0; i < num; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = map[b][a] = 1;
        }
        dfs(1);
        System.out.println(cnt);
    }

    static void dfs(int start) {
        visited[start]=true;

        for(int i=1; i<=com; i++){
            if(map[start][i]==1 && visited[i]==false){
                cnt++;
                dfs(i);
            }
        }
    }
}
