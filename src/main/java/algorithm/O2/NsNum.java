package algorithm.O2;

/**
 * 最大N个数与最小N个数
 */
import java.util.Scanner;
import java.util.*;
public class NsNum {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            while (in.hasNext()) {
                int m = in.nextInt();
                int[] nums = new int[m];
                for (int i = 0; i < nums.length; i++) {
                    nums[i] = in.nextInt();
                }
                int n = in.nextInt();
                System.out.println(cal(nums, n));
            }
        }

        public static int cal(int[] nums, int n) {
            int res = -1;
            // 去重
            Set<Integer> set = new HashSet<>();
            for (int a : nums) {
                set.add(a);
            }
            if (2 * n > set.size()) {
                return res;
            }

            int count = 0;
            for (Integer s : set) {
                nums[count++] = s;
            }
            // 排序
            Arrays.sort(nums, 0, count);
            res = 0;
            for (int i = 0; i < n; i++) {
                res += nums[i] + nums[count - 1 - i];
            }
            return res;
        }
    }
}
