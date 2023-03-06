package od2;

import java.util.*;

/**
 * 身高体重排序
 */
public class tallSort {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] heights = in.nextLine().split(" ");
        String[] weights = in.nextLine().split(" ");
        //第一步，构造hashmap
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new int[]{0, 0});
            int[] info = map.get(i);
            info[0] = Integer.parseInt(heights[i]);;
            info[1] = Integer.parseInt(weights[i]);
        }

        // 第二步：map转为list + 自定义排序
        List<Map.Entry<Integer, int[]>> list = new ArrayList<Map.Entry<Integer, int[]>>(map.entrySet());
        list.sort((o1, o2) -> (o1.getValue()[0]==o2.getValue()[0]?(o1.getValue()[1]-o2.getValue()[1]):(o1.getValue()[0]-o2.getValue()[0])));

        StringBuilder res_str = new StringBuilder();
        for (Map.Entry<Integer, int[]> mapping : list) {
            res_str.append(String.valueOf(mapping.getKey() + 1) + " ");
        }
        System.out.print(res_str.toString().trim());
    }
}
