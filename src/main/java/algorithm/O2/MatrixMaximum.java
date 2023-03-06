package algorithm.O2;

import java.util.Scanner;

/**
 *
 */
public class MatrixMaximum {

    public static void main(String[] args) {
        //处理输入
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        int total = 0;
        while(N >0)

        {
            String[] matrix = in.nextLine().split(",");
            total += cal(matrix);
            N--;
        }
        System.out.println(total);
    }

    private static int cal(String[] matrix) {
        int max = 0;
        //直接暴力遍历即可
        for (int i = 0; i < matrix.length; i++) {
            if ("1".equals(matrix[i])) {
                StringBuilder value_str = new StringBuilder();
                for (int m = i; m < matrix.length; m++) {
                    value_str.append(matrix[m]);
                }
                for (int n = 0; n < i; n++) {
                    value_str.append(matrix[n]);
                }
                max = Math.max(max, Integer.parseInt(value_str.toString(), 2));
            }
        }
        return max;
    }
}
