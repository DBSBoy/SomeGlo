package algorithm.O2;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 运维日志排序
 */
public class OperationAndMaintenance {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        List<String> times = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            times.add(in.nextLine());
        }
        in.close();

        times.sort(Comparator.comparingLong(OperationAndMaintenance::getTime));

        times.forEach(System.out::println);
    }

    // 字符串转long时间戳
    public static long getTime(String str) {
        String[] t1 = str.split(":");
        String[] t2 = t1[2].split("\\.");
        int h = Integer.parseInt(t1[0]) * 60 * 60 * 1000;
        int m = Integer.parseInt(t1[1]) * 60 * 1000;
        int s = Integer.parseInt(t2[0]) * 1000;
        int n = Integer.parseInt(t2[1]);
        return h + m + s + n;
    }
}
