package O_D;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 模拟商场
 * 模拟商场优惠打折，有三种优惠券可以用，满减券、打折券和无门槛券。
 *
 * 满减券：满100减10，满200减20，满300减30，满400减40，以此类推不限制使用；
 *
 * 打折券：固定折扣92折，且打折之后向下取整，每次购物只能用1次；
 *
 * 无门槛券：一张券减5元，没有使用限制；
 *
 *         每个人结账使用优惠券时有以下限制：每人每次只能用两种优惠券，并且同一种优惠券必须一次用完，不能跟别的穿插使用（比如用一张满减，再用一张打折，再用一张满减，这种顺序不行）。
 *
 *         求不同使用顺序下每个人用完券之后得到的最低价格和对应使用优惠券的总数；如果两种顺序得到的价格一样低，就取使用优惠券数量较少的那个。
 *
 * 输入描述：
 *
 * 第一行三个数字m,n,k，分别表示每个人可以使用的满减券、打折券和无门槛券的数量
 *
 * 第二行一个数字x, 表示有几个人购物
 *
 * 后面x行数字，依次表示是这几个人打折之前的商品总价
 *
 * 输出描述：
 *
 * 输出每个人使用券之后的最低价格和对应使用优惠券的数量
 *
 * 示例：
 *
 * 输入：
 *
 * 3 2 5
 *
 * 3
 *
 * 100
 *
 * 200
 *
 * 400
 *
 * 输出：
 *
 * 65 6
 *
 * 135 8
 *
 * 275 8
 *
 * 说明:
 *
 * 第一个人使用 1 张满减券和5张无门槛券价格最低。
 *
 * 第二个人使用 3 张满减券和5张无门槛券价格最低。
 *
 * 第二个人使用 3 张满减券和5张无门槛券价格最低。
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
