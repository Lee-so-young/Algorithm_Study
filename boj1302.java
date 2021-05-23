import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class boj1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            if (!map.containsKey(line))
                map.put(line, 1);
            else
                map.put(line, map.get(line) + 1);
        }

        int max = 0;
        for (String s : map.keySet()) {
            max = Math.max(max, map.get(s));
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (String s : list) {
            if (map.get(s) == max) {
                System.out.println(s);
                break;
            }
        }
    }
}
