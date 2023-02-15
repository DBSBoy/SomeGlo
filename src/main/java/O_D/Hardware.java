package O_D;

/**
 * 硬件产品销售方案
 * 某公司目前推出了AI开发者套件，AI加速卡，AI加速模块，AI服务器，智能边缘多种硬件产品，每种产品包含若干个型号。
 * 现某合作厂商要采购金额为amount元的硬件产品搭建自己的AI基座。
 * 例如当前库存有N种产品，每种产品的库存量充足，给定每种产品的价格，记为price（不存在价格相同的产品型号）。请为合作厂商列出所有可能的产品组合。
 *
 * 给定一行，代表一个工厂拥有的所有零件的价格，零件的库存无限量，例如:
 * [100,200,200,300,500] 代表工厂有5种零件，每种零件单价为100,200,200,300,500元
 * 求出该企业能购买所有的零件组合。
 *
 * 输入描述：
 * 第一行，正整数，企业拥有的钱总数。
 * 第二行，工厂零件价格，逗号分隔的正整数。
 *
 * 输出描述：
 *
 * 以数组的格式输出所有可能的零件组合，不能包含重复的组合。
 *
 * 示例1：
 *
 * 输入：
 *
 * 500
 *
 * 100,200,200,300,500
 *
 * 输出：
 * [[100, 100, 100, 100, 100], [100, 100, 100, 200], [100, 100, 100, 200], [100, 100, 300], [100, 200, 200], [100, 200, 200], [100, 200, 200], [200, 300], [200, 300], [500]]
 */
import java.util.*;
public class Hardware {
    static class Main {
        public static void main(String[] args) {
            // 输入处理
            Scanner in = new Scanner(System.in);
            int amount = Integer.parseInt(in.nextLine());
            String[] poducts_str = in.nextLine().split(",");
            int[] poducts = new int[poducts_str.length];
            for (int i=0;i<poducts_str.length;i++) {
                poducts[i] = Integer.parseInt(poducts_str[i]);
            }
            List<List<Integer>> result = combinationSum(poducts, amount);

            System.out.println(result);
        }

        public static List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            List<Integer> combine = new ArrayList<Integer>();
            dfs(candidates, target, ans, combine, 0);
            return ans;
        }

        public static void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
            if (idx == candidates.length) {
                return;
            }
            if (target == 0) {
                ans.add(new ArrayList<Integer>(combine));
                return;
            }
            // 直接跳过
            dfs(candidates, target, ans, combine, idx + 1);
            // 选择当前数
            if (target - candidates[idx] >= 0) {
                combine.add(candidates[idx]);
                dfs(candidates, target - candidates[idx], ans, combine, idx);
                combine.remove(combine.size() - 1);
            }
        }

    }
}
