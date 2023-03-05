package algorithm.O2;

/**
 * 计算堆栈中的剩余数字
 */
import java.util.Scanner;
import java.util.*;
public class ResidualFigure {
    static class Main {
        public static Stack<Integer> num_stack = new Stack<>();

        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            String line = in.nextLine();

            //解析为int数组
            String[] nums_str_list = line.split(" ");
            int[] nums = new int[nums_str_list.length];
            for (int i = 0; i < nums_str_list.length; i++) {
                nums[i] = Integer.parseInt(nums_str_list[i]);
            }

            // 模拟入栈过程
            for (int i = 0; i < nums.length; i++) {
                push_attempt(nums[i]);
            }

            String result = "";
            while (!num_stack.empty()) {
                result += num_stack.pop() + " ";
            }
            System.out.println(result.trim());
        }

        //自定义入栈过程
        public static void push_attempt(int num) {
            int temp = 0;
            for (int i = num_stack.size() - 1; i >= 0; i--) {
                temp += num_stack.get(i);
                if (temp == num) {
                    int stackSize = num_stack.size();
                    for (int j = i; j < stackSize; j++) {
                        num_stack.pop();
                    }
                    push_attempt(temp * 2);
                    return;
                } else if (temp > num) {
                    break;
                }
            }
            num_stack.push(num);
        }
    }
}
