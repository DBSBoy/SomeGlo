package algorithm.O2;

/**
 * 严格递增字符串
 * 定义字符串完全由，A"和"B"组成，当然也可以全是A"或全是"B”。如果字符串从前往后都是以字典序排列的，那么我们称之为严格递增字符串。
 * 给出一个字符串s，允许修改字符串中的任意字符，即可以将任何的"A"修改成”B'，也可以将任何的"B"修改成”A，求可以使s满足严格递增的最小修改次数。0<s的长度<100000。
 * 输入描述:
 * 输入一个字符串
 * 输出描述:
 * 输出一个整数表示最小修改次数
 * 示例1
 * 输入:
 * AABBA
 * 输出:
 *
 * 1
 *
 * 说明：调整最后的一位A即可
 */
import java.util.Scanner;
public class IncrementalChar {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            String input_str = in.nextLine();

            System.out.println(minFlipsMonoIncr(input_str));
        }
        public static int minFlipsMonoIncr(String s) {
            int n = s.length();
            int dp0 = 0, dp1 = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                int dp0New = dp0, dp1New = Math.min(dp0, dp1);
                if (c == 'B') {
                    dp0New++;
                } else {
                    dp1New++;
                }
                dp0 = dp0New;
                dp1 = dp1New;
            }
            return Math.min(dp0, dp1);
        }

    }
}
