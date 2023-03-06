package od2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 全排列
 */
public class allSort {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        String input_str = in.nextLine();
        char[] char_array = input_str.toCharArray();
        //先排序
        Arrays.sort(char_array);
        List<Character> path = new ArrayList<Character>();
        // 判断字符是否使用过
        boolean[] used = new boolean[char_array.length];
        List<List<Character>> res = new ArrayList<>();
        dfs(char_array, 0, path, used, res);
        System.out.println(res.size());
    }
    private static void dfs(char[] char_array, int depth, List<Character> path, boolean[] used, List<List<Character>> res) {
        if (depth == char_array.length) {
            res.add(new ArrayList<>(path));
            return ;
        }
        for (int i = 0; i < char_array.length; i++) {
            if (used[i]) {
                continue;
            }
            // 用过了就跳过，重复字符也跳过
            if (i > 0 && char_array[i] == char_array[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(char_array[i]);
            used[i] = true;
            dfs(char_array, depth + 1, path, used, res);
            path.remove(path.size() - 1);
            used[i] = false;
        }

    }
}
