import java.io.*;
import java.util.*;

public class boj2493 {
    static class Top{
        long height;
        int position;

        public Top(long height, int position){
            this.height = height;
            this.position = position;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Top> stack = new Stack<Top>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++){
            long a = Long.parseLong(st.nextToken());

            while(!stack.isEmpty()){
                if(stack.peek().height >= a){
                    System.out.print(stack.peek().position + " ");
                    break;
                }
                stack.pop();
            }

            if(stack.isEmpty())
                System.out.print("0 ");
            stack.push(new Top(a, i));
        }
    }
}