package O_D;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 计算数组中心位置
 * 给你一个整数数组nums，请计算数组的中心位置，数组的中心位置是数组的一个下标，
 *
 * 其左侧所有元素相乘的积等于右侧所有元素相乘的积。数组第一个元素的左侧积为1，最后一个元素的右侧积为1。
 *
 * 如果数组有多个中心位置，应该返回最靠近左边的那一个，如果数组不存在中心位置，返回-1。
 *
 * 输入描述
 *
 * 输入只有一行，给出N个正整数用空格分隔：nums = 2 5 3 6 5 6
 *
 * 1 <= nums.length <= 1024
 *
 * 1 <= nums[i] <= 10
 *
 * 输出描述
 *
 * 输出
 *
 * 3
 *
 * 解释：中心位置是3
 *
 * 示例1  输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 2 5 3 6 5 6
 *
 * 输出
 *
 * 3
 */
public class ArrayCenter {


    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            //转为数组
            List<Integer> nums =Arrays.stream(in.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            if (nums.size() == 1) {
                System.out.println(0);
                return;
            }

            //左右乘积子数组
            int[] left_result = new int[nums.size()+1];
            left_result[0] = 1;
            for (int i=1;i<=nums.size();i++) {
                left_result[i] = left_result[i-1]*nums.get(i-1);
            }

            int[] right_result = new int[nums.size()+1];
            right_result[nums.size()] = 1;
            for (int i=nums.size()-1;i>=0;i--) {
                right_result[i] = right_result[i+1]*nums.get(i);
            }

            //找相等位置
            int flag = 0;
            for (int i=1;i<nums.size();i++) {
                if (left_result[i] == right_result[i+1]) {
                    flag = 1;
                    System.out.println(i);
                    break;
                }
            }

            //不存在中心位置
            if (flag == 0) {
                System.out.println(-1);
            }
        }
    }
}
