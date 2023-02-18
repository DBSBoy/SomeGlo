package algorithm.O2;

/**
 * 日志限流
 *    某软件系统会在运行过程中持续产生日志，系统每天运行N单位时间，运行期间每单位时间产生的日志条数保行在数组 records中。records[i]表示第i单位时间内产生日志条数。
 * 由于系统磁盘空间限制，每天可记录保存的日志总数上限为total条。
 *
 *         如果一天产生的日志总条数大于total，则需要对当天内每单位时间产生的日志条数进行限流后保存，请计算每单位时间最大可保存日志条数limit，以确保当天保存的总日志条数不超过total。
 *         1：对于单位时间内产生日志条数不超过limit的日志全部记录保存:
 *         2：对于单位时间内产生日志条数超过limit的日志，则只记录保存limit条日志;
 *
 *         如果一天产生的日志条数总和小干等于total，则不需要启动限流机制，result为-1。请返回result的最大值或者-1。
 * 输入描述
 * 第一行为系统某一天运行的单位时间数N.1<=N<=10^5
 * 第二行为表示这一天每单位时间产生的日志数量的数组records，0<= records[i]<= 10^5第三行为系统一天可以保存的总日志条数total。1 <= total <= 10^9
 *
 * 输出描述
 * 每单位时间内最大可保存的日志条数limit，如果不需要启动限流机制，返回-1。
 *
 * 示例1：输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 *
 * 6
 * 3 3 8 7 10 15
 *
 * 40
 * 输出
 *
 * 9
 */
import java.util.Scanner;
import java.util.*;

public class LogLimiting {
    public static class Main {
        public static void main(String[] args) {
            //处理输入
            Scanner in=new Scanner(System.in);
            int N = in.nextInt();
            int[] records = new int[N];
            long single_total = 0;
            for (int i = 0; i < N; i++) {
                records[i] = in.nextInt();
                single_total += records[i];
            }
            int total = in.nextInt();

            // 一天产生的日志总条数小于等于total
            if(single_total <= total) {
                System.out.println(-1);
                return;
            } else {
                Arrays.sort(records);

                //二分法初始化
                int left = total / N;
                int right = records[N - 1];

                int result = left;
                while (right > left+1) {
                    int mid = (right + left) / 2;

                    int temp_total = 0;
                    for (int i=0; i<N; i++){
                        temp_total += Math.min(records[i], mid);
                    }

                    if (temp_total > total) {
                        right = mid;
                    } else if (temp_total < total) {
                        left = mid;
                        result = mid;
                    } else {
                        System.out.println(mid);
                        return;
                    }
                }

                System.out.println(result);
                return;
            }

        }


    }
}
