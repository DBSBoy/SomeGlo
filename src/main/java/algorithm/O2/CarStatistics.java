package algorithm.O2;

/**
 * 停车场车辆统计
 */
import java.util.Scanner;
public class CarStatistics {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            String input_str = in.nextLine();
            input_str = input_str.replaceAll(",", "");
            int count = 0;
            // 三种可能性
            String[] sub = {"111", "11", "1"};
            for (String s : sub) {
                int index;
                // 利用java中的indexOf函数
                while ((index = input_str.indexOf(s)) != -1) {
                    input_str = input_str.substring(0, index) + input_str.substring(index + s.length());
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
