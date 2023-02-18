package O_D;

/**
 * 最大连续文件之和 / 区块链文件转储系统
 * 区块链底层存储是一个链式文件系统，由顺序的N个文件组成，每个文件的大小不一，依次为F1.F2...Fn。随着时间的推移，所占存储会越来越大。
 * 云平台考虑将区块链按文件转储到廉价的SATA盘，只有连续的区块链文件才能转储到SATA盘上，且转的文件之和不能超过SATA盘的容量。
 * 假设每块SATA盘容量为M，求能转储的最大连续文件之和。
 * 输入描述
 * 第一行为SATA盘容量M，1000 <= M <= 1000000
 * 第二行为区块链文件大小序列F1,F2,...,Fn。其中 1<= n <=100000，1<= Fis <= 500
 * 输出描述
 * 求能转储的最大连续文件大小之和
 *
 * 示例1：
 *
 * 输入
 *
 * 1000
 * 100 300 500 400 400 150 100
 * 输出
 * 950
 * 说明
 * 最大序列和为950，序列为[400,400,150]
 *
 * 示例2：
 *
 * 输入：
 * 1000
 * 100 500 400 150 500 100
 *
 * 输出：
 * 1000
 *
 * 说明：
 * 最大序列和为1000，序列为[100,500,400]
 */
import java.util.Scanner;
import java.util.*;
public class Blockchain {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int M =in.nextInt();
            in.nextLine();
            Integer[] F = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

            // 窗口左右边界
            int left = 0, right = 0;
            //窗口和
            int window_sum = 0;
            //最大窗口和
            int window_max = 0;

            while (right < F.length) {
                int temp = window_sum + F[right];

                // 窗口内总和大了，sum减去左边界，左端边界+1
                if (temp > M) {
                    window_sum -= F[left];
                    left += 1;
                }
                // 窗口内总和小了，右边界+1，sum加上右边界
                else if (temp < M) {
                    window_sum += F[right];
                    window_max = Math.max(window_sum, window_max);
                    right += 1;
                }
                // 窗口内总和==M，直接return
                else {
                    System.out.println(M);
                    return;
                }
            }

            System.out.println(window_max);
        }

    }
}
