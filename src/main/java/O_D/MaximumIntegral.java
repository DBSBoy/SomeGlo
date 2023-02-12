package O_D;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 最多积分
 */
public class MaximumIntegral {



    public static class Main {
        public static int max_machine=0;

        public static void main(String[] args) {
            //处理输入
            Scanner in=new Scanner(System.in);
            List<Integer> logs =Arrays.stream(in.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            // 记录到当前秒的总条数
            int sum = 0;

            // 记录到当前秒之前的总条数
            // 每一轮都会减一次
            int pre_sum = 0;

            // 记录到当前秒首次上报要减去的分数
            int n_score = 0;

            // 记录到首次上报的最大得分
            int max_score = 0;
            for (int i=0;i<logs.size();i++) {
                pre_sum = sum;
                sum += logs.get(i);
                // 还有个100条的限制
                if (sum >= 100) {
                    sum = 100;
                    n_score += pre_sum;
                    max_score = Math.max(max_score, sum - n_score);
                    break;
                }
                n_score += pre_sum;
                max_score = Math.max(max_score,  sum - n_score);
            }
            System.out.println(max_score);


        }
    }
}
