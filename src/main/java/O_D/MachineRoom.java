package O_D;

/**
 * 机房布局
 * 小明正在规划一个大型数据中心机房，为了使得机柜上的机器都能正常满负荷工作，需要确保在每个机柜边上至少要有一个电箱。
 * 为了简化题目，假设这个机房是一整排，M表示机柜，I表示间隔，请你返回这整排机房，至少需要多少个电箱。如果无解请返回-1。
 * 输入描述
 * 第一行输入一个字符串，由 M 和 I 组成，表示机房的组成样式
 * 输出描述
 * 输出一个整数，表示整排机房至少需要多少个电箱。如果无解请返回-1。
 * 示例1：
 * 输入：
 *
 * MIIM
 * 输出：
 * 2
 */
import java.util.Scanner;
import java.util.*;
public class MachineRoom {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            String input_str = in.nextLine();

            int n = input_str.length();
            LinkedList<Integer> stack = new LinkedList<>();
            boolean flag = false;

            for (int i = 0; i < n; i++) {
                if (input_str.charAt(i) == 'M') {
                    // 无效判断
                    // 1:中间无效
                    if (i - 1 >= 0 && input_str.charAt(i - 1) == 'M' && i + 1 < n && input_str.charAt(i + 1) == 'M') {
                        System.out.println(-1);
                        return;
                    }
                    // 2:两边无效
                    if ((i - 1 == 0 && input_str.charAt(i - 1) == 'M') || (i+1==n && input_str.charAt(i - 1) == 'M')) {
                        System.out.println(-1);
                        return;
                    }


                    // 当前机柜的左右位置
                    int pos_left = Math.max(0, i - 1);
                    int pos_right = Math.min(n - 1, i + 1);

                    if (stack.size() > 0 && !flag) {
                        // 满足 MIM 的样式
                        if (stack.getLast() == pos_left) {
                            stack.removeLast();
                            flag = true;
                        }
                    } else {
                        flag = false;
                    }
                    stack.addLast(pos_right);
                }
            }

            System.out.println(stack.size());


        }


    }
}
