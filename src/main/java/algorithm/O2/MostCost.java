package algorithm.O2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 最大花费金额
 */
public class MostCost {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        List<Integer> m = Arrays.stream(in.nextLine().split(","))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        int r = Integer.parseInt(in.nextLine());

        int result = -1;
        //暴力遍历即可
        for (int i = 0; i < m.size() - 2; i++) {
            for (int j = 0; j < m.size() - 1; j++) {
                for (int k = 0; k < m.size(); k++) {
                    if (i != j && j != k && i != k) {
                        int sum = m.get(i) + m.get(j) + m.get(k);
                        if (sum <= r && sum > result) {
                            result = sum;
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }
}
