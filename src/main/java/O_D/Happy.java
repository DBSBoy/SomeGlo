package O_D;

/**
 * 消消乐
 * 给定一个N行M列的二维矩阵，矩阵中每个位置的数字取值为0或1。矩阵示例如：
 * 1100
 * 0001
 * 0011
 * 1111
 * 现需要将矩阵中所有的1进行反转为0，规则如下：
 * 1） 当点击一个1时，该1便被反转为0，同时相邻的上、下、左、右，以及左上、左下、右上、右下8 个方向的1（如果存在1）均会自动反转为0；
 * 2）进一步地，一个位置上的1被反转为0时，与其相邻的8个方向的1（如果存在1）均会自动反转为0；
 *
 * 按照上述规则示例中的矩阵只最少需要点击2次后，所有值均为0。请问，给定一个矩阵，最少需要点击几次后，所有数字均为0？
 * 输入描述：
 *
 * 第一行为两个整数N和M，分别代表矩阵的行数和列数。
 *
 * 接下来的N行为矩阵的初始值，每行M个整数
 *
 * 输出描述：
 *
 * 输出一个整数，表示最少需要点击的次数
 *
 * 示例1：
 *
 * 输入：
 *
 * 3 3
 * 1 0 1
 * 0 1 0
 * 1 0 1
 *
 * 输出：
 *
 * 1
 */
import java.util.Scanner;
import java.util.*;
public class Happy {
    static class Main {
        //  8个方向
        public static final int[][] directions = {
                {-1, -1}, {0, -1}, {1, -1},
                {-1, 0}, {1, 0},{-1, 1}, {0, 1}, {1, 1}
        };

        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] matrix = new int[n][m];
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    matrix[x][y] = in.nextInt();
                }
            }

            int result = 0;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    //从任意一个位置的1开始遍历
                    if (matrix[x][y] == 1) {
                        result++;
                        //用来保存当前翻转的数字位置，以便后续取得其八个方向的数字
                        LinkedList<int[]> flipped = new LinkedList<>();
                        flipped.add(new int[]{x, y});
                        bfs(n, m, matrix, flipped);
                    }
                }
            }
            System.out.println(result);
        }

        public static void bfs(int n, int m, int[][] matrix, LinkedList<int[]> flipped) {
            if (flipped.isEmpty()) {
                return;
            }

            int[] ints = flipped.removeFirst();
            //遍历八个方向的数字，将所有相连的1改为0
            for (int[] d : directions) {
                int newX = ints[0] + d[0];
                int newY = ints[1] + d[1];
                if (newX >= 0 && newX < n &&
                        newY >= 0 && newY < m &&
                        matrix[newX][newY] == 1) {
                    matrix[newX][newY] = 0;
                    flipped.add(new int[]{newX, newY});
                }
            }
            bfs(n, m, matrix, flipped);
        }
    }
}
