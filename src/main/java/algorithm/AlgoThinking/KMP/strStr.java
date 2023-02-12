package algorithm.AlgoThinking.KMP;

import java.util.Scanner;

/**
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class strStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pat = sc.nextLine();
        System.out.println("输入："+pat);
        Scanner scn = new Scanner(System.in);
        String txt = scn.nextLine();
        System.out.println("输入："+txt);
        System.out.println(search(pat, txt));
    }
    /**
     * 暴力匹配字符串
     * @param pat 查找的字符串
     * @param txt 原始字符串
     * @return int
     */
    public static int search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        char[] targetChar = pat.toCharArray();
        char[] orginChar  = txt.toCharArray();
        // i + (N-M) <= N,外层for相当于一个窗口
        for (int i = 0; i <= N - M; i++) {
            int j;
            // 第二个for，窗口内字符串匹配
            for (j = 0; j < M; j++) {
                if (targetChar[j]!= orginChar[i+j])
                    break;
            }
            // pat 全都匹配了
            if (j == M) return i;
        }
        // txt 中不存在 pat 子串
        return -1;
    }
}
