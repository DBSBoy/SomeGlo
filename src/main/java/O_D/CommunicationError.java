package O_D;

/**
 * 通信误码
 * 信号传播过程中会出现一些误码，不同的数字表示不同的误码ID，取值范围为1~65535，用一个数组记录误码出现的情况，
 * 每个误码出现的次数代表误码频度，请找出记录中包含频度最高误码的最小子数组长度。
 *
 * 输入描述
 *
 * 误码总数目：取值范围为0~255，取值为0表示没有误码的情况。
 * 误码出现频率数组：误码ID范围为1~65535，数组长度为1~1000。
 *
 * 输出描述
 *
 * 包含频率最高的误码最小子数组长度
 *
 * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 5
 *
 * 1 2 2 4 1
 *
 * 输出
 *
 * 2
 *
 * 说明
 *
 * 频度最高的有1和2，他们的频度均为2.
 *
 * 可能的记录数组为[2,2]和 [1,2,2,4,1]
 *
 * 最短的长度为2.
 *
 * 示例2 输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 7
 * 1 2 2 4 2 1 1
 *
 * 输出
 *
 * 4
 */
import java.util.Scanner;
import java.util.*;
public class CommunicationError {

    static class Main {

        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }

            //计算频度最高的数字
            int max_count = 0;
            Map<Integer, Integer> num_count = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int count = num_count.getOrDefault(nums[i], 0) + 1;
                max_count = Math.max(max_count, count);
                num_count.put(nums[i], count);
            }

            Set<Integer> max_num = new HashSet<>();
            for (Map.Entry<Integer, Integer> entry : num_count.entrySet()) {
                if (entry.getValue() == max_count) {
                    max_num.add(entry.getKey());
                }
            }


            //找到第一次和最后一次出现位置
            int result = n;
            for (Integer i : max_num) {
                int left = 0, right = n - 1;
                while (nums[left] != i) {
                    left++;
                }
                while (nums[right] != i) {
                    right--;
                }
                if (left <= right) {
                    result = Math.min(result, right - left + 1);
                }
            }


            System.out.print(result);

        }

    }
}
