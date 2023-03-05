package O_D;

/**
 * 简单的解压缩算法
 * 现需要实现一种算法，能将一组压缩字符串还原成原始字符串，还原规则如下：
 *
 * 1、字符后面加数字N，表示重复字符N次。例如：压缩内容为A3，表示原始字符串为AAA。
 * 2、花括号中的字符串加数字N，表示花括号中的字符重复N次。例如压缩内容为{AB}3，表示原始字符串为ABABAB。
 * 3、字符加N和花括号后面加N，支持任意的嵌套，包括互相嵌套，例如：压缩内容可以{A3B1{C}3}3
 *
 * 输入描述：
 *
 * 输入一行压缩后的字符串
 *
 * 输出描述：
 *
 * 输出压缩前的字符串
 *
 * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * {A3B1{C}3}3
 *
 * 输出
 *
 * AAABCCCAAABCCCAAABCCC
 *
 * 说明
 *
 * {A3B1{C}3}3代表A字符重复3次，B字符重复1次，花括号中的C字符重复3次，最外层花括号中的AAABCCC重复3次。
 */
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
public class Compress {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            //防止最后一个字符是数字
            String input_str = in.nextLine() + " ";
            LinkedList<String> stack = new LinkedList<>();
            // bracket_pos 保存的是所有花括号出现的位置
            LinkedList<Integer> bracket_pos = new LinkedList<>();
            // 保存数字的字符串
            String number_str = "";

            for (int i = 0; i < input_str.length(); i++) {
                char c = input_str.charAt(i);
                //数字
                if (c >= '0' && c <= '9') {
                    number_str += c;
                    continue;
                }

                if (number_str.length() > 0) {
                    int repeat_count = Integer.parseInt(number_str);
                    number_str = "";
                    // 若此时栈顶是 } 字符, 将对应的字母重复repeat_count次
                    if ("}".equals(stack.getLast())) {
                        //获取上一个 { 的位置
                        int pos = bracket_pos.removeLast();
                        //删除左右{}
                        stack.remove(pos);
                        stack.removeLast();
                        // 重复{}之间的字母
                        repeat_operation(stack, pos, repeat_count);
                    } else {
                        //不是 } 字符, 简单重复栈顶字符对应次即可
                        repeat_operation(stack, stack.size() - 1, repeat_count);
                    }
                }

                // { 字符
                if (c == '{') {
                    bracket_pos.add(stack.size());
                }


                // 其他字符 (字母 + })
                stack.add(c + "");
            }

            // 输出
            System.out.println(stack.stream().collect(Collectors.joining()));
        }

        // 重复{}内的字母, 并重新入栈
        public static void repeat_operation(LinkedList<String> stack, int pos, int repeat_count) {
            int count = stack.size() - pos;

            // temp_stack用于存储弹栈数据
            String[] temp_stack = new String[count];

            while (count >= 1) {
                count -= 1;
                temp_stack[count] = stack.removeLast();
            }

            String temp_str = String.join("", temp_stack);
            StringBuilder result = new StringBuilder();
            //重复repeat_count次
            for (int i = 0; i < repeat_count; i++) {
                result.append(temp_str);
            }

            stack.add(result.toString());
        }

    }
}
