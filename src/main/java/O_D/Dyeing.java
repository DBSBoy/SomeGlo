package O_D;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 无向图染色
 */
public class Dyeing {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        String param_str = in.nextLine();
        String[] param_list = param_str.split(" ");
        int m = Integer.valueOf(param_list[0]);
        int n = Integer.valueOf(param_list[1]);

        //构造输入数据结构
        ArrayList<ArrayList<Integer>> edgeArrayList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            String edge_str = in.nextLine();
            String[] edge_point = edge_str.split(" ");
            ArrayList<Integer> singleEdge = new ArrayList<Integer>();
            singleEdge.add(Integer.valueOf(edge_point[0]));
            singleEdge.add(Integer.valueOf(edge_point[1]));
            edgeArrayList.add(singleEdge);
        }

        int count = 0;
        //遍历所有可能的组合 举例： 10001 -> i 的二进制表达
        for (int i = 0; i < (1 << m); i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                // 检测所有的边相连的是否同为红颜色
                if (((i >> (m - edgeArrayList.get(j).get(0))) & 1) == 1 && ((i >> (m - edgeArrayList.get(j).get(1))) & 1) == 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        System.out.println(count);

    }
}
