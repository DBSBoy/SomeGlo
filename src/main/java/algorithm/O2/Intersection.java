package algorithm.O2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 区间交集
 */
public class Intersection {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);

        List<Integer> nums =Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // 先计算交集
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < nums.size(); i += 2) {
            for (int j = i + 2; j < nums.size(); j += 2) {
                int left = Math.max(nums.get(i), nums.get(j));
                int right = Math.min(nums.get(i + 1), nums.get(j + 1));
                if (left <= right) {
                    res.add(new int[]{left, right});
                }
            }
        }
        // 自定义排序
        int[][] res_array = res.toArray(new int[res.size()][]);
        Arrays.sort(res_array, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        // 求交集的并集
        int[][] result = new int[res_array.length][2];
        int index = -1;
        for (int[] single_array : res_array) {
            if (index == -1 || single_array[0] > result[index][1]) {
                result[++index] = single_array;
            } else {
                result[index][1] = Math.max(result[index][1], single_array[1]);
            }
        }
        int[][] last = Arrays.copyOf(result, index + 1);
        for (int i = 0; i < last.length; i++) {
            System.out.print(last[i][0]);
            System.out.print(" ");
            System.out.print(last[i][1]);
            if (i != last.length - 1) {
                System.out.print(" ");
            }
        }

    }
}
