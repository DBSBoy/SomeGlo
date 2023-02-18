package O_D;

/**
 * 上班之路
 * Jungle 生活在美丽的蓝鲸城，大马路都是方方正正，但是每天马路的封闭情况都不一样。地图由以下元素组成:
 * 1)”.” - 空地，可以达到;
 *
 * 2)”*” - 路障，不可达到;
 *
 * 3)"S” - Jungle的家;
 *
 * 4)”T” - 公司.
 * 其中我们会限制Jungle拐弯的次数，同时Jungle可以清除给定个数的路障，现在你的任务是计算Jungle是否可以从家里出发到达公司。
 *
 * 输入描述
 *
 * 输入的第一行为两个整数tc(o<tc<100)t代表可以拐弯的次数，c代表可以清除的路陪个数
 *
 * 输入的第二行为两个整数n,m(1≤n,m≤100),代表地图的大小。
 *
 * 接下来是n行包含m个字符的地图。n和m可能不一样大。
 * 我们保证地图里有S和T。
 *
 * 输出描述
 * 输出是否可以从家里出发到达公司，是则输出YES，不能则输出NO。
 *
 * 示例1：
 *
 * 输入
 * 2 0
 *
 * 5 5
 *
 * ..S..
 * ****.
 *
 * T....
 * ****.
 *
 * .....
 * 输出
 *
 * YES
 *
 * 示例2：
 *
 * 输入
 *
 * 1 2
 *
 * 5 5
 *
 * .*S*.
 * *****
 * ..*..
 *
 * *****
 *
 * T....
 * 输出
 *
 * NO
 */
import java.util.Scanner;
public class GoWork {
    static class Main {
        private static final int[][] directions = {{0, 1, 1}, {0, -1, 2}, {1, 0, 3}, {-1, 0, 4}};
        private static int t, c, n, m;
        private static String[][] matrix;

        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            t = in.nextInt();
            c = in.nextInt();

            n = in.nextInt();
            m = in.nextInt();

            matrix = new String[n][m];
            for (int i = 0; i < n; i++) {
                matrix[i] = in.next().split("");
            }

            //遍历矩阵,找到起点
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    boolean[][] visited = new boolean[m][n];
                    if ("S".equals(matrix[i][j])) {
                        if (dfs(visited, i, j, 0, 0, 0)) {
                            System.out.println("YES");
                            return;
                        } else {
                            System.out.println("NO");
                            return;
                        }
                    }
                }
            }
            System.out.println("NO");
            return;
        }

        public static boolean dfs(boolean[][] visited, int x, int y, int ut, int uc, int last_direct) {
            // 找到目的地
            if ("T".equals(matrix[x][y])) {
                return true;
            }
            //表示当前点已走过
            visited[x][y] = true;

            // 有四个方向选择走下一步
            for (int[] direction : directions) {
                int direct = direction[2];
                int new_x = x + direction[0];
                int new_y = y + direction[1];

                // 转向+破壁标记
                boolean turn_flag = false;
                boolean break_flag = false;

                // 越界 + 是否当前点已访问判断
                if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < m && !visited[new_x][new_y]) {

                    //转向+破壁判断
                    if (last_direct != 0 && last_direct != direct) {
                        // 转向次数已用尽
                        if (ut + 1 > t) {
                            continue;
                        }
                        turn_flag = true;
                    }

                    if ("*".equals(matrix[new_x][new_y])) {
                        // 破壁次数已用尽
                        if (uc + 1 > c) {
                            continue;
                        }
                        break_flag = true;
                    }
                    // 可到达目的地T, 返回true
                    if (dfs(visited, new_x, new_y, ut + (turn_flag ? 1 : 0), uc + (break_flag ? 1 : 0), direct)) {
                        return true;
                    }
                }
            }
            return false;
        }

    }
}
