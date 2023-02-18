package O_D;

/**
 * 组装新的数组
 * 给你一个整数M和数组N，N中的元素为连续整数，要求根据N中的元素组装成新的数组R，组装规则:
 * 1.R中元素总和加起来等于M
 * 2.R中的元素可以从N中重复选取
 * 3.R中的元素最多只能有1个不在N中，且比N中的数字都要小(不能为负数)
 * 输入描述
 * 第一行输入是连续数组N，采用空格分隔第二行输入数字M
 * 输出描述
 * 输出的是组装办法数量，int类型
 *
 * 备注
 * 1≤M≤30
 * 1 ≤ N.length ≤ 1000
 *
 *
 * 示例1
 * 输入
 * 2
 * 5
 *
 * 输出
 *
 * 1
 *
 * 说明
 * 只有1种组装办法，就是[2,2,1]
 *
 * 示例2
 * 输入
 * 2 3
 * 5
 * 输出
 * 2
 */
import java.util.Scanner;
import java.util.*;
public class AssemblyArray {
    static class Main {
        public static int m;
        public static int min_num;
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            Integer[] nums = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            m = in.nextInt();

            //排序找到最小值
            Arrays.sort(nums);
            min_num = nums[0];

            System.out.println(dfs(nums, 0, 0, 0));
        }

        public static int dfs(Integer[] nums, int index, int sum, int count) {
            if (sum > m) {
                return count;
            }

            //满足边界条件+1
            if (sum <= m && m - min_num < sum) {
                return count + 1;
            }

            for (int i = index; i < nums.length; i++) {
                count = dfs(nums, i, sum + nums[i], count);
            }

            return count;
        }

    }
}
