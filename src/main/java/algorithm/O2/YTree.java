package algorithm.O2;

/**
 * 补种未成活胡杨
 */
import java.util.*;
public class YTree {
    static class Main {
        public static void main(String[] args) {
            // 输入处理
            Scanner in = new Scanner(System.in);
            int N = Integer.parseInt(in.nextLine());
            int M = Integer.parseInt(in.nextLine());

            // 未成活坐标
            String[] dead_pos_str_list = in.nextLine().split(" ");
            int[] dead_pos  = new int[M];
            for (int i = 0; i < M; i++) {
                dead_pos[i] = Integer.parseInt(dead_pos_str_list[i]);
            }

            int K = Integer.parseInt(in.nextLine());

            // 滑动窗口，保证中间有K棵树补种
            int max = 0;
            for (int i = 0; i <= dead_pos.length - K; i++) {
                int left = 0;
                int right = N;
                if (i > 0) {
                    left = dead_pos[i - 1];
                }

                if (i + K < dead_pos.length) {
                    right = dead_pos[i + K] - 1;
                }

                int temp = right - left;
                if (temp > max) {
                    max = temp;
                }
            }

            System.out.println(max);
        }
    }
}
