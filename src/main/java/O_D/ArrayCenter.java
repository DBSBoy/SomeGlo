package O_D;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 计算数组中心位置
 */
public class ArrayCenter {


    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            //转为数组
            List<Integer> nums =Arrays.stream(in.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            if (nums.size() == 1) {
                System.out.println(0);
                return;
            }

            //左右乘积子数组
            int[] left_result = new int[nums.size()+1];
            left_result[0] = 1;
            for (int i=1;i<=nums.size();i++) {
                left_result[i] = left_result[i-1]*nums.get(i-1);
            }

            int[] right_result = new int[nums.size()+1];
            right_result[nums.size()] = 1;
            for (int i=nums.size()-1;i>=0;i--) {
                right_result[i] = right_result[i+1]*nums.get(i);
            }

            //找相等位置
            int flag = 0;
            for (int i=1;i<nums.size();i++) {
                if (left_result[i] == right_result[i+1]) {
                    flag = 1;
                    System.out.println(i);
                    break;
                }
            }

            //不存在中心位置
            if (flag == 0) {
                System.out.println(-1);
            }
        }
    }
}
