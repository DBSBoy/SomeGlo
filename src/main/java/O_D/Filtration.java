package O_D;

import java.util.Scanner;
import java.util.*;

/**
 * 过滤组合字符串
 * 数字0、1、2、3、4、5、6、7、8、9分别关联 a~z 26个英文字母。
 *
 * 0 关联 "a","b","c"
 *
 * 1 关联 "d","e","f"
 *
 * 2 关联 "g","h","i"
 *
 * 3 关联 "j","k","l"
 *
 * 4 关联 "m","n","o"
 *
 * 5 关联 "p","q","r"
 *
 * 6 关联 "s","t"
 *
 * 7 关联 "u","v"
 *
 * 8 关联 "w","x"
 *
 * 9 关联 "y","z"
 *
 * 例如7关联"u","v"，8关联"x","w"，输入一个字符串例如“78”，
 *
 * 和一个屏蔽字符串“ux”,那么“78”可以组成多个字符串例如：“ux”，“uw”，“vx”，“vw”，过滤这些完全包含屏蔽字符串的每一个字符的字符串，然后输出剩下的字符串。
 *
 * 示例：
 *
 * 输入：
 *
 * 78
 *
 * ux
 *
 * 输出：
 *
 * uw vx vw
 *
 * 说明：ux完全包含屏蔽字符串ux，因此剔除
 */
public class Filtration {


    static class Main {
        public static ArrayList<String> res_str_list;

        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            String num_str = in.nextLine();
            String block_str = in.nextLine();
            //预设值
            HashMap<Character, String> num_char_map = new HashMap<Character, String>();

            num_char_map.put('0', "abc");
            num_char_map.put('1', "def");
            num_char_map.put('2', "ghi");
            num_char_map.put('3', "jkl");
            num_char_map.put('4', "mno");
            num_char_map.put('5', "pqr");
            num_char_map.put('6', "st");
            num_char_map.put('7', "uv");
            num_char_map.put('8', "wx");
            num_char_map.put('9', "yz");

            res_str_list = new ArrayList<String>();
            ArrayList<Character> char_list_temp = new ArrayList<Character>();
            dfs(num_str, char_list_temp, 0, num_char_map);

            int result_count = res_str_list.size();
            for (String x : res_str_list) {
                // 过滤
                if (x.contains(block_str)) {
                    result_count -= 1;
                }
            }

            System.out.println(result_count);
        }

        // 递归求出所有可能的排列组合
        public static void dfs(String num_str, ArrayList<Character> list, int index, HashMap<Character, String> num_char_map) {
            if (index == num_str.length()) {
                String temp_str = "";
                for (int i = 0; i < list.size(); i++) {
                    temp_str = temp_str + list.get(i);
                }
                res_str_list.add(temp_str);
                return;
            }

            for (char single_char : num_char_map.get(num_str.toCharArray()[index]).toCharArray()) {
                list.add(single_char);
                dfs(num_str, list, index + 1, num_char_map);
                list.remove(list.size() - 1);
            }
        }

    }
}
