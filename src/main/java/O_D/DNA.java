package O_D;

/**
 * 优选核酸
 *
 */
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
public class DNA {
    static class Main {
        // 核酸点结构
        public static class Point {
            int id;
            //距离
            int dis;
            //排队人数
            int que;
            //总花费金钱
            int pay;
            //总花费时间
            int time;
        }

        // 人数增加情况
        public static final int[] add8_10 = {3, 480, 600};
        public static final int[] add12_14 = {10, 720, 840};

        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            // 先将时间转换为分钟数
            int start = in.nextInt() * 60 + in.nextInt();
            int end = in.nextInt() * 60 + in.nextInt();
            int n = in.nextInt();

            // 构造核酸点
            Point[] points = new Point[n];
            for (int i = 0; i < points.length; i++) {
                Point point = new Point();
                point.id = in.nextInt();
                point.dis = in.nextInt();
                point.que = in.nextInt();
                point.pay = point.dis * 10;
                // 计算总耗时
                point.time = cal_time(start, point);
                points[i] = point;
            }

            //  按照给定的三条规则排序
            List<Point> res = Arrays.stream(points).filter(p -> start + p.time < end)
                    .sorted((p1, p2) -> {
                        if (p1.time != p2.time) {
                            return p1.time - p2.time;
                        } else {
                            return p1.pay - p2.pay;
                        }
                    }).collect(Collectors.toList());

            System.out.println(res.size());
            for (Point p : res) {
                System.out.print(p.id);
                System.out.print(" ");
                System.out.print(p.time);
                System.out.print(" ");
                System.out.println(p.pay);
            }

        }

        public static int cal_time(int start, Point point) {
            int total_time = 0;
            // 路程时间
            total_time += point.dis * 10;
            // 排队人数
            point.que = Math.max(0, point.que - point.dis * 10);
            // 到监测点的时间
            int on = start + point.dis * 10;

            // 到达时间的分支条件
            if (on <= add8_10[1]) {
                return add8_10[1] - start;
            } else if (on <= add8_10[2]) {
                point.que += (on - add8_10[1]) * add8_10[0] - (on - add8_10[1]);
                return total_time + point.que;
            } else if (on <= add12_14[1]) {
                return total_time + point.que;
            } else if (on <= add12_14[2]) {
                point.que += (on - add12_14[1]) * add12_14[0] - (on - add12_14[1]);
                return total_time + point.que;
            } else {
                return total_time + point.que;
            }
        }

    }
}
