package O_D;

import java.util.Scanner;
import java.util.*;

/**
 * 输入一个长度为4的倍数的字符串，字符串中仅包含WASD四个字母。
 *
 * 将这个字符串中的连续子串用同等长度的仅包含WASD的字符串替换，如果替换后整个字符串中WASD四个字母出现的频数相同，那么我们称替换后的字符串是“完美走位”。
 *
 * 求子串的最小长度。
 *
 * 如果输入字符串已经平衡则输出0。
 *
 * 二、输入
 * 一行字符表示给定的字符串s
 *
 * 数据范围：
 * 1<=n<=10^5且n是4的倍数，字符串中仅包含WASD四个字母。
 *
 * 三、输出
 * 一个整数表示答案
 *
 * 四、样例输入输出
 *
 * 示例1：
 *
 * 输入：
 * WASDAASD
 *
 * 输出：
 * 1
 *
 * 说明：
 * 将第二个A替换为W，即可得到完美走位 。
 *
 * 示例2：
 *
 * 输入：
 * AAAA
 *
 * 输出：
 * 3
 */
public class Perfect {


    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            String input_str = in.nextLine();
            //预设值
            Map<Character, Integer> char_count = new HashMap<Character, Integer>();

            //遍历字符串
            for (int i = 0; i < input_str.length(); i++) {
                char key = input_str.charAt(i);

                if (char_count.get(key) == null) {
                    char_count.put(key, 1);
                } else {
                    char_count.put(key, char_count.get(key) + 1);
                }
            }

            //遍历WASD,防止输入没有这三个字符
            for (int i = 0; i < "WASD".length(); i++) {
                char key = "WASD".charAt(i);

                if (char_count.get(key) == null) {
                    char_count.put(key, 0);
                }
            }


            // 特殊情况
            if (char_count.get('W') == char_count.get('A') &&
                    char_count.get('W') == char_count.get('S') &&
                    char_count.get('W') == char_count.get('D')) {
                System.out.println(0);
                return;
            }

            // 左右区间位置
            int left = 0;
            int right = 0;
            int length = 0;

            // 替换的最小长度
            int res = input_str.length();
            // 出现次数最多的字母
            int max_char_num = 0;
            // 可替换字母个数, 随着指针移动，如果free_char_num 大于0且能被4整除，当前范围满足条件，左指针右移一格，否则右指针右移
            int free_char_num = 0;

            char_count.put(input_str.charAt(0), char_count.get(input_str.charAt(0)) - 1);
            while (true) {
                max_char_num = Math.max(Math.max((Math.max(char_count.get('W'), char_count.get('S'))), char_count.get('A')), char_count.get('D'));
                length = right - left + 1;
                free_char_num = length - ((max_char_num - char_count.get('W')) + (max_char_num - char_count.get('S')) + (max_char_num - char_count.get('A')) + (max_char_num - char_count.get('D')));
                if (free_char_num >= 0 && free_char_num % 4 == 0) {
                    if (length < res) {
                        res = length;
                    }
                    char_count.put(input_str.charAt(left), char_count.get(input_str.charAt(left)) + 1);
                    left++;

                } else {
                    right++;
                    char_count.put(input_str.charAt(right), char_count.get(input_str.charAt(right)) - 1);
                }

                if (right >= input_str.length() - 1)// 越界即结束
                    break;
            }

            System.out.println(res);
        }
    }
}
