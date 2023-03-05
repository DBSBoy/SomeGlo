package algorithm.O2;

/**
 * 三角形
 * 有N条线段，长度分别为a[1]-a[n]。
 * 现要求你计算这N条线段最多可以组合成几个直角三角形。
 * 每条线段只能使用一次，每个三角形包含三条线段。
 *
 * 输入描述
 * 第一行输入一个正整数T(1<=T<=100)，表示有T组测试数据.
 * 对于每组测试数据，接下来有T行，
 * 每行第一个正整数N，表示线段个数(3<=N<=20)，接着是N个正整数，表示每条线段长度，(0<a[i]<100)。
 *
 * 输出描述
 * 对于每组测试数据输出一行，每行包括一个整数，表示最多能组合的直角三角形个数
 *
 * 示例1：输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 *
 * 1
 *
 * 7 3 4 5 6 5 12 13
 * 输出
 *
 * 2
 */
import java.util.Scanner;
import java.util.*;
public class Triangle {
    static class Main {
        public static ArrayList<Integer> result = new ArrayList<>();
        public static ArrayList<Integer[]> paths = new ArrayList<>();
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            // 处理输入
            int T = in.nextInt();
            for (int i=0;i<T;i++) {
                int N = in.nextInt();
                int[] nums = new int[N];
                for (int j = 0; j < N; j++) {
                    nums[j] = in.nextInt();
                }

                Arrays.sort(nums);
                dfs(nums, 0, new LinkedList<>());
                int[] count = new int[100];
                for (int num : nums) {
                    count[num]++;
                }
                check(0, count, 0);
                Integer max_res = 0;
                for (Integer x : result) {
                    if (x > max_res) {
                        max_res = x;
                    }

                }

                System.out.println(max_res);
                result = new ArrayList<>();
            }
        }

        public static void dfs(int[] nums, int index, LinkedList<Integer> sides) {
            if (sides.size() == 3) {
                if (sides.get(0)*sides.get(0) + sides.get(1)*sides.get(1)  == sides.get(2)*sides.get(2)){
                    paths.add(sides.toArray(new Integer[3]));
                    return;
                }

            }

            for (int i = index; i < nums.length; i++) {
                if (!(i > 0 && nums[i] == nums[i - 1])){
                    sides.add(nums[i]);
                    dfs(nums, i + 1, sides);
                    sides.removeLast();
                }

            }
        }

        public static void check(int index, int[] count, int num) {
            if (index >= paths.size()) {
                result.add(num);
                return;
            }

            for (int i = index; i < paths.size(); i++) {
                Integer[] single_path = paths.get(i);
                int a = single_path[0];
                int b = single_path[1];
                int c = single_path[2];

                if (count[a] > 0 && count[b] > 0 && count[c] > 0) {
                    count[a]--;
                    count[b]--;
                    count[c]--;
                    num++;
                    check(i + 1, count, num);
                    num--;
                    count[a]++;
                    count[b]++;
                    count[c]++;
                }
            }

            result.add(num);
        }


    }
}
