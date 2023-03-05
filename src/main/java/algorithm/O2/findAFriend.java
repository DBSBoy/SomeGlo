package algorithm.O2;

import java.util.Scanner;

/**
 * 找朋友
 */
public class findAFriend {
    public static void main(String[] args) {
        // 输入处理
        Scanner in = new Scanner(System.in);
        String input_str = in.nextLine();
        int result = 0;
        int length = 0;
        char last_char = '0';
        for (int i = 0; i < input_str.length(); i++) {
            char c = input_str.charAt(i);
            // 是否非递减
            if (c >= last_char && c <= '9') {
                length++;
                last_char = c;
                result = Math.max(length, result);
            } else if (c >= '0' && c <= '9') {
                length = 1;
                last_char = c;
            } else {  // 如果不是数字
                length = 0;
                last_char = '0';
            }
        }

        System.out.println(result);

    }
}
