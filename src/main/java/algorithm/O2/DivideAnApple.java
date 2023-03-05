package algorithm.O2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 分苹果
 */
public class DivideAnApple {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while (in.hasNext()) {
                int num = Integer.parseInt(in.nextLine());
                List<Integer> weights = new ArrayList<>();
                for (int i = 0 ; i < num ; i++) {
                    weights.add(in.nextInt());
                }

                int aWeight = 0;
                int bWeight = 0;
                int min = Integer.MAX_VALUE;
                for (int i = 0 ; i < num ; i++) {
                    //不进位的二进制加法，等同于二进制的异或操作。
                    aWeight ^= weights.get(i);
                    bWeight += weights.get(i);
                    min = Math.min(weights.get(i), min);
                }

                if (aWeight == 0) {
                    System.out.println(bWeight - min);
                } else {
                    System.out.println(-1);
                }
            }
        }
}
