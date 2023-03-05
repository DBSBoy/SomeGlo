package algorithm.O2;

/**
 * 实力差距最小总和
 *
 * 游戏里面，队伍通过匹配实力相近的对手进行对战。但是如果匹配的队伍实力相差太大，对于双方游戏体验都不会太好。
 * 给定n个队伍的实力值，对其进行两两实力匹配，两支队伍实例差距在允许的最大差距d内，则可以匹配。要求在匹配队伍最多的情况下匹配出的各组实力差距的总和最小。
 *
 * 输入描述
 * 第一行两个整数，n，d。队伍个数n。允许的最大实力差距d。
 * 2<=n <=50
 * 0<=d<=100
 *
 * 第二行，n个整数，表示队伍的实力值，以空格分割。
 * 0<=各队伍实力值<=100
 *
 * 输出描述
 * 输出一个整数，表示各组对战的实力差值的总和。若没有队伍可以匹配，则输出-1。
 *
 * 示例1：输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 6 30
 * 81 87 47 59 81 18
 *
 * 输出
 *
 * 57
 *
 * 示例2：输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 6 20
 * 81 87 47 59 81 18
 *
 * 输出
 *
 * 12
 *
 * 示例3：输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 4 10
 *
 * 40 51 62 73
 *
 * 输出
 *
 * -1
 */
import java.util.Scanner;
import java.util.*;
public class Difference {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            // 处理输入
            int n = in.nextInt();
            int d = in.nextInt();
            int[] teams = new int[n];
            for(int i = 0;i<n;i++){
                teams[i] = in.nextInt();
            }
            // 按照大小排序
            Arrays.sort(teams);

            // 都选左边或者右边（端点额外考虑）
            int sum_d_left = 0;
            int left_pair = 0;
            for (int i = 0; i < n-1; i++) {
                if (teams[i+1] - teams[i] <= d) {
                    sum_d_left += teams[i+1] - teams[i];
                    left_pair +=1;
                }
                i+=1;
            }

            int sum_d_right = 0;
            int right_pair = 0;
            for (int i = 1; i < n-1; i++) {
                if (teams[i+1] - teams[i] <= d) {
                    sum_d_right += teams[i+1] - teams[i];
                    right_pair += 1;
                }
                i+=1;
            }

            if (sum_d_right == 0 && sum_d_left == 0) {
                System.out.println(-1);
            } else {
                if (left_pair > right_pair) {
                    System.out.println(sum_d_left);
                } else if (left_pair < right_pair) {
                    System.out.println(sum_d_right);
                } else {
                    System.out.println(Math.min(sum_d_right, sum_d_left));
                }
            }
        }
    }
}
