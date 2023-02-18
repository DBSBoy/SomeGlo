package O_D;

/**
 * 最接最大输出功率的设备 /查找充电设备组合
 * 某个充电站，可提供n个充电设备，每个充电设备均有对应的输出功率。任意个充电设备组合的输出功率总和，均构成功率集合P的1个元素。功率集合P的最优元素，表示最接近充电站最大输出功率P_max的元素
 * 输入描述
 * 输入为3行:
 * 第1行为充电设备个数n
 * 第2行为每个充电设备的输出功率P_i
 * 第3行为充电站最大输出功率P_max
 *
 * 输出描述
 * 功率集合P的最优元素
 * 备注
 * 充电设备个数 n >0
 * 最优元素必须小于或等于充电站最大输出功率P_max
 * 示例1：
 *
 * 输入
 *
 * 4
 * 50 20 20 60
 *
 * 90
 * 输出
 *
 * 90
 * 说明
 * 当充电设备输出功率50、20、20组合时，其输出功率总和为90，最接近充电站最大充电输出功率，因此最优元素为90。
 *
 * 示例2：
 *
 * 2
 * 50 40
 *
 * 30
 * 输出
 * 0
 */
import java.util.Scanner;
import java.util.*;
public class Charger {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            in.nextLine();
            Integer[] p = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            int p_max = in.nextInt();

            //dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少。
            int[][] dp = new int[n + 1][p_max + 1];

            // 初始化, i为0，存放编号0的物品的时候，各个容量的背包所能存放的最大价值。
            for (int j = p_max; j >= p[0]; j--) {
                dp[0][j] = dp[0][j - p[0]] + p[0];
            }

            for (int i = 1; i < n; i++) {  // 遍历物品
                for (int j = 0; j <= p_max; j++) { // 遍历背包容量
                    // 背包容量为j，如果物品i的体积，此时dp[i][j]就是dp[i - 1][j]
                    if (j < p[i]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - p[i]] + p[i]);
                    }
                }
            }

            System.out.println(dp[n-1][p_max]);

        }


    }
}
