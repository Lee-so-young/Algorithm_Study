import java.io.*;
import java.util.*;

public class boj16947 {

    public static int size;
    public static ArrayList<Integer>[] arr;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        size = Integer.parseInt(br.readLine());
        arr = new ArrayList[size+1];
        int[] check = new int[size+1];

        for(int i=1; i<=size; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=1; i<=size; i++){
            String[] str = br.readLine().split(" ");
            int from = Integer.parseInt(str[0]);
            int to = Integer.parseInt(str[1]);
            arr[from].add(to);
            arr[to].add(from);
        }

        dfs(1, -1, check, 1);

        int[] answer = new int[size+1];
        for(int i=1; i<=size; i++){
            if(arr[i].size() >= 3 && check[i] != 0){
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while(!q.isEmpty()){
                    int n = q.remove();
                    for(int c : arr[n]){
                        if(check[c] != 0 || answer[c] != 0)
                            continue;
                        q.add(c);
                        answer[c] = answer[n] + 1;
                    }
                }
            }
        }
        for(int i=1; i<=size; i++){
            bw.write(answer[i]+" ");
        }
        bw.flush();
        bw.close();
    }

    public static boolean dfs(int city, int from, int[] check, int cnt){
        if(check[city] != 0){
            for(int i=1; i<=size; i++){
                if(check[i]<check[city]) {
                    check[i] = 0;
                }
            }
            return true;
        }

        for(int c : arr[city]){
            if(c == from)
                continue;
            check[city] = cnt;
            if(dfs(c, city, check,cnt+1))
                return true;
            check[city] = 0;
        }
        return false;
    }
}