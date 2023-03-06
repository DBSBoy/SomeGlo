package algorithm.O2;

import java.util.Scanner;

/**
 * 无重复字符的元素长度乘积的最大值
 */
public class NoRepetition {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        String[] words = in.nextLine().split(",");
        int res = 0;
        // 两两暴力遍历
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                char[] word1 = words[i].toCharArray();
                char[] word2 = words[j].toCharArray();
                boolean flag = true;
                // 是否有相同字符
                for (int m = 0; m < word1.length; m++) {
                    for (int n = 0; n < word2.length; n++) {
                        if (word1[m] == word2[n]) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    int Length = word1.length * word2.length;
                    res = Math.max(res, Length);
                }
            }
        }
        System.out.println(res);

    }
}
