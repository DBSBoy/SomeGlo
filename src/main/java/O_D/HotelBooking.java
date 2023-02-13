package O_D;

/**
 * 预定酒店
 * 放暑假了，小明决定到某旅游景点游玩，他在网上搜索到了各种价位的酒店(长度为n的 数组A)，他的心理价位是x元，请帮他筛选出k个最接近x元的酒店 (n>=k>0) ,并由低到高打印酒店的价格
 * 输入描述
 * 第一行: n,k，x
 * 第二行: A[o] A[1] A[2]...A[n-1]
 * 输出描述
 * 从低到高打印筛选出的酒店价格
 * 示例一
 * 输入
 *
 * 10 5 6
 * 1 2 3 4 5 6 7 8 9 10
 * 输出
 *
 * 4 5 6 7 8
 */
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
public class HotelBooking {
    static class Main {

        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int k = in.nextInt();
            int x = in.nextInt();
            //先对价格排序
            int[] prices = new int[n];
            for (int i = 0; i < prices.length; i++) {
                prices[i] = in.nextInt();
            }
            Arrays.sort(prices);

            int[][] price_rating = new int[n][2];
            for (int i = 0; i < prices.length; i++) {
                int price = prices[i];
                price_rating[i][0] = price;
                //差价
                price_rating[i][1] = Math.abs(price - x);
            }

            //自定义排序
            List<int[]> sorted_prices = Arrays.stream(price_rating).sorted(Comparator.comparingInt(h -> h[1]))
                    .collect(Collectors.toList());

            List<Integer> picked_price = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                picked_price.add(sorted_prices.get(i)[0]);
            }

            picked_price.sort(Integer::compareTo);

            for (int i = 0; i < picked_price.size(); i++) {
                System.out.print(picked_price.get(i));
                if (i != picked_price.size() - 1) {
                    System.out.print(" ");
                }
            }

        }

    }
}
