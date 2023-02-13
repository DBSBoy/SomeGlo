package O_D;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 最大利润
 * 商人经营一家店铺，有number 种商品，
 * 由于仓库限制每件商品的最大持有数量是 item[index]
 *
 * 每种商品的价格是 item-price[item_index][day]
 *
 * 通过对商品的买进和卖出获取利润
 * 请给出商人在 days 天内能获取的最大的利润
 *
 * 注:同一件商品可以反复买进和卖出
 * 输入描述
 * 3 第一行输入商品的数量 number
 *
 * 3 第二行输入商品售货天数 days
 * 4 5 6 第三行输入仓库限制每件商品的最大持有数量是item[index]
 *
 * 1 2 3 第一件商品每天的价格
 *
 * 4 3 2 第二件商品每天的价格
 *
 * 1 5 3 第三件商品每天的价格
 *
 * 示例1：
 *
 * 输入：
 *
 * 3
 *
 * 3
 *
 * 4 5 6
 *
 * 1 2 3
 *
 * 4 3 2
 *
 * 1 5 3
 *
 * 输出：
 *
 * 32
 *
 * 示例2：
 *
 * 输入：
 *
 * 1
 *
 * 1
 *
 * 1
 *
 * 1
 *
 * 输出：
 *
 * 0
 */
public class MaximumProfit {
    static class Main {
        public static int min_num;

        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int item_number = Integer.parseInt(in.nextLine());
            int days = Integer.parseInt(in.nextLine());

            List<Integer> max_items =Arrays.stream(in.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            List<ArrayList<Integer>> prices = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < item_number; i++) {
                List<Integer> item_price =Arrays.stream(in.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                prices.add(new ArrayList<>(item_price));
            }

            //贪心算法
            int max_profit = 0;
            for (int i = 0; i < prices.size(); i++) {
                int ans = 0;
                for (int j = 1; j < prices.get(i).size(); ++j) {
                    ans += Math.max(0, prices.get(i).get(j) - prices.get(i).get(j-1));
                }
                max_profit += ans * max_items.get(i);
            }

            System.out.println(max_profit);

        }

    }
}
