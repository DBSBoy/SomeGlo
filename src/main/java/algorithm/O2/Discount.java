package algorithm.O2;

/**
 * 模拟商场优惠打折II
 * 某网上商场举办优惠活动，发布了满减、打折、无门槛3种 优惠券，分别为:
 * 1：每满100元优惠10元，无使用数限制，如100~199元可以使用1张减10元，200~299可使用2张减20元，以此类推;
 * 2：92折券，1次限使用1张，如100元，则优惠后为92元，
 * 3：无门槛5元优惠券，无使用数限制，直接减5元。
 *
 * 优惠券使用限制：每次最多使用2种优惠券，2种优惠可以叠加(优惠叠加时以优惠后的价格计算)。
 *
 *         以购物200元为例，可以先用92折券优惠到184元，再用1张满减券优惠10元，最终价格是174元，也可以用满减券2张优惠20元为180元，再使用92折券优惠到165(165.6向下取整)，不同使用顺序的优惠价格不同，以最优惠价格为准。在一次购物种，同一类型优惠
 * 券使用多张时必须一次性使用，不能分多次拆开使用(不允许先使用1张满减券，再用打折券，再使用一张满减券)。
 *         请设计实现一种解决方法，帮助购物者以最少的优惠券获得最优的优惠价格。优惠后价格越低越好，同等优惠价格，使用的优惠券越少越好，可以允许某次购物不使用优惠券。
 *
 *         约定：优惠活动每人只能参加一次，每个人的优惠券种类和数量是一样的。
 *
 * 输入描述
 * 1：第一行:每个人拥有的优惠券数量(数量取值范围为[0,10]，按满减、打折、无门槛的顺序输入
 * 2：第二行:表示购物的人数n(1≤n≤10000)
 * 3：最后n行:每一行表示某个人优惠前的购物总价格(价格取值范围(0,1000]，都为整数)。
 *
 * 输出描述
 * 1：每行输出每个人每次购物优惠后的最低价格以及使用的优惠券总数量。每行的输出顺序和输入的顺序保持一致
 *
 * 备注
 * 1.优惠券数量都为整数，取值范围为[0.10]
 * 2.购物人数为整数，取值范围为[1,10000]
 * 3.优惠券的购物总价为整数，取值范围为(0.1000]
 * 4.优惠后价格如果是小数，则向下取整，输出都为整数。
 *
 * 示例1： 输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 3 2 5
 *
 * 3
 * 100
 *
 * 200
 *
 * 400
 */
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
public class Discount {
    public static class Main {
        public static void main(String[] args) {
            //处理输入
            Scanner in=new Scanner(System.in);
            List<Integer> params =Arrays.stream(in.nextLine().split(" "))
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
            count += Math.min(m, price / 100);
            price -= count * 10;
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

            count += Math.min(m, price / 100);
            price -= count * 10;

            int a[] = {price, count};
            return a;

        }

        //先满减后无门槛
        public static int[] mode_c(int price, int m, int k) {
            int count = 0;

            count += Math.min(m, price / 100);
            price -= count * 10;

            for (int i=0;i<k;i++) {
                price -= 5;
                count += 1;
                if (price <0) {
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

            for (int i=0;i<k;i++) {
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
