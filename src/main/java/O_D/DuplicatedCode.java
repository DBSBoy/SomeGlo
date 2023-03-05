package O_D;

/**
 * 重复代码
 * 小明负责维护项目下的代码，需要查找出重复代码，用以支撑后续的代码优化，请你帮助小明找出重复的代码。重复代码查找方法:以字符串形式给出两行代码(字符审长度1< length < 100，由英文字母、数字和空格组成)，找出两行代码中的最长公共子串
 * 注:如果不存在公共子串，返回空字符串
 * 输入描述
 * 输入的参数 text1，text2 分别表示两行代码
 * 输出描述
 * 输出任一最长公共子串
 * 示例一
 * 输入
 * hello123world1
 * hello123abc4
 * 输出
 * hello123
 */
import java.util.Scanner;
public class DuplicatedCode {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            char[] s1 = str1.toCharArray();
            char[] s2 = str2.toCharArray();
            int[][] dp = new int[s1.length + 1][s2.length + 1];
            int maxLen = 0;
            int lastPos = 0;
            for (int i = 0; i < s1.length; i++) {
                for (int j = 0; j < s2.length; j++) {
                    if (s1[i] == s2[j]) {
                        dp[i + 1][j + 1] = dp[i][j] + 1;
                        //如果有更长的公共子串，更新长度
                        if (dp[i + 1][j + 1] > maxLen) {
                            maxLen = dp[i + 1][j + 1];
                            lastPos = i;
                        }
                    }
                }
            }
            if (maxLen == 0) {
                System.out.println("");
            } else {
                System.out.println(str1.substring(lastPos - maxLen + 1, lastPos + 1));
            }
        }
    }
}
