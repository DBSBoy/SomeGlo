package O_D;

/**
 * 相同数字的积木游戏
 *
 * 小华和小薇一起通过玩积木游戏学习数学。
 * 他们有很多积木，每个积木块上都有一个数字，积木块上的数字可能相同。
 * 小华随机拿一些积木挨着排成一排，请小薇找到这排积木中数字相同目所处位置最远的2块积木块，计算他们的距离。
 * 小薇请你帮忙替她解决这个问题。
 * 输入描述
 * 第一行输入为N，表示小华排成一排的积大总数。
 * 接下来 N 行每行一个数字，表示小花排成一排的积大上数字。
 * 输出描述
 * 相同数字的积木的位置最远距离;
 * 如果所有积木数字都不相同，请返回 -1
 *
 * 示例1：
 *
 * 输入：
 *
 * 5
 * 1
 * 2
 * 3
 * 1
 * 4
 *
 * 输出：
 *
 * 3
 *
 * 示例2：
 *
 * 输入：
 *
 * 2
 * 1
 * 2
 *
 * 输出：
 *
 * -1
 */
import java.util.Scanner;
import java.util.*;
public class SameNum {
    static class Main {

        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }

            //计算频度超过2的数字
            Map<Integer, Integer> num_count = new HashMap<>();
            for (int i = 0; i < n; i++) {
                num_count.put(nums[i], num_count.getOrDefault(nums[i], 0) + 1);
            }

            Set<Integer> max_num = new HashSet<>();
            for (Map.Entry<Integer, Integer> entry : num_count.entrySet()) {
                if (entry.getValue() >= 2) {
                    max_num.add(entry.getKey());
                }
            }


            //找到最远出现位置
            int result = -1;
            for (Integer i : max_num) {
                int left = 0, right = n - 1;
                while (nums[left] != i) {
                    left++;
                }
                while (nums[right] != i) {
                    right--;
                }
                if (left <= right) {
                    result = Math.max(result, right - left);
                }
            }


            System.out.print(result);

        }

    }
}
