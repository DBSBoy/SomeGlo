package od2;

import java.util.*;

/**
 * 查找舆情热词
 */
public class hotWord {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        in.nextLine();

        // key为单词，value为数组，用来保存排序所需的信息
        // 数组种保存的信息是: 单词出现次数 标题中出现次数 标题中的顺序 正文中的顺序
        Map<String, int[]> map = new HashMap<>();
        int title_order = 0;
        int text_order = 0;
        for (int i = 0; i < N; i++) {
            //首先是标题
            String[] title = in.nextLine().split(" ");
            for (int j = 0; j < title.length; j++) {
                if (!map.containsKey(title[j])) {
                    map.put(title[j], new int[]{0, 0, title_order, -1});
                }
                int[] info = map.get(title[j]);
                //若单词是首先出现在正文中的，那么要更新以下顺序
                if (info[2] == -1) {
                    info[2] = title_order;
                }
                // 标题中出现的词语频率系数为3，正文中出现的词语频率系数为1
                info[0] += 3;
                info[1]++;
                title_order++;
            }
            //其次是正文
            String[] text = in.nextLine().split(" ");
            for (int j = 0; j < text.length; j++) {
                if (!map.containsKey(text[j])) {
                    map.put(text[j], new int[]{0, 0, -1, text_order});
                }
                int[] info = map.get(text[j]);
                if (info[3] == -1) {
                    info[3] = text_order;
                }
                info[0]++;
                text_order++;
            }
        }
        // Map按value排序，先将map转为list,再排序list(按value值进行排序)
        List<Map.Entry<String, int[]>> list = new ArrayList<Map.Entry<String, int[]>>(map.entrySet());
        list.sort((o1, o2) -> (o1.getValue()[0] == o2.getValue()[0] ? (o1.getValue()[1] == o2.getValue()[1] ?
                (o1.getValue()[2] == o2.getValue()[2] ? (o1.getValue()[3] - o2.getValue()[3])
                        : o1.getValue()[2] - o2.getValue()[2])
                : o2.getValue()[1] - o1.getValue()[1])
                : (o2.getValue()[0] - o1.getValue()[0])));

        // 输出
        for (int i = 0; i < M; i++) {
            Map.Entry<String, int[]> entry = list.get(i);
            if (i != list.size() - 1) {
                System.out.print(entry.getKey() + " ");
            } else {
                System.out.println(entry.getKey());
            }
        }
    }
}
