package O_D;

/**
 * 最优高铁城市修建方案
 *
 * 高铁城市圈对人们的出行、经济的拉动效果明显。
 *
 * 每年都会规划新的高铁城市圈建设。在给定城市数量，可建设高铁的两城市间的修建成本列表、以及结合城市商业价值会固定建设的两城市建高铁。
 *
 * 请你设计算法，达到修建城市高铁的最低成本。注意，需要满足城市圈内城市间两两互联可达(通过其他城市中转可达也属于满足条件）。
 *
 * 输入描述：
 *
 * 1、第一行，包含此城市圈中城市的数量、可建设高铁的两城市间修建成本列表数量、必建高铁的城市列表。三个数字用空格间隔。
 *
 * 2、可建设高铁的两城市间的修建成本列表，为多行输入数据，格式为3个数字，用空格分隔，长度不超过1000。
 *
 * 3、 固定要修建的高铁城市列表，是上面参数2的子集，可能为多行，每行输入为2个数字，以空格分隔。
 *
 * 城市id从1开始编号，建设成本的取值为正整数，取值范围均不会超过1000
 *
 * 输出描述：
 *
 * 修建城市圈高铁的最低成本，正整数。如果城市圈内存在两城市之间无法互联，则返回-1。
 *
 * 示例1  输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 3 3 0
 * 1 2 10
 * 1 3 100
 * 2 3 50
 *
 * 输出
 *
 * 60
 *
 * 解释：
 *
 * 3 3 0城市圈数量为3，表示城市id分别为1,2,3
 * 1 2 10城市1，2间的高铁修建成本为10
 * 1 3 100城市1，3间的高铁修建成本为100
 * 2 3 50城市2，3间的高铁修建成本为50
 * 满足修建成本最低，只需要建设城市1，2间，城市2，3间的高铁即可，城市1，3之间可通过城市2中转来互联。这样最低修建成本就是60。
 *
 * 示例2  输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 3 3 1
 * 1 2 10
 * 1 3 100
 * 2 3 50
 *
 * 1 3
 *
 * 输出
 *
 * 110
 */
import java.util.Scanner;
import java.util.*;
public class HighSpeedRailway {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int pair_count_1 = in.nextInt();
            int pair_count_2 = in.nextInt();

            // 可建设高铁的两城市
            int[][] city_pair_1 = new int[pair_count_1][3];
            for (int i = 0; i < pair_count_1; i++) {
                city_pair_1[i][0] = in.nextInt();
                city_pair_1[i][1] = in.nextInt();
                city_pair_1[i][2] = in.nextInt();
            }

            // 必建高铁的两城市
            int[][] city_pair_2 = new int[pair_count_2][2];
            for (int i = 0; i < pair_count_2; i++) {
                city_pair_2[i][0] = in.nextInt();
                city_pair_2[i][1] = in.nextInt();
            }

            UF uf = new UF(n);

            // key为修建高铁的两个城市，value为费用
            HashMap<String, Integer> city_map = new HashMap<>();
            for (int[] city_pair : city_pair_1) {
                int city1 = city_pair[0], city2 = city_pair[1];
                city_map.put(city1 < city2 ? city1 + "-" + city2 : city2 + "-" + city1, city_pair[2]);
            }

            int result = 0;
            // 先计算必建高铁情况下的费用
            for (int[] city_pair : city_pair_2) {
                int city1 = city_pair[0], city2 = city_pair[1];
                result += city_map.get(city1 < city2 ? city1 + "-" + city2 : city2 + "-" + city1);
                // 纳入并查集
                uf.union(city1, city2);
            }
            System.out.println(result);

            //  已经满足所有城市通车，直接返回
            if (uf.count == 1) {
                System.out.println(result);
                return;
            }

            // 按修建费用排序
            Arrays.sort(city_pair_1, (a, b) -> a[2] - b[2]);

            for (int[] city_pair : city_pair_1) {
                int city1 = city_pair[0], city2 = city_pair[1];
                // 判断两城市是否相连
                if (uf.item[city1] != uf.item[city2]) {
                    uf.union(city1, city2);
                    // 若可以合入，则将对应的建造成本计入result
                    result += city_pair[2];
                }
                if (uf.count == 1) {
                    break;
                }
            }

            // count>1代表有的城市无法通车
            if (uf.count > 1) {
                System.out.println(-1);
                return;
            }

            System.out.println(result);
        }

    }

    // 并查集
    static class UF {
        int[] item;
        int count;

        public UF(int n) {
            item = new int[n + 1];
            count = n;
            for (int i = 0; i < n; i++) item[i] = i;
        }

        public int find(int x) {
            if (x != item[x]) {
                return (item[x] = find(item[x]));
            }
            return x;
        }

        public void union(int x, int y) {
            int x_item = find(x);
            int y_item = find(y);

            if (x_item != y_item) {
                item[y_item] = x_item;
                count--;
            }
        }
    }
}
