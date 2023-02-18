package O_D;

/**
 * 统计友好度最大值
 * 工位由序列F1,F2...Fn组成，Fi值为0、1或2。其中0代表空置，1代表有人，2代表障碍物.
 * 1、某一空位的友好度为左右连续老员工数之和.
 * 2、为方便新员工学习求助，优先安排友好度高的空位
 * 给出工位序列，求所有空位中友好度的最大值
 * 输入描述
 * 第一行为工位序列: F1，F2...Fn组成
 * 1<=n<=10000，Fi值为0、1或2。其中0代表空置，1代表有人，2代表障碍物。
 * 输出描述
 * 所有空位中友好度的最大值。如果没有空位，返回0
 *
 * 示例1：
 * 输入
 * 0 1 0
 * 输出
 *
 * 1
 * 说明
 * 第1个位置和第3个位置，友好度均为1.
 *
 * 示例2：
 * 输入
 *
 * 1 1 0 1 2 1 0
 * 输出
 *
 * 3
 * 说明
 * 第3个位置友好度为3。因障碍物隔断，左边得2分，右边只能得1分。
 */
import java.util.Scanner;
import java.util.*;
public class Friendliness {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            Integer[] seats = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

            ArrayList<Integer> left_result_arr = new ArrayList<Integer>();
            Integer left_result = 0;
            for (int i = 0; i < seats.length; i++) {
                if (seats[i] == 0) {
                    left_result_arr.add(left_result);
                    left_result = 0;
                } else if (seats[i] == 1) {
                    left_result +=1;
                } else {
                    left_result =0;
                }
            }

            ArrayList<Integer> right_result_arr = new ArrayList<Integer>();
            Integer right_result = 0;
            for (int i = seats.length - 1; i >= 0; i--) {
                if (seats[i] == 0) {
                    right_result_arr.add(right_result);
                    right_result = 0;
                } else if (seats[i] == 1) {
                    right_result +=1;
                } else {
                    right_result =0;
                }
            }

            int result = 0;
            for (int i = 0; i < left_result_arr.size(); i++) {
                result = Math.max(result, left_result_arr.get(i) + right_result_arr.get(left_result_arr.size()-i-1));
            }
            System.out.println(result);
        }

    }
}
