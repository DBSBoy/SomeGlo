package O_D;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 最大化控制资源
 * 公司创新实验室正在研究如何最小化资源成本，最大化资源利用率，请你设计算法帮他们解决一个任务混部问题：有taskNum项任务，每个任务有开始时间（startTime），结束时间（endTime）,并行度（parallelism）三个属性，并行度是指这个任务运行时将会占用的服务器数量，一个服务器在每个时刻可以被任意任务使用但最多被一个任务占用，任务运行完成立即释放（结束时刻不占用）。任务混部问题是指给定一批任务，让这批任务由同一批服务器承载运行，请你计算完成这批任务混部最少需要多少服务器，从而最大最大化控制资源成本。
 *
 * 输入描述：
 * 第一行输入为taskNum，表示有taskNum项任务
 * 接下来taskNum行，每行三个整数，表示每个任务的开始时间
 * （startTime ），结束时间（endTime ），并行度（parallelism）
 *
 * 输出描述：
 * 一个整数，表示最少需要的服务器数量
 *
 * 示例1 输入输出示例仅供调试，后台判断数据一般不包含示例
 * 输入
 * 3
 * 2 3 1
 * 6 9 2
 * 0 5 1
 * 输出
 *
 * 2
 */
public class ControlResource {
    public static void main(String[] args) {
        // 输入处理
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[][] ranges = new Integer[n][3];
        for (int i = 0; i < n; i++) {
            ranges[i][0] = in.nextInt();
            ranges[i][1] = in.nextInt();
            ranges[i][2] = in.nextInt();
        }

        // 区间排序
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);

        HashSet<Integer> points = new HashSet<>();
        for (Integer[] se : ranges) {
            points.add(se[0]);
            points.add(se[1]);
        }

        // 点排序
        Integer[] points_arr = points.toArray(new Integer[0]);
        Arrays.sort(points_arr, (a, b) -> a - b);

        int result = 0;
        HashSet<Integer> ignore = new HashSet<>();

        //遍历每一个点
        for (Integer point : points_arr) {
            int current_count = 0;
            // 判断这个点是否在此区间内
            for (int i = 0; i < ranges.length; i++) {
                if (ignore.contains(i)){
                    continue;
                }

                if (point < ranges[i][0]){
                    break;
                }
                else if (point < ranges[i][1]){
                    current_count += ranges[i][2];
                }
                else{
                    ignore.add(i);
                }
            }

            result = Math.max(result, current_count);
        }
        System.out.println(result);
    }
}
