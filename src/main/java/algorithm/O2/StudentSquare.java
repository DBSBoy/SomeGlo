package algorithm.O2;

/**
 * 学生方阵
 */
import java.util.Scanner;
import java.util.*;
public class StudentSquare {
    public static class Main {
        public static void main(String[] args) {
            //处理输入
            Scanner in = new Scanner(System.in);
            String[] input_str = in.nextLine().split(",");
            int m = Integer.parseInt(input_str[0]);
            int n = Integer.parseInt(input_str[1]);

            //构造学生矩阵
            String[][] matrix = new String[m][n];
            for (int i = 0; i < m; i++) {
                String[] s1 = in.nextLine().split(",");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = s1[j];
                }
            }

            //逐个元素判定即可 O(n^2)复杂度
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j].equals("M")) {
                        getMaxBoyCount(matrix, i, j, list);
                    }
                }
            }
            Collections.sort(list);
            System.out.println(list.get(list.size() - 1));
        }
        public static void getMaxBoyCount(String[][] matrix, int i, int j, List<Integer> list) {
            int len = 1;
            int a = 0, b = 0;
            int m = matrix.length, n = matrix[0].length;
            if (j < n) {  // 从左往右
                a = i;
                b = j;
                while (b < n - 1 && matrix[a][++b].equals("M")) {
                    len++;
                }
                list.add(len);
                len = 1;
            }
            if (i < m) {  // 从上往下
                a = i;
                b = j;
                while (a < m - 1 && matrix[++a][b].equals("M")) {
                    len++;
                }
                list.add(len);
                len = 1;
            }
            if (i < m && j < n) {  // 对角线
                a = i;
                b = j;
                while ((a < m - 1 && b < n - 1) && matrix[++a][++b].equals("M")) {
                    len++;
                }
                list.add(len);
                len = 1;
            }
            if (i >= 0 && j < n) {  // 从左往右
                a = i;
                b = j;
                while (( a > 0 && b < n - 1) && matrix[--a][++b].equals("M")) {
                    len++;
                }
                list.add(len);
            }
        }

    }

}
