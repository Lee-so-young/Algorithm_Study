import java.util.Scanner;

public class boj14426 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int cnt = 0;

        String[] arr = new String[n];
        for(int i=0; i<n; i++)
            arr[i]=sc.next();

        for(int i=0; i<m; i++){
            String s = sc.next();
            for(int j=0; j<n; j++){
                if(s.equals(arr[j].substring(0,s.length()))){
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
