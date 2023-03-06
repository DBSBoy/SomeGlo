package od2;

import java.util.Scanner;

/**
 * 【绘图机器】【计算面积】
 */
public class DrawingMachine {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        String[] input_params = in.nextLine().split(" ");
        int N = Integer.parseInt(input_params[0]);
        int E = Integer.parseInt(input_params[1]);

        int cur_x = 0, cur_y = 0, area = 0;

        // 算出每个柱子的高度相加即可
        for (int i = 0; i < N; i++) {
            String[] strs = in.nextLine().split(" ");
            int x = Integer.parseInt(strs[0]);
            int y = Integer.parseInt(strs[1]);

            area += (x - cur_x) * Math.abs(cur_y);

            cur_x = x;
            cur_y += y;
        }
        if (cur_x < E) {
            area += (E - cur_x) * Math.abs(cur_y);
        }

        System.out.println(area);
    }

}
