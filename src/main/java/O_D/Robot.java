package O_D;

/**
 * 机器人
 * 现有一个机器人，可放置于M×N的网格中任意位置，
 * 每个网格包含一个非负整数编号，
 * 当相邻网格的数字编号差值的绝对值小于等于1时，机器人可以在网格间移动
 * 问题：求机器人可活动的最大范围对应的网格点数目。说明：
 * .网格左上角坐标为(0,0),右下角坐标为(m−1,n−1)
 * .机器人只能在相邻网格间上下左右移动
 * 输入描述
 * 第1行输入为M和N，M表示网格的行数N表示网格的列数之后M行表示网格数值，每行N个数值（数值大小用k表示），数值间用单个空格分隔，行首行尾无多余空格M、N、k均为整数，且1≤M,N≤150，0≤k≤50
 * 输出描述
 * 输出1行，包含1个数字，表示最大活动区域的网格点数目行首行尾无多余空格
 * 示例一
 * 输入
 *
 * 4 4
 * 1 2 5 2
 * 2 4 4 5
 * 3 5 7 1
 * 4 6 2 4
 * 输出
 *
 * 6
 */
import java.util.Scanner;
public class Robot {
    static class Main {
        private static final int[][] dic = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        private static int k = 1;

        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int m = in.nextInt();
            int n = in.nextInt();
            int[][] matrix = new int[m][n];
            for (int x = 0; x < matrix.length; x++) {
                for (int y = 0; y < matrix[x].length; y++) {
                    matrix[x][y] = in.nextInt();
                }
            }

            // 起点可以是每一个位置
            int result = 0;
            for (int x = 0; x < matrix.length; x++) {
                for (int y = 0; y < matrix[x].length; y++) {
                    boolean[][] visited = new boolean[m][n];
                    k = 1;
                    bfs(matrix, visited, x, y);
                    result = Math.max(k, result);
                }
            }
            System.out.print(result);

        }

        public static void bfs(int[][] matrix, boolean[][] visited, int x, int y) {
            visited[x][y] = true;
            //四个方向查看是否可行
            for (int[] d : dic) {
                int newX = x + d[0], newY = y + d[1];
                if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length) {
                    if (!visited[newX][newY] && Math.abs(matrix[x][y] - matrix[newX][newY]) <= 1) {
                        k++;
                        bfs(matrix, visited, newX, newY);
                    }
                }
            }
        }

    }
}
