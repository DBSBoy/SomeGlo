package algorithm.O2;

/**
 * 考古问题
 */
import java.util.Scanner;
import java.util.*;
public class Archaeology {

        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            //注意这里需要多输入一行，否则输入不正确
            in.nextLine();
            String[] char_array = in.nextLine().split(" ");
            List<List<String>> result = new ArrayList<>();

            //先排序
            Arrays.sort(char_array);
            //path中存储已经使用过的数字
            Deque<String> path = new ArrayDeque<>();
            //记录每个数字是否被使用过
            boolean[] used = new boolean[n];
            dfs(char_array, 0, path, used, result);

            for (int i = 0; i < result.size(); i++) {
                System.out.println(String.join("", result.get(i)));
            }

        }
        public static void dfs(String[] char_array, int depth, Deque<String> path, boolean[] used, List<List<String>> result) {
            if (depth == char_array.length) {
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < char_array.length; i++) {
                // 如果使用过，则跳出，剪枝的地方
                if (used[i]) {
                    continue;
                }
                if (i > 0 && char_array[i].equals(char_array[i - 1]) && !used[i - 1]) {
                    continue;
                }
                path.addLast(char_array[i]);
                used[i] = true;
                dfs(char_array, depth + 1, path, used, result);
                path.removeLast();
                used[i] = false;
            }
        }
}
