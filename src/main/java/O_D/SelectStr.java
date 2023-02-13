package O_D;

/**
 * 挑选字符串
 * 给定a-z，26个英文字母小写字符串组成的字符串A和B，
 * 其中A可能存在重复字母，B不会存在重复字母，现从字符串A中按规则挑选一些字母可以组成字符串B挑选规则如下：
 *         1：同一个位置的字母只能挑选一次，
 *         2：被挑选字母的相对先后顺序不能被改变，
 * 求最多可以同时从A中挑选多少组能组成B的字符串
 * 输入描述
 * 输入为2行，
 * 第一行输入字符串a,第二行输入字符串b，行首行尾没有多余空格
 * 输出描述
 * 输出一行
 * 包含一个数字表示最多可以同时从a中挑选多少组能组成b的字符串，行末没有多余空格
 * 示例一
 * 输入
 *
 * badc
 * bac
 * 输出
 *
 * 1
 */

import java.util.Scanner;
public class SelectStr {
    static class Main {

        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            String a = in.nextLine();
            String b = in.nextLine();
            int count = 0;
            while (true) {
                char[] chars = b.toCharArray();
                int last = 0;
                boolean flag = false;
                //逐个在字符串A中找字符串B的每一个字符,如果找到了，按照规则，这个字符就不能再用，可以直接置一个无效字符。
                for (char single_char : chars) {
                    int index = a.indexOf(single_char, last);
                    //System.out.print(index);
                    last = index;
                    if (index != -1) {
                        a = a.replaceFirst(single_char + "", "_");
                    } else {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
                count++;
            }

            System.out.print(count);
        }

    }
}
