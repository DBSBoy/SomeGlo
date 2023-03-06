package od2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 最远足迹
 */
public class furthest {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        String input_str = in.nextLine();
        char[] char_list = input_str.toCharArray();
        int max = 0;
        String result_str = "(0,0)";
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        // 括号解析
        for (int i = 0; i < char_list.length; i++) {
            if (char_list[i] == '(') {
                left.add(i);
            }
            if (char_list[i] == ')') {
                right.add(i);
            }
        }
        for (int i = 0; i < left.size(); i++) {
            String[] s = input_str.substring(left.get(i) + 1, right.get(i)).split(",");
            // 判断是否非法
            if (s[0].charAt(0) != '0' && s[1].charAt(0) != '0') {
                int num1 = Integer.parseInt(s[0]);
                int num2 = Integer.parseInt(s[1]);
                if (num1 < 1000 && num2 < 1000 && num1 * num1 + num2 * num2 > max) {
                    max = num1 * num1 + num2 * num2;
                    result_str = "(" + s[0] + "," + s[1] + ")";
                }
            }
        }
        System.out.println(result_str);
    }

}
