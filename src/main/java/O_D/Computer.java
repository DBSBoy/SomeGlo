package O_D;

/**
 * 计算网络信号
 * 网络信号经过传递会逐层衰减，且遇到阻隔物无法直接穿透，在此情况下需要计算某个位置的网络信号值。注意:网络信号可以绕过阻隔物
 *
 *  array[m][n] 的二维数组代表网格地图
 * array[i][j]=0代表i行j列是空旷位置;
 * array[i][j]=x(x为正整数)代表i行j列是信号源，信号强度是x;
 * array[i][j]=-1代表i行j列是阻隔物.
 * 信号源只有1个，阻隔物可能有0个或多个
 * 网络信号衰减是上下左右相邻的网格衰减 1
 * 现要求输出对应位置的网络信号值。
 *
 * 输入描述
 *
 * 输入为三行，第一行为 m、n，代表输入是一个mxn的数组。第二行是一串 m xn 如个用空格分隔的整数
 * 每连续n个数代表一行，再往后 n个代表下一行，以此类推。对应的值代表对应的网格是空矿位置，还是信号源，还是阻隔物。第三行是i、j，代表需要计算 array[i][j]的网络信号值。
 *
 * 注意:此处i和j均从 0 开始，即第一行i 为 0
 *
 * 输出描述
 * 输出对应位置的网络信号值，如果网络信号未覆盖到，也输出0。
 * 一个网格如果可以途径不同的传播衰减路径传达，取较大的值作为其信号值。
 *
 * 示例1：
 *
 * 输入：
 *
 * 6 5
 * 0 0 0 -1 0 0 0 0 0 0 0 0 -1 4 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0
 * 1 4
 *
 * 输出：
 *
 * 2
 */
import java.util.*;
public class Computer {
    static class Main {
        public static void main(String[] args) {
            // 输入处理
            Scanner in = new Scanner(System.in);
            int m = in.nextInt();
            int n = in.nextInt();

            int[] matrix = new int[m * n];
            for (int i = 0; i < m * n; i++) {
                matrix[i] = in.nextInt();
            }
            int target_i = in.nextInt();
            int target_j = in.nextInt();

            // 队列中保存所有大于等于 1 的信号位置
            LinkedList<Integer[]> queue = new LinkedList<>();
            // 找到信号源
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i * n + j] > 0) {
                        queue.addLast(new Integer[] {i, j});
                        break;
                    }
                }
            }

            // 信号可以上下左右传播
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            while (queue.size() > 0) {
                Integer[] pos = queue.removeFirst();
                int i = pos[0];
                int j = pos[1];

                // 信号强度为1，则不需要再传播了，后面肯定都是0
                if (matrix[i * n + j] - 1 == 0) {
                    break;
                }

                for (int[] direction : directions) {
                    int new_x = i + direction[0];
                    int new_y = j + direction[1];

                    if (new_x >= 0 && new_x < m && new_y >= 0 && new_y < n && matrix[new_x * n + new_y] == 0) {
                        matrix[new_x * n + new_y] = matrix[i * n + j] - 1;
                        queue.addLast(new Integer[] {new_x, new_y});
                    }
                }
            }

            System.out.println(matrix[target_i * n + target_j]);
        }

    }
}
