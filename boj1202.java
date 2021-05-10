import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Jewelry[] jewel = new Jewelry[n];
        int[] bag = new int[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jewel[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < m; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewel);
        Arrays.sort(bag);

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        long answer = 0;
        int idx = 0;
        for (int i = 0; i < m; i++) {
            while (idx < n && jewel[idx].weight<=bag[i]){
                pq.add(jewel[idx].price);
                idx++;
            }
            if (!pq.isEmpty())
                answer+=pq.poll();
        }
        System.out.println(answer);
    }

    static class Jewelry implements Comparable<Jewelry> {
        int weight;
        int price;

        private Jewelry(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jewelry o) {
            return this.weight - o.weight;
        }
    }
}

