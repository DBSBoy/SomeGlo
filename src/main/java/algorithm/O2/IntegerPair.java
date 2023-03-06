package algorithm.O2;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 正数对最小和
 */
public class IntegerPair {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        // 数组1
        String[] str1 = in.nextLine().split(" ");
        int m = Integer.parseInt(str1[0]);
        int[] nums1 = new int[m];
        for (int i = 1; i < str1.length; i++) {
            nums1[i - 1] = Integer.parseInt(str1[i]);
        }

        // 数组2
        String[] str2 = in.nextLine().split(" ");
        int n = Integer.parseInt(str2[0]);
        int[] nums2 = new int[n];
        for (int i = 1; i < str2.length; i++) {
            nums2[i - 1] = Integer.parseInt(str2[i]);
        }
        int k = in.nextInt();

        // 组合放入优先队列
        int min = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));

        for (int i = 0; i < Math.min(m, k); i++) {
            queue.add(new int[]{i, 0});
        }
        //构造小顶堆后输出最小值
        while (k > 0 && !queue.isEmpty()) {
            int[] idx = queue.poll();
            min += (nums1[idx[0]] + nums2[idx[1]]);
            if (idx[1] + 1 < n) {
                queue.add(new int[]{idx[0], idx[1] + 1});
            }
            k--;
        }
        System.out.println(min);
    }
}
