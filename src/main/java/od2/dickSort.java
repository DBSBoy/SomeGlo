package od2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 磁盘容量排序
 */
public class dickSort {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        // 二维数组保存磁盘信息, 索引+容量
        int[][] disk_info = new int[n][2];
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int index = -1;
            String str = in.nextLine();
            map.put(i + 1, str);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'M') {
                    sum += Integer.parseInt(str.substring(index + 1, j));
                    index = j;
                } else if (str.charAt(j) == 'G') {
                    sum += Integer.parseInt(str.substring(index + 1, j)) * 1024;
                    index = j;
                } else if (str.charAt(j) == 'T') {
                    sum += Integer.parseInt(str.substring(index + 1, j)) * 1024 * 1024;
                    index = j;
                }
            }
            disk_info[i][0] = i + 1;
            disk_info[i][1] = sum;
        }

        // 二维数组排序输出
        Arrays.sort(disk_info, (e1, e2)->(e1[1]==e2[1]?(e1[0]-e2[0]):(e1[1]-e2[1])));
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.print(map.get(disk_info[i][0]));
            } else {
                System.out.println(map.get(disk_info[i][0]));
            }
        }

    }
}
