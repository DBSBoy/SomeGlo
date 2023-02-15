package O_D;

/**
 * 士兵过河
 * 一支N个士兵的军队正在趁夜色逃亡，途中遇到一条湍急的大河。
 * 敌军在T的时长后到达河面，没到过对岸的士兵都会被消灭。
 * 现在军队只找到了1只小船，这船最多能同时坐上2个士兵。
 *
 * 1）当1个士兵划船过河，用时为 a[i]；0 <= i < N
 * 2）当2个士兵坐船同时划船过河时，用时为max(a[j],a[i])两士兵中用时最长的。
 * 3）当2个士兵坐船1个士兵划船时，用时为 a[i]*10；a[i]为划船士兵用时。
 * 4）如果士兵下河游泳，则会被湍急水流直接带走，算作死亡。
 * 请帮忙给出一种解决方案，保证存活的士兵最多，且过河用时最短。
 *
 * 输入描述：
 *
 * 第一行：N 表示士兵数(0<N<1,000,000)
 * 第二行：T 表示敌军到达时长(0 < T < 100,000,000)
 * 第三行：a[0] a[1] … a[i]… a[N- 1]
 * a[i]表示每个士兵的过河时长。
 * (10 < a[i]< 100; 0<= i< N）
 *
 * 输出描述：
 *
 * 第一行：”最多存活士兵数” “最短用时”
 *
 * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 5
 * 43
 * 12 13 15 20 50
 *
 * 输出
 *
 * 3 40
 */
import java.util.*;
public class SoldiersCrossTheRiver {

    static class Main {
        //二叉树定义
        public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val;}
        }

        public static void main(String[] args) {
            // 输入处理
            Scanner in = new Scanner(System.in);
            int N = in.nextInt();
            int T = in.nextInt();
            in.nextLine();

            Integer[] a = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            Arrays.sort(a);

            int[] dp = new int[N];

            //初始状态 0 和 1
            dp[0] = a[0];
            if (dp[0] > T) {
                System.out.println("0 0");
                return;
            }
            dp[1] = get_shorter_time(a[0], a[1]);
            if (dp[1] > T) {
                System.out.println(1 + " " + dp[0]);
                return;
            }

            //状态转义方程
            for (int i = 2; i < N; i++) {
                dp[i] = Math.min(dp[i - 1] + a[0] + get_shorter_time(a[0], a[i]),
                        dp[i - 2] + a[0] + get_shorter_time(a[i - 1], a[i]) + a[1] + get_shorter_time(a[0], a[1]));

                //耗时超了T立马结束
                if (dp[i] > T) {
                    System.out.println(i + " " + dp[i - 1]);
                    return;
                }
            }

            System.out.println(N + " " + dp[N - 1]);
        }

        //两人过河一个人划船快，还是两个人快
        public static int get_shorter_time(int a, int b) {
            if (a * 10 < b) {
                return a * 10;
            }
            return b;
        }

    }

}
