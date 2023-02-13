package O_D;

/**
 * 端口合并
 * 有 M(1<=M<=10) 个端口组
 * 每个端口组是长度为 N(1<=N<=100)的整数数组，如果端口组间存在2个及以上不同端口相同，则认为这2个端口组 互相关Q联，可以合并
 * 第一行输入端口组个数M，再输入M行，每行逗号分隔，代表端口组。输出合并后的端口组，用二维数组Q表示
 * 输入描述
 * 第一行输入一个数字M
 * 第二行开始输入M行，每行是长度为N的整数数组，用逗号分害
 *
 * 输出描述
 * 合并后的二维数组
 *
 * 示例1：
 *
 * 输入：
 *
 * 4
 * 4
 * 2,3,2
 * 1,2
 * 5
 *
 * 输出：
 *
 * [[4],[2,3],[1,2],[5]]
 */
import java.util.*;
import java.util.stream.Collectors;
public class PortMerge {
    static class Main {
        public static int min_num;

        public static void main(String[] args) {
            // 输入处理
            Scanner in = new Scanner(System.in);
            int m = Integer.parseInt(in.nextLine());

            //利用treeset来保存区间，方便判断是否有相交
            List<TreeSet<Integer>> ranges = new ArrayList<>(m);
            for (int i = 0; i < m; i++) {
                List<Integer> range_list =Arrays.stream(in.nextLine().split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                TreeSet<Integer> range_set = new TreeSet<>();
                for (Integer x : range_list) {
                    range_set.add(x);
                }
                ranges.add(range_set);
            }

            //合并区间
            while (merge(ranges));

            System.out.println(ranges);
        }

        public static boolean merge(List<TreeSet<Integer>> ranges) {
            for (int i = 0; i < ranges.size(); i++) {
                for (int j = i + 1; j < ranges.size(); j++) {
                    TreeSet<Integer> range1 = ranges.get(i);
                    TreeSet<Integer> range2 = ranges.get(j);
                    if (check(ranges.get(i), ranges.get(j))) {
                        range1.addAll(range2);
                        ranges.remove(j);
                        return true;
                    }
                }
            }
            return false;
        }

        public static boolean check(TreeSet<Integer> range1, TreeSet<Integer> range2) {
            int count = 0;
            for (Integer x : range1) {
                if (range2.contains(x)) {
                    count++;
                }
                if (count >= 2) {
                    return true;
                }
            }
            return false;
        }

    }
}
