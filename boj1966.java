import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1966 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- !=0){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            arr= new int[n];
            st=new StringTokenizer(br.readLine());

            Queue<Integer> queue = new LinkedList<>();

            for(int i=0; i<n; i++){
                arr[i]= Integer.parseInt(st.nextToken());
                queue.offer(i);
            }
            int cnt=0;

            while (true){
                int max = Max();
                int value = queue.poll();
                if(max==arr[value]){
                    cnt++;
                    arr[value]=0;
                    if(m==value){
                        sb.append(cnt).append("\n");
                        break;
                    }
                }
                else
                {
                    queue.offer(value);

                }
            }
        }
        System.out.println(sb);
    }
    public static int Max(){
        int max=0;
        for(int i=0; i<arr.length; i++){
            if(max<arr[i])
                max=arr[i];
        }
        return max;
    }
}