package algorithm.O2;

/**
 * 单词重量
 */
import java.util.*;
import java.text.DecimalFormat;
public class WordWeight {
    static class Main {
        public static void main(String[] args) {
            // 输入处理
            Scanner in = new Scanner(System.in);
            String input_str = in.nextLine();
            String[] strs =input_str.split(" ");

            // 注意要定义成double 哦
            double total_num = 0.0;
            for (String x : strs) {
                total_num += x.length();
            }

            // 保留两位小数
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.println(df.format((total_num / strs.length)));
        }
    }
}
