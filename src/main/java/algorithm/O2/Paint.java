package algorithm.O2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 数字涂色
 */
public class Paint {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            } else {
                for (int j = i; j < n; j++) {
                    if (nums[j] % nums[i] == 0) {
                        used[j] = true;
                    }
                }
                result += 1;
            }
        }
        System.out.println(result);
    }
}
