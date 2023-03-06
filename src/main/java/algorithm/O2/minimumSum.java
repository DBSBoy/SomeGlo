package algorithm.O2;

import java.util.Scanner;

/**
 * 求字符串中所有整数的最小和
 */
public class minimumSum {
    public static void main(String[] args) {

        //处理输入
        Scanner in=new Scanner(System.in);
        String input_str= in.nextLine();
        char[] chars = input_str.toCharArray();
        int min_sum = 0;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            //遇到符号，往后取到非数字为止
            if (c == '-') {
                i++;
                int start = i;
                while (i < chars.length && Character.isDigit(chars[i])) {
                    i++;
                }
                String substring = input_str.substring(start, i);
                if (substring.length() > 0) {
                    min_sum -= Integer.parseInt(substring);
                }
                i--;
                continue;
            }
            //否则直接取当前数字
            if (Character.isDigit(c)) {
                min_sum += Character.digit(c, 10);
            }
        }

        System.out.println(min_sum);


    }
}
