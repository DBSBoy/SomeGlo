package algorithm.O2;

/**
 * 最大矩阵和
 */
import java.util.Scanner;
public class MatrixSum {
    public static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int m, n;
            // 限定长度为10
            int matrix[][] = new int[10][10];
            int sum[][] = new int[10][10];

            n = in.nextInt();
            m = in.nextInt();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    sum[i][j] = matrix[i][j];
                    if (i != 0) {
                        sum[i][j] += sum[i - 1][j];
                    }
                    if (j != 0) {
                        sum[i][j] += sum[i][j - 1];
                    }
                    if (i != 0 && j != 0) {
                        sum[i][j] -= sum[i - 1][j - 1];
                    }
                }
            }

            int result = matrix[0][0];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    for (int ri = i; ri < n; ri++) {
                        for (int rj = j; rj < m; rj++) {
                            int temp = sum[ri][rj];
                            if (i != 0) {
                                temp -= sum[i - 1][rj];
                            }
                            if (j != 0) {
                                temp -= sum[ri][j - 1];
                            }
                            if (i != 0 && j != 0) {
                                temp += sum[i - 1][j - 1];
                            }
                            if (temp > result) {
                                result = temp;
                            }
                        }
                    }
                }
            }
            System.out.println(result);
        }
    }

}
