package algorithm.O2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 全量和已占用字符集
 */
public class AllNum {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        String[] strs = in.nextLine().split("@");
        String[] front_strs = strs[0].split(",");
        //保存字母及其个数
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<Character> list = new ArrayList<>();

        // 初始化map及list
        for (int i = 0; i < front_strs.length; i++) {
            String[] aStr = front_strs[i].split(":");
            char ch1 = aStr[0].charAt(0);
            int n1 = Integer.parseInt(aStr[1]);
            map.put(ch1, n1);
            list.add(ch1);
        }

        // 判断是否有占用字符集
        if (strs.length > 1) {
            String[] yongStr = strs[1].split(",");
            for (int i = 0; i < yongStr.length; i++) {
                String[] yStr = yongStr[i].split(":");
                char ch2 = yStr[0].charAt(0);
                int n2 = Integer.parseInt(yStr[1]);
                map.put(ch2, map.get(ch2) - n2);
            }
        } else {
            String res = strs[0] + "@";
            System.out.println(res);
            return;
        }
        ArrayList<String> res_list = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            char c = list.get(i);
            String x = "";
            if (map.get(c) > 0) {
                x = c + ":" + map.get(c);
                res_list.add(x);
            }
        }
        // 输出格式
        if (res_list.size() > 0) {
            for (int i = 0; i < res_list.size() - 1; i++) {
                System.out.print(res_list.get(i) + ",");
            }
            System.out.print(res_list.get(res_list.size() - 1));
        }
    }
}
