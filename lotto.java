import java.util.Arrays;

public class lotto {

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        solution(lottos,win_nums);
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero = 0;
        int same = 0;
        int[] grade = {6,6, 5, 4, 3, 2, 1};

        for (int i = 0; i < lottos.length; i++) {
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    same++;
                    break;
                }
                if (lottos[i] == 0) {
                    zero++;
                    break;
                }
            }
        }
        answer[0]=grade[zero+same];
        answer[1]=grade[same];
        System.out.println(answer[0]);
        System.out.println(answer[1]);

        return answer;
    }

}

