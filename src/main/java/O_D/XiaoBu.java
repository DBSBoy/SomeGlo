package O_D;

/**
 * 不爱施肥的小布
 *
 *
 */
import java.util.Scanner;
import java.util.*;
public class XiaoBu {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);

            int m = in.nextInt();
            int n = in.nextInt();
            in.nextLine();
            Integer[] fields = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

            // 最少天数小于果林大小可直接返回-1
            if (n<m) {
                System.out.println(-1);
                return;
            }
            // 最少天数等于果林大小可直接返回max(fields)
            if (n==m) {
                System.out.println((int) Collections.max(Arrays.asList(fields)));
                return;
            }

            //排序找到最大最小值
            Arrays.sort(fields);
            int left = 0;
            int right = fields[fields.length - 1];

            int result = -1;

            while (left +1 < right) {
                //取中间位置的值作为效能k，这里的k取得是其在数组中的index
                int k = (int) Math.ceil((double)(left + right) / 2);

                int res = cal(k, fields);

                if (res - n > 0) {
                    left = k;
                } else {
                    result = k;
                    right = k;
                }
            }
            System.out.println(result);
        }

        //判断效能为k时，所需总天数
        public static int cal(int k, Integer[] fields) {
            int days = 0;
            for (int i=0;i<fields.length;i++) {
                days += Math.ceil(fields[i] / (double)k);
            }
            return days;
        }

    }
}
