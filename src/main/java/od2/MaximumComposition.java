package od2;

import java.util.Scanner;
import java.util.*;

/**
 * 组成最大数
 */
public class MaximumComposition {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        StringBuilder res_str = new StringBuilder();

        // 自定义排序方法
        Arrays.stream(in.nextLine().split(","))
                .sorted((s1, s2) -> {
                    char[] s1_array = s1.toCharArray();
                    char[] s2_array = s2.toCharArray();
                    int len1 = s1_array.length;
                    int len2 = s2_array.length;
                    // 长度若相等，比大小
                    if (len1 == len2) {
                        return s2.compareTo(s1);
                    }

                    //长度不相等，逐个字符比较
                    int min = Math.min(len1, len2);
                    for (int i = 0; i < min; i++) {
                        char c1 = s1_array[i];
                        char c2 = s2_array[i];
                        if (c1 != c2) {
                            return c2 - c1;
                        }
                    }

                    if (len1 > len2) {
                        return s1_array[0] - s1_array[min];
                    } else {
                        return s2_array[min] - s2_array[0];
                    }
                }).forEach(res_str::append);

        System.out.println(res_str);

    }


}
