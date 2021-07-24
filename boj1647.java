import java.util.PriorityQueue;
import java.util.Scanner;

//https://moonsbeen.tistory.com/145
public class boj1647 {
    static int n, m;
    static PriorityQueue<Node> pq;
    static int[] parent;

    public static class Node implements Comparable<Node> {
        int start;
        int end;
        int cost;

        Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n1) {
            return this.cost - n1.cost;
        }
    }


    public static int kruskal() {
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int cnt = 0;
        int sum = 0; //현재 까지의 최소 간선 경로 값의 합
        while (cnt < n - 2) { // n - 2개의 간선을 선택한다.
            Node node = pq.poll();
            int p1 = find(node.start);
            int p2 = find(node.end);

            if (p1 != p2) {
                union(p1, p2);
                sum += node.cost;
                cnt++; // 싸이클이 발생되지 않아 최소 간선으로 선택된 경우에만 count++를 해준다.
            }
        }
        return sum;
    }

    public static void union(int a, int b) {

        a=find(a);
        b=find(b);

        parent[a] = b;
    }

    public static int find(int a) {
        if (parent[a] == a)
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        pq = new PriorityQueue<>();
        parent = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();

            pq.add(new Node(start, end, cost));
        }

        System.out.println(kruskal());
    }
}
