package O_D;

/**
 * 最左侧
 *给定两个字符串 s1 和 s2 和正整数k，其中 s1 长度为 n1，s2 长度为 n2，
 * 在s2中选一个子串，满足:
 *
 *     1：该子串长度为n1+k
 *     2：该子串中包含s1中全部字母，
 *     3：该子串每个字母出现次数不小于s1中对应的字母，
 * 我们称s2以长度k冗余覆盖s1，
 * 给定s1，s2，k,
 * 求最左侧的s2以长度k冗余覆盖s1的子串的首个元素的下标，
 * 如果没有返回-1。
 *
 * 输入描述：
 *
 * 输入为三行
 *
 * 第一行为 s1
 *
 * 第二行为 s1
 *
 * 第三行为 k
 *
 * s1和s2都只包含小写字母
 *
 * 输出描述：
 *
 * 最左侧的 s2 以长度 k 冗余覆盖 s1 的子串的首个元素下标，若不存在，则返回-1.
 *
 * 示例1：
 *
 * 输入：
 *
 * ab
 * aabcd
 * 1
 *
 * 输出：
 *
 * 0
 * 示例2：
 *
 * 输入：
 *
 * abc
 * dfs
 * 10
 * 输出：
 *
 * -1
 *
 */
import java.util.Scanner;
import java.util.*;
public class LeftStr {
    static class Main {
        public static int min_num;

        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            int k = in.nextInt();

            //长度限制，不可能存在覆盖子串
            if (s2.length() < s1.length() + k) {
                System.out.println(-1);
                return;
            }

            // 用hashmap来统计每个字符出现的次数
            Map<Character, Integer> s1_char_count = get_char_count(s1);

            for (int i = 0; i < s2.length() - s1.length() - k; i++) {
                String substring = s2.substring(i, i + s1.length() + k);
                //子串的字符出现频率统计
                Map<Character, Integer> sub_str_char_count = get_char_count(substring);
                boolean flag = true;
                for (Character key : s1_char_count .keySet()) {
                    if (s1_char_count .get(key) > sub_str_char_count.getOrDefault(key, 0)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    //输出索引
                    System.out.println(i);
                    return;
                }
            }
            System.out.println(-1);
            return;
        }

        private static Map<Character, Integer> get_char_count(String s1) {
            Map<Character, Integer> char_count = new HashMap<>();
            for (char c : s1.toCharArray()) {
                char_count.put(c, char_count.getOrDefault(c, 0) + 1);
            }
            return char_count;
        }

    }

}
