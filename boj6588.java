import java.util.*;

public class boj6588 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] check = new boolean[1000001];
        // 소수를 넣어놓는 리스트 (소수의 개수를 정확히는 모르기때문에 리스트로 넣는다.)
        ArrayList<Integer> list = new ArrayList<Integer>();

        // 소수 찾기
        check[0] = check[1] = true;

        for(int i = 2; i < 1000001; i++){
            //소수 찾으면
            if(check[i] == false){
                list.add(i);
                for(int j = i+i; j < 1000001; j+=i)
                    check[j] = true;    //소수가 아니라 표시
            }
        }

        while(true){
            int n = sc.nextInt();
            if(n == 0)
                break;
            // prime(소수)를 하나하나 꺼내면서 n과 뺐을때 소수인지 확인한다.
            for(int i = 0; i < list.size(); i++){
                if(check[n-list.get(i)] == false){
                    System.out.println(n+" = "+list.get(i)+" + "+(n-list.get(i)));
                    break;
                }
                if(i==n)
                    System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }
}