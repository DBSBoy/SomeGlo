package O_D;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 模拟商场
 */
public class ShoppingMall {


    public static class Main {
        public static void main(String[] args) {
            //处理输入
            Scanner in = new Scanner(System.in);
            List<Integer> params = Arrays.stream(in.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            int m = params.get(0);
            int n = params.get(1);
            int k = params.get(2);

            int x = Integer.parseInt(in.nextLine());

            while (in.hasNext()) {
                int price = Integer.parseInt(in.nextLine());

                int[][] result = new int[4][2];
                //System.out.println(m + "\t" + n + "\t" + price);
                result[0] = mode_a(price, m, n);
                //System.out.println(m + "\t" + n + "\t" + price);
                result[1] = mode_b(price, m, n);
                //System.out.println(m + "\t" + n + "\t" + price);
                result[2] = mode_c(price, m, k);
                //System.out.println(m + "\t" + n + "\t" + price);
                result[3] = mode_d(price, n, k);
                //for (int i = 0; i < result.length; i++) {
                //    for (int j = 0; j < result[i].length; j++) {
                //        System.out.print(result[i][j] + "\t");
                //    }
                //    System.out.println("");
                //}
                //System.out.println("===========================================");


                //按照价格降序，用券数降序排序
                Arrays.sort(result, (int[] a, int[] b) -> {
                    if (a[0] != b[0]) {
                        // 第一个数不相等 第一个数降序
                        return a[0] - b[0];
                    } else {
                        // 第一个数相等 第二个数降序
                        return a[1] - b[1];
                    }
                });
                System.out.print(result[0][0]);
                System.out.print(" ");
                System.out.println(result[0][1]);

            }
        }

        //先满减后打折
        public static int[] mode_a(int price, int m, int n) {
            int count = 0;
            while (m > 0) {
                if (price < 100) {
                    break;
                }
                price -= (price / 100 * 10);
                count += 1;
                m--;
            }
            price *= 0.92;
            count += 1;
            int a[] = {price, count};
            return a;
        }

        //先打折后满减
        public static int[] mode_b(int price, int m, int n) {
            int count = 0;

            price *= 0.92;
            count += 1;

            while (m > 0) {
                if (price < 100) {
                    break;
                }
                price -= (price / 100 * 10);
                count += 1;
                m--;
            }

            int a[] = {price, count};
            return a;

        }

        //先满减后无门槛
        public static int[] mode_c(int price, int m, int k) {
            int count = 0;

            while (m > 0) {
                if (price < 100) {
                    break;
                }
                price -= (price / 100 * 10);
                count += 1;
                m--;
            }

            for (int i = 0; i < k; i++) {
                price -= 5;
                count += 1;
                if (price < 0) {
                    break;
                }
            }

            int a[] = {price, count};
            return a;
        }

        //先打折后无门槛
        public static int[] mode_d(int price, int n, int k) {
            int count = 0;

            price *= 0.92;
            count += 1;

            for (int i = 0; i < k; i++) {
                price -= 5;
                count += 1;
                if (price < 0) {
                    break;
                }
            }
            int a[] = {price, count};
            return a;
        }

    }

}
