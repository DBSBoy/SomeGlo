package od2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * VLAN资源池
 */
public class Vlan {
    public static void main(String[] args) {
        //处理输入
        Scanner in = new Scanner(System.in);
        String[] pool = in.nextLine().split(",");
        int delete_target = in.nextInt();

        // 抽出所有的数字
        List<Integer> list = new ArrayList<>();
        for (String range : pool) {
            String[] tmp = range.split("-");
            if (tmp.length > 1) {
                for (int i = Integer.parseInt(tmp[0]); i <= Integer.parseInt(tmp[1]); i++) {
                    list.add(i);
                }
            } else {
                list.add(Integer.parseInt(tmp[0]));
            }
        }

        // 删除资源
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == delete_target) {
                list.remove(i);
            }
        }

        // 排序+输出
        Collections.sort(list);
        StringBuilder result_str = new StringBuilder();

        int i = 0;
        while (i < list.size()) {
            int first = list.get(i);
            int j = 1;
            while (j <= list.size() - 1 - i) {
                if (list.get(i) + j == list.get(i + j)) {
                    j++;
                } else {
                    break;
                }
            }
            if (j == 1) {
                result_str.append(first);
                result_str.append(",");
                i++;
            } else {
                result_str.append(String.valueOf(first) + "-" + String.valueOf(first + j - 1) + ",");
                i = i + j;
            }
        }
        System.out.println(result_str.toString().substring(0, result_str.length() - 1));
    }

    }
