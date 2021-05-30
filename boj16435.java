import java.util.*;

public class boj16435 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int snake = sc.nextInt();
        int[] height = new int[n];

        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        Arrays.sort(height);

        for (int i = 0; i < n; i++) {
            if (height[i] <= snake) {
                snake++;
            }
        }
        System.out.println(snake);
    }
}
