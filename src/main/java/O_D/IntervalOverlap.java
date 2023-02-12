package O_D;
import java.util.Scanner;
import java.util.*;

/**
 * 区间交叠问题
 */
public class IntervalOverlap {


    static class Main {
        public static int min_num;

        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            String count = in.nextLine();

            //自定义排序
            ArrayList<ArrayList<Integer>> ranges = new ArrayList<ArrayList<Integer>>();
            for (int i=0;i<Integer.valueOf(count);i++) {
                ArrayList<Integer> range = new ArrayList<Integer>();
                String[] nums = in.nextLine().split(",");
                range.add(Integer.valueOf(nums[0]));
                range.add(Integer.valueOf(nums[1]));
                ranges.add(range);
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


            int total_length = ranges.get(ranges.size()-1).get(1) - ranges.get(0).get(0);
            //System.out.println(total_length);

            //区间起点
            int start = 0;
            min_num = ranges.size();
            for (int i=0;i<Integer.valueOf(count);i++) {
                start = ranges.get(i).get(0);
                find_min_line(ranges, i, 1, start, total_length);
            }
            System.out.println(min_num);

        }

        public static void find_min_line(ArrayList<ArrayList<Integer>> ranges, int index, int ans, int start, int total_length)
        {
            // 完全覆盖
            if(ranges.get(index).get(1)-start>=total_length) {
                min_num=Math.min(min_num, ans);
                return ;
            }
            int temp=0;
            for(int i=index+1;i<ranges.size();i++) {
                // 找出剩余线段中坐端点小于起始线段的右端点
                if(ranges.get(i).get(0)<=ranges.get(index).get(1)) {
                    if(ranges.get(i).get(1)>ranges.get(temp).get(1)) {
                        temp=i;
                    }
                }

            }
            if(temp!=0) {
                find_min_line(ranges, temp, ans+1, start, total_length);
            }
        }

    }
}
