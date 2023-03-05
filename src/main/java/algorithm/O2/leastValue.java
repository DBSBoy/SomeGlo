package algorithm.O2;

/**
 * 统一
 * 火车站附近的货物中转站负责将到站货物运往仓库，小明在中转站负责调度2K辆中转车（ K 辆干货中转车， K 辆湿货中转车）。货物由不同供货商从各地发来，各地的货物是依次进站，然后小明按照卸货顺序依次装货到中转车上，一个供货商的货只能装到一辆车上，不能拆装，但是一辆车可以装多家供货商的货；中转车的限载货物量由小明统一制定，在完成货物中转的前提下，请问中转车的统一限载货物数最小值为多少。
 * 输入描述：
 * 第一行 length 表示供货商数量1<= length <=104
 * 第二行 goods 表示供货数数组，1<= goods [ i ]<=104
 * 第三行 types 表示对应货物类型， types [ i ］等于0或者1,0代表干货，1代表湿货第四行 k 表示单类中转车数量1<= k <= goods . length
 * 输出描述：
 *
 * 运行结果输出一个整数，表示中转车统一限载货物数
 *
 * 示例1：输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 * 4
 * 3 2 6 3
 * 0 1 1 0
 * 2
 * 输出
 *
 * 6
 *
 */
import java.util.Scanner;
public class leastValue {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int num = in.nextInt();
            Integer[] goods = new Integer[num];
            for (int i=0;i<num;i++) {
                goods[i] = in.nextInt();
            }
            Integer[] types = new Integer[num];
            for (int i=0;i<num;i++) {
                types[i] = in.nextInt();
            }
            int k = in.nextInt();


            int dry_sum = 0;
            int wet_sum = 0;
            //由于一家的商品不能分拆，一辆车最小的载重也需要比这个数大
            int max_weight = 0;
            for (int i=0;i<num;i++) {
                if (types[i] == 0) {
                    dry_sum += goods[i];
                } else {
                    wet_sum += goods[i];
                }
                max_weight = Math.max(max_weight, goods[i]);
            }

            System.out.println(Math.max(max_weight, Math.max(dry_sum, wet_sum)/k));


        }

    }
}
