package O_D;
import java.util.Scanner;
import java.util.*;

/**
 * 连接器问题
 */
public class Connector {


    static class Main {
        public static int min_num;

        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            String input_ranges = in.nextLine();
            input_ranges = input_ranges.replace("[", "");
            input_ranges = input_ranges.replace("]", "");
            String[] str_ranges = input_ranges.split(",");

            //自定义排序
            ArrayList<ArrayList<Integer>> ranges = new ArrayList<ArrayList<Integer>>();
            for (int i=0;i<str_ranges.length;i++) {
                if (i % 2 != 0) {
                    ArrayList<Integer> single_range = new ArrayList<Integer>();
                    single_range.add(Integer.parseInt(str_ranges[i-1]));
                    single_range.add(Integer.parseInt(str_ranges[i]));
                    ranges.add(single_range);
                }
            }
            Collections.sort(ranges, new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    int result = o1.get(0) - o2.get(0);
                    if (result == 0) {
                        return  o1.get(1) - o2.get(1);
                    }
                    return result;
                }
            });

            int result = 0;
            ArrayList<Integer> distances = new ArrayList<Integer>();
            int left = ranges.get(0).get(0), right = ranges.get(0).get(1);
            for (int i = 1; i < ranges.size(); i++) {
                if (ranges.get(i).get(0) <= right) {
                    right = Math.max(right, ranges.get(i).get(1));
                }
                else {                    // 另起一个新区间，ans统计新区间之前的区间数量，disVec记录新区间与前一个区间的距离。
                    result++;
                    distances.add(ranges.get(i).get(0)-right);
                    right = ranges.get(i).get(1);
                }
            }
            result++; //加上最后一个区间

            //链接器初始化
            String input_connectors = in.nextLine();
            input_connectors = input_connectors.replace("[", "");
            input_connectors = input_connectors.replace("]", "");
            String[] str_input_connectors = input_connectors.split(",");
            ArrayList<Integer> connectors = new ArrayList<Integer>();
            for (int i=0;i<str_input_connectors.length;i++) {
                connectors.add(Integer.parseInt(str_input_connectors[i]));
            }

            //使用贪心算法得到最少的区间数
            Collections.sort(connectors);
            Collections.sort(distances);
            int idx = 0;
            for (int i = 0; i < connectors.size()&&idx<distances.size(); i++) {
                if (connectors.get(i) >= distances.get(idx)) {
                    idx++;
                    result--;
                }
            }
            System.out.println(result);
        }

    }
}
