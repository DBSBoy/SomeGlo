package O_D;

/**
 * 水库蓄水
 * 现想在X星一片连绵起伏的山脉间建一个天热蓄水库，如何选取水库边界，使蓄水量最大？
 *
 * 要求：
 *
 *         山脉用正整数数组s表示，每个元素代表山脉的高度。
 *         选取山脉上两个点作为蓄水库的边界，则边界内的区域可以蓄水，蓄水量需排除山脉占用的空间
 *         蓄水量的高度为两边界的最小值。
 *         如果出现多个满足条件的边界，应选取距离最近的一组边界。
 * 输出边界下标（从0开始）和最大蓄水量；如果无法蓄水，则返回0，此时不返回边界。
 * 例如，当山脉为s=[3,1,2]时，则选取s[0]和s[2]作为水库边界，则蓄水量为1，此时输出：0 2:1
 * 当山脉s=[3,2,1]时，不存在合理的边界，此时输出：0。
 *
 * 给定一个长度为 n 的整数数组 height 。数组的元素表示山的高度，选择两个元素作为水库的边界，求蓄水量的最大值并输出蓄水量最大时的边界下标（蓄水量相同时输出下标较近的）。
 *
 * 输入描述：
 *
 * 输入一行数字，空格分隔。
 *
 * 输出描述：
 *
 * 输出蓄水量的最大值及输出蓄水量最大时的边界下标
 *
 * 示例1：
 *
 * 输入：
 *
 * 1 8 6 2 5 4 8 3 7
 *
 * 输出：
 *
 * 1 6:15
 *
 * 说明：蓄水量的最大值为 15
 *
 * 蓄水量最大时的边界下标为1 和 6
 */
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
public class ReservoirFilling {


    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            //转为数组
            List<Integer> height =Arrays.stream(in.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            int l = 0, r = height.size() - 1;

            //用来保存多组一样蓄水大小的情况
            ArrayList<Integer[]> result = new ArrayList<>();

            while (l < r) {
                //找出两个边界较小的那个
                int small = Math.min(height.get(l), height.get(r));

                //求蓄水的总量
                int area = 0;
                for (int i = l; i <= r; i++) {
                    area += Math.max(0, small - height.get(i));
                }

                //保存当前蓄水量及左右边界
                result.add(new Integer[] {l, r, area});


                if (height.get(l) < height.get(r)) {
                    l++;
                }else {
                    r--;
                }
            }

            //先按蓄水量，再按区间大小排序
            result.sort((a, b) -> b[2].equals(a[2]) ? a[1] - a[0] - (b[1] - b[0]) : b[2] - a[2]);

            //不存在合理边界
            if(result.get(0)[2] == 0) {
                System.out.println(0);
                return;
            } else {
                System.out.print(result.get(0)[0]);
                System.out.print(" ");
                System.out.print(result.get(0)[1]);
                System.out.print(":");
                System.out.print(result.get(0)[2]);
            }


        }
    }
}
