package O_D;

import java.util.Scanner;
import java.util.*;

class SonArraySum {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        String param_str = in.nextLine();
        int count = Integer.valueOf(param_str);

        //构造输入数据结构,并求和
        int[] nums = new int[count];
        String num_str = in.nextLine();
        int sum = 0;
        String[] num_list = num_str.split(" ");
        for (int i=0;i<count;i++) {
            nums[i] =  Integer.valueOf(num_list[i]);
            sum += Integer.valueOf(num_list[i]);
        }

        // 最大可以等分为m个子数组
        for (int i=count;i>0;i--) {
            //从最大的可能行开始，满足条件即为为最小的情况
            if (canPartitionKSubsets(nums, i, sum)) {
                System.out.println(sum / i);
                break;
            }
        }
    }

    public static boolean canPartitionKSubsets(int[] nums, int k, int all) {
        if (all % k != 0) {
            return false;
        }
        int per = all / k;
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n - 1] > per) {
            return false;
        }
        boolean[] dp = new boolean[1 << n];
        int[] curSum = new int[1 << n];
        dp[0] = true;
        for (int i = 0; i < 1 << n; i++) {
            if (!dp[i]) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (curSum[i] + nums[j] > per) {
                    break;
                }
                if (((i >> j) & 1) == 0) {
                    int next = i | (1 << j);
                    if (!dp[next]) {
                        curSum[next] = (curSum[i] + nums[j]) % per;
                        dp[next] = true;
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}