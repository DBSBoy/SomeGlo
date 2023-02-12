package O_D;

import java.util.*;

/**
 * 字符串重排序
 */
public class StrReorder {
    public static int max_machine=0;

    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        String str = in.nextLine();
        String[] str1 = str.split(" ");

        // 第一步，单词内部调整
        ArrayList<String> str_list = new ArrayList<String>();
        for (int i=0;i<str1.length;i++) {
            char[] chars = str1[i].toCharArray();
            Arrays.sort(chars);
            str_list.add(String.valueOf(chars));
            //System.out.println(s);
        }

        //第二步，单词间调整
        //先统计每个单词出现的次数
        HashMap<String, Integer> str_count = new HashMap<String, Integer>();

        for (int i=0;i<str_list.size();i++) {
            if(str_count.containsKey(str_list.get(i))) {
                str_count.put(str_list.get(i), str_count.get(str_list.get(i)) + 1);
            } else {
                str_count.put((str_list.get(i)), 1);
            }
        }

        // 按次数排序
        // 通过ArrayList构造函数把 str_count.entrySet()转换成list
        List<Map.Entry<String, Integer>> str_count_list = new ArrayList<Map.Entry<String, Integer>>(str_count.entrySet());
        // 通过比较器实现比较排序
        Collections.sort(str_count_list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                //return ~mapping1.getValue().compareTo(mapping2.getValue());
                if (a.getValue() > b.getValue()) {
                    return -1;
                } else if(a.getValue() == b.getValue()) {
                    if (a.getKey().length() > b.getKey().length()) {
                        return 1;
                    } else if (a.getKey().length() == b.getKey().length()) {
                        return a.getKey().compareTo(b.getKey());
                    } else {
                        return -1;
                    }
                } else {
                    return 1;
                }

            }
        });

        String result="";
        for (int i=0;i<str_count_list.size();i++) {
            for (int j=0;j<str_count_list.get(i).getValue();j++) {
                result = result +str_count_list.get(i).getKey() + " ";
            }

        }
        System.out.println(result);
    }

}
