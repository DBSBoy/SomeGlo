package algorithm.O2;

import java.util.Scanner;

/**
 * 机器人走迷宫
 */
public class Maze {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int X = in.nextInt();
        int Y = in.nextInt();
        int[][] matrix = new int[X][Y];
        int N = in.nextInt();
        while (N > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            matrix[a][b] = 1;
            N--;
        }

        // 深度遍历
        dfs(matrix, 0, 0, X - 1, Y - 1);
        int trap = 0;
        int reach_flag = 0;
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (matrix[i][j] == 2) {
                    trap++;
                }
                if (matrix[i][j] == 0) {
                    reach_flag++;
                }
            }
        }
        System.out.println(trap + " " + reach_flag);
    }

    public static void dfs(int[][] room, int next_x, int next_y, int x, int y) {
        if (room[next_x][next_y] == 1 || room[next_x][next_y] != 0) {
            return;
        }
        if (next_x == x && next_y == y) {
            room[next_x][next_y] = -1;
            return;
        }
        if (next_x < x) {
            dfs(room, next_x + 1, next_y, x, y);
        }
        if (next_y < y) {
            dfs(room, next_x, next_y + 1, x, y);
        }

        if (next_x == x || next_y == y) {
            if (next_x == x && next_y < y && room[next_x][next_y + 1] != -1) {
                room[next_x][next_y] = 2;
            } else if (next_y == y && next_x < x && room[next_x + 1][next_y] != -1) {
                room[next_x][next_y] = 2;
            } else {
                room[next_x][next_y] = -1;
            }
        } else if (room[next_x + 1][next_y] != -1 && room[next_x][next_y + 1] != -1) {
            room[next_x][next_y] = 2;
        } else {
            room[next_x][next_y] = -1;
        }
    }
    }
