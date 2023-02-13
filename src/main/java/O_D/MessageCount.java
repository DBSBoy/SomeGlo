package O_D;

/**
 * 最多获得短信
 * 某云短信厂商，为庆祝国庆，推出充值优惠活动。
 * 现在给出客户预算，和优惠售价序列，求最多可获得的短信总条数。
 *
 * 输入描述
 *
 * 第一行客户预算M，其中 0 ≤ M ≤ 10^6
 * 第二行给出售价表， P1, P2, … Pn , 其中 1 ≤ n ≤ 100 ,
 * Pi为充值 i 元获得的短信条数。
 * 1 ≤ Pi ≤ 1000 , 1 ≤ n ≤ 100
 *
 * 输出描述：
 *
 * 最多获得的短信条数
 *
 * 示例1：
 *
 * 输入：
 *
 * 6
 * 10 20 30 40 60
 * 输出：
 *
 * 70
 *
 * 说明：
 *
 * 分别充值1元和5元，可以获得10+60条短信，共70条，最大。
 */
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
public class MessageCount {
    static class Main {
        public static int min_num;

        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int money = Integer.parseInt(in.nextLine());
            //转为数组
            List<Integer> topup_info =Arrays.stream(in.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            List<ArrayList<Double>> topup_details = new ArrayList<ArrayList<Double>>();
            for (int i = 0; i < topup_info.size(); i++) {
                List<Double> topup_detail = new ArrayList<Double>();
                topup_detail.add(Double.valueOf(i+1));
                topup_detail.add(Double.valueOf(topup_info.get(i)));
                topup_detail.add(topup_info.get(i) * 1.0 / (i+1));
                topup_details.add(new ArrayList<>(topup_detail));
            }

            // 按照一块钱最多能买多少条短信排序
            Collections.sort(topup_details, new Comparator<ArrayList<Double>>() {
                @Override
                public int compare(ArrayList<Double> o1, ArrayList<Double> o2) {
                    return  o2.get(2).compareTo(o1.get(2));
                }
            });

            //贪心选择
            int result = 0;
            for (int i = 0; money > 0; i++) {
                if (topup_details.get(i).get(0) <= money) {
                    result += topup_details.get(i).get(1);
                    money -= topup_details.get(i).get(0);
                }
                if (i == topup_details.size() - 1) {
                    i = 0;
                }
            }
            System.out.println(result);

        }

    }
}
