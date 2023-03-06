package algorithm.O2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 高效的任务规划
 */
public class taskPlanning {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        int M = in.nextInt();
        for(int m = 0; m < M; m++) {
            int N = in.nextInt();
            // 让任务工作时间最长的机器先运行
            int last = 0;
            int total_time = 0;

            //保存配置时间和运行时间
            int[][] machine = new int[N][2];
            for (int i = 0; i < N; i++) {
                int B = in.nextInt();
                int J = in.nextInt();
                machine[i][0] = B;
                machine[i][1] = J;
            }
            // 排序
            Arrays.sort(machine, (e1, e2) -> (e2[1] - e1[1]));
            for (int i = 0; i < N; i++) {
                int time  = total_time + machine[i][0] + machine[i][1];
                total_time += machine[i][0];
                total_time = Math.max(total_time, time);
            }
            System.out.println(total_time);
        }

    }
}
