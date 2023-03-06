package algorithm.O2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 滑动窗口最大值
 */
public class SlidingWindow {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        //转为数组
        List<Integer> nums = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int M = in.nextInt();
        int res = 0;

        // 双指针 left right
        int left = 0, sum = 0;
        for (int right = 0; right < N; right++) {
            sum += nums.get(right);
            while (left <= right && right - left + 1 >= M) {
                res = Math.max(res, sum);
                sum -= nums.get(left++);
            }
        }
        System.out.println(res);
    }
}
