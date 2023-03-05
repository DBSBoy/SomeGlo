package algorithm.O2;

/**
 * 路灯照明
 */
import java.util.*;
import java.text.DecimalFormat;

public class StreetLamp {
    static class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while (in.hasNext()) {
                //处理输入
                int n = in.nextInt();
                int l = in.nextInt();

                int[] coords = new int[n];
                for (int i = 0; i < n; i++) {
                    coords[i] = in.nextInt();
                }

                // 两盏路灯之间的距离
                double d1 = 0;

                Arrays.sort(coords);
                for (int i = 1; i < n; i++) {
                    int temp = coords[i] - coords[i-1];
                    d1 = d1<temp? temp: d1;
                }
                d1 = d1/2;

                // 与两端点的距离
                int temp2 = l-coords[n-1];
                int d2 = coords[0]<temp2? temp2: coords[0];

                double d = d1<d2? d2: d1;

                //注意题目要求保留两位小数
                DecimalFormat df = new DecimalFormat("#.00");
                System.out.println(df.format(d));
            }
        }
    }
}
