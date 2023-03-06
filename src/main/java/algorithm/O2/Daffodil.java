package algorithm.O2;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 水仙花数
 */
public class Daffodil {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        int M = Integer.parseInt(in.nextLine());

        //超出范围
        if (N < 3 || N > 7) {
            System.out.println(-1);
            return;
        }

        List<Integer> res = new LinkedList<>();

        int start = (int) Math.pow(10, N - 1);
        int end = (int) Math.pow(10, N);

        //暴力遍历每一个数，找到第一个
        for (int i = start; i < end; i++) {
            int sum = 0;
            int bit = start;
            while (bit != 1) {
                sum += Math.pow(i / bit % 10, N);
                bit /= 10;
            }
            sum += Math.pow(i % 10, N);
            if (sum == i) {
                res.add(i);
            }
            if (res.size() == M + 1) {
                System.out.println(i);
                return;
            }
        }

        if (M > res.size()) {
            System.out.println(M * res.get(res.size()-1));
        }

    }

}
