package od2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 数组去重和排序
 */
public class ArrayDeweighting {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        //转为数组
        List<Integer> nums = Arrays.stream(in.nextLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // 注意使用LinkedHashMap，这样可以保留数字出现的顺序
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
        }

        LinkedList<Map.Entry<Integer,Integer>> list = new LinkedList<>(map.entrySet());
        list.sort((a, b) -> a.getValue() - b.getValue());
        for (int i = 0; i < list.size(); i++) {
            Map.Entry<Integer, Integer> entry = list.get(i);
            if (i != list.size() - 1) {
                System.out.print(entry.getKey() + ",");
            } else {
                System.out.println(entry.getKey());
            }
        }

    }
}
