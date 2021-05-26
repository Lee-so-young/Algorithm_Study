import java.io.*;
import java.util.StringTokenizer;

public class boj1080 {

    static int n,m;
    static int a[][],b[][];

    public static boolean flip(int start_a,int start_b) {

        if(start_a+3>n || start_b+3>m)
            return false;

        for(int i=start_a;i<=start_a+2;i++) {
            for(int j=start_b;j<=start_b+2;j++) {
                a[i][j]= 1-(a[i][j]);
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n][m];
        b = new int[n][m];

        for(int i =0;i<n;i++) {
            String row = br.readLine();
            for(int j=0;j<m;j++) {
                a[i][j] =row.charAt(j)-'0';

            }
        }
        for(int i =0;i<n;i++) {
            String row = br.readLine();
            for(int j=0;j<m;j++) {
                b[i][j] =row.charAt(j)-'0';

            }
        }


        int cnt =0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {

                if(a[i][j]!=b[i][j]) {
                    if(flip(i,j)) {
                        cnt++;
                    }else {
                        System.out.println("-1");
                        return;
                    }
                }

            }
        }

        System.out.println(cnt);
        br.close();

    }

}