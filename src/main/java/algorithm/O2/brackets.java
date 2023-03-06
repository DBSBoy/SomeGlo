package algorithm.O2;
import java.util.Scanner;
import java.util.*;

/**
 * z最大括号
 */
public class brackets {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s = in.nextLine();
        // 空字符串
        if (s.equals("")) {
            System.out.println(0);
            return ;
        }

        //用栈来存放每一个字符
        Stack<Character> char_stack = new Stack<>();
        int i = 0;
        int max = 0;
        for (i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                char_stack.push(c);
                max = Math.max(max, char_stack.size());
            } else {
                if (char_stack.size() == 0) {
                    break;
                }
                if (c == ')') {
                    if (char_stack.pop() == '(') {
                        continue;
                    }
                } else if (c == ']') {
                    if (char_stack.pop() == '[') {
                        continue;
                    }
                } else {
                    if (char_stack.pop() == '{') {
                        continue;
                    }
                }
                break;
            }
        }
        if (i == s.length() && char_stack.size() == 0) {
            System.out.println(max);
        } else {
            System.out.println(0);
        }

    }
}
