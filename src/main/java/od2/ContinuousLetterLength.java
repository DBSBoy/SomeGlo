package od2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 连续字母长度
 */
public class ContinuousLetterLength {
    public static void main(String[] args) {
        //处理输入
        Scanner in = new Scanner(System.in);

        String input_str = in.nextLine().trim();
        int k = Integer.parseInt(in.nextLine().trim());
        int index = 0;

        //出现次数统计
        HashMap<Character, Integer> char_count_map = new HashMap<>();
        while (index < input_str.length()) {
            char c = input_str.charAt(index);
            int count = 1;
            while (index < input_str.length() - 1 && input_str.charAt(index + 1) == input_str.charAt(index)) {
                count++;
                index++;
            }
            if (!char_count_map.containsKey(c)) {
                char_count_map.put(c, count);
            } else {
                if (char_count_map.get(c) < count) {
                    char_count_map.put(c, count);
                }
            }
            index++;
        }

        //排序取最长
        List<Character> chars = new ArrayList<>(char_count_map.keySet());
        chars.sort((c1, c2) -> {
            return char_count_map.get(c2) - char_count_map.get(c1);
        });
        if (k > chars.size() || chars.size() == 0 || k <= 0) {
            System.out.println(-1);
        } else {
            System.out.println(char_count_map.get(chars.get(k - 1)));
        }
    }

}
