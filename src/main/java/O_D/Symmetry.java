package O_D;

/**
 * 对称美学
 * 对称就是最大的美学，现有一道关于对称字符串的美学。
 * 已知：
 * 第1个字符串：R
 *
 * 第2个字符串：BR
 *
 * 第3个字符串：RBBR
 * 第4个字符串：BRRBRBBR
 * 第5个字符串：RBBRBRRBBRRBRBBR相信你已经发现规律了，没错！
 * 就是第i个字符串=第i-1号字符串的取反+第i-1号字符串。取反即(R->B,B->R);
 * 现在告诉你n和k，让你求得第n个字符串的第k个字符是多少。(k的编号从0开始)
 * 输入描述
 * 第一行输入一个T，表示有T组用例：
 * 接下来输入T行，每行输入两个数字，表示n，k1 <= T <= 100;
 * 1 <= n <= 64;
 * 0 <= k < 2^(n-1);
 * 输出描述
 * 输出T行表示答案：
 * 输出blue表示字符是B；输出red表示字符是R；
 * 示例一
 * 输入
 *
 * 5
 * 1 0
 * 2 1
 * 3 2
 * 4 6
 * 5 8
 * 输出
 *
 * red
 * red
 * blue
 * blue
 * blue
 *
 * 说明
 * 第1个字符串：R ->第0个字符为R
 *
 * 第2个字符串：BR ->第1个字符为R
 *
 * 第3个字符串：RBBR ->第2个字符为B
 * 第4个字符串：BRRBRBBR ->第6个字符为B
 * 第5个字符串：RBBRBRRBBRRBRBBR ->第8个字符为B
 * 示例二
 */
import java.util.Scanner;
import java.math.BigInteger;
public class Symmetry {
    static class Main {

        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();
            long[][] cases = new long[t][2];
            for (int i = 0; i < t; i++) {
                cases[i][0] = in.nextLong();
                cases[i][1] = in.nextLong();
            }

            for (int i = 0; i < t; i++) {
                long n = cases[i][0];
                long k = cases[i][1];
                String res = find(n - 1, k) == 'R' ? "red" : "blue";
                System.out.println(res);
            }
        }

        private static char find(long n, long k) {
            if (n == 0) {
                return 'R';
            }
            long len = BigInteger.valueOf(2).pow((int) n).longValue();
            // 如果 k 在后半段，则与前一个字符串相同
            if (k >= len / 2) {
                long pos = k - len / 2;
                return find(n - 1, pos);
            } else {
                // 如果 k 在前半段，则与前一个字符串相反
                return find(n - 1, k) == 'R' ? 'B' : 'R';
            }

        }

    }
}
