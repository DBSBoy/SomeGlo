package od2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 完全二叉树非叶子部分后序遍历
 */
public class BinaryTree {
    public static void main(String[] args) {
        //处理输入
        Scanner in = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> index = new ArrayList<>();
        dfs(nums, 0, index);
        nums.removeAll(index);
        List<String> ans = new ArrayList<>();
        //后序遍历输出
        post_order(nums, 0, ans);
        System.out.print(String.join(" ", ans));

    }

    private static void dfs(List<Integer> nums, int idx, List<Integer> index) {
        if (idx >= nums.size()) {
            return;
        }
        if ((2 * idx + 1 >= nums.size()) && (2 * idx + 2 >= nums.size())) {
            index.add(nums.get(idx));
        } else {
            dfs(nums, 2 * idx + 1, index);
            dfs(nums, 2 * idx + 2, index);
        }
    }

    private static void post_order(List<Integer> nums, int idx, List<String> p) {
        if (idx >= nums.size()) {
            return;
        }
        post_order(nums, 2 * idx + 1, p);
        post_order(nums, 2 * idx + 2, p);
        p.add(String.valueOf(nums.get(idx)));
    }
}
