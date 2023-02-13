package O_D;

/**
 * 箱子之字形摆放
 * 输入描述
 *
 * 输入一行字符串，通过空格分隔，前面部分为字母或数字组成的字符串str，表示箱子；
 * 后面部分为数字n，表示空地的宽度。例如：
 * ABCDEFG 3
 *
 * 备注：
 *
 * .请不要再最后一行输出额外的空行
 * .str只包含字母和数字，1 <= len(str) <= 1000
 * .1 <= n <= 1000
 */
import java.util.Scanner;
import java.util.*;
public class Box {


    static class Main {

        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            String input_str = in.nextLine();
            String[] split = input_str.split(" ");
            String str = split[0];
            int n = Integer.parseInt(split[1]);

            // 将n行格子看作是n个数组
            List<List<Character>> lists = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                lists.add(new ArrayList<>());
            }
            int index = 0;
            // 控制下一个字符归属到哪个数组
            boolean flag = true;

            char[] chars = str.toCharArray();
            for (char c : chars) {
                if (index == -1) {
                    index = 0;
                    flag = true;
                }
                if (index == n) {
                    index = n - 1;
                    flag = false;
                }
                lists.get(index).add(c);

                if (flag) {
                    index++;
                } else {
                    index--;
                }
            }


            for (List<Character> list : lists) {
                for (Character c : list) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }

    }
}
