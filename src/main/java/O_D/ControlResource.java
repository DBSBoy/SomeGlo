package O_D;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 最大化控制资源
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
