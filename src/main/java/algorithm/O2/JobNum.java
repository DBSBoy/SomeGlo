package algorithm.O2;

/**
 * 工号不够用了怎么办
 */
import java.util.Scanner;
import java.util.*;
public class JobNum {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            String input_str = in.nextLine();
            String[] input_list = input_str.split("\\s+");
            long people_num = Long.parseLong(input_list[0]);
            int char_size = Integer.parseInt(input_list[1]);
            double total_char_num = Math.pow(26, (double)char_size);
            int z = 1;
            long total_number = (long)total_char_num * 10;
            while(total_number < people_num){
                z++;
                total_number *= 10;
            }
            System.out.println(z);
        }

    }
}
