package algorithm.O2;

import java.util.Scanner;
import java.util.Stack;

/**
 * 报文解压缩
 */
public class Message {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        //初始化一个栈
        Stack<Character> stack = new Stack<>();
        String resStr = "";
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ']') {
                // 解压缩
                String tmpStr = "";
                while(!stack.isEmpty()) {
                    char pop_char = stack.pop();
                    //小写字母
                    if (pop_char >= 'a' && pop_char <= 'z') {
                        tmpStr = String.valueOf(pop_char) + tmpStr;
                        //数字
                    } else if (Character.isDigit(pop_char)) {
                        int num = 0;
                        if (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                            num = (stack.pop() - '0') * 10 + (pop_char - '0');
                        } else {
                            num = pop_char - '0';
                        }
                        String waitStr = tmpStr;
                        for (int j = 0; j < num - 1; j++) {
                            tmpStr += waitStr;
                        }
                    }
                }
                resStr += tmpStr;
            }
            stack.push(ch[i]);
        }
        System.out.println(resStr);
    }

}
