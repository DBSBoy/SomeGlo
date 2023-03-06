package od2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最小数字
 */
public class smallestNum {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        String[] input_str = in.nextLine().split(",");
        if (input_str.length == 1) {
            System.out.println(input_str[0]);
        } else if (input_str.length == 2) {
            int num1 = Integer.parseInt(input_str[0] + input_str[1]);
            int num2 = Integer.parseInt(input_str[1] + input_str[0]);
            System.out.println(num1 < num2 ? num1 : num2);
            // 长度大于3才需要排序处理
        } else {
            Arrays.sort(input_str, (e1, e2) -> Integer.parseInt(e1) - Integer.parseInt(e2));
            String[] min_strs = Arrays.copyOf(input_str, 3);
            // 直接用string的compareTo函数即可
            Arrays.sort(min_strs, ((o1, o2) -> (o1 + o2).compareTo(o2 + o1)));
            String res = "";
            for (String s : min_strs) {
                res += s;
            }
            System.out.println(res);
        }

    }
}
