import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class kakao_winter2 {
    public int[] solution(String s) {

        String[] temp = s.split("\\{");
        String[] str = new String[temp.length - 2];
        for (int i = 0; i < str.length; i++) {
            str[i] = temp[i + 2].substring(0, temp[i + 2].length() - 2);
        }

        int[] answer = new int[str.length];
        Set<String> set = new HashSet<>();
        Arrays.sort(str, (o1, o2) -> o1.length() - o2.length());

        for (int i = 0; i < str.length; i++) {
            String[] divide = str[i].split(",");
            for (int j = 0; j < divide.length; j++) {
                if (set.contains(divide[j])) continue;
                answer[i] = Integer.parseInt(divide[j]);
                set.add(divide[j]);
            }
        }
        return answer;
    }
}