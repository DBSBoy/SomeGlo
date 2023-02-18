package O_D;

/**
 * 发现新词的数量 /新词挖掘
 * 小华负责公司知识图谱产品，现在要通过新词挖掘完善知识图谱新词挖掘: 给出一个待挖掘问题内容字符串Content和一人词的字符串word，找到content中所有word的新词。新词: 使用词word的字符排列形成的字符串。
 * 请帮小华实现新词挖掘，返回发现的新词的数量。
 * 输入描述
 * 第一行输入为待挖掘的文本内容content;
 * 第二行输入为词word;
 * 输出描述
 * 在content中找到的所有word的新词的数量
 *
 * 备注
 * 0 ≤ content的长度 ≤10000000。
 *
 * 1 ≤ word的长度≤2000。
 *
 * 示例1：
 *
 * 输入
 * qweebaewqd
 * qwe
 *
 * 输出
 * 2
 *
 * 说明
 * 起始索引等于0的子串是“qwe”，它是word的新词起始索引等于6的子串是“ewg”，它是word的新词
 *
 * 示例2：
 *
 * 输入
 *
 * abab
 * ab
 *
 * 输出
 * 3
 *
 * 说明
 * 起始索引等于0的子串是”ab“它是word的新词它是word的新词起始索引等于1的子串是”ba“起始索引等于2的子串是”ab“，它是word的新词
 */
import java.util.Scanner;
import java.util.*;
public class TheNumberOfNewWords {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            String content = in.nextLine();
            String word = in.nextLine();
            System.out.println(contin(content, word));
        }

        public static int contin(String content, String word){
            if(content.length() < word.length())
                return 0;
            if(word.length() == 0)
                return 0;
            HashMap<Character, Integer> content_map = new HashMap<Character, Integer>();
            HashMap<Character, Integer> word_map = new HashMap<Character, Integer>();
            //先统计出word中的字符组成
            for (int i=0;i<word.length();i++)
                word_map.put(word.toCharArray()[i], word_map.getOrDefault(word.toCharArray()[i], 0) + 1);

            char[] content_arr = content.toCharArray();
            int word_char_kind = word_map.size();
            int right = 0;
            int content_child_char_kind = 0;
            int result = 0;
            while(right < content.length()){
                if(right >= word.length()){
                    int left = right - word.length();
                    if (word_map.containsKey(content_arr[left]) && word_map.get(content_arr[left]) == content_map.get(content_arr[left]))
                        content_child_char_kind -=1 ;
                    content_map.put(content_arr[left], content_map.getOrDefault(content_arr[left], 0) - 1);

                }

                content_map.put(content_arr[right], content_map.getOrDefault(content_arr[right], 0) + 1);
                if (word_map.containsKey(content_arr[right]) && word_map.get(content_arr[right]) == content_map.get(content_arr[right]))
                    content_child_char_kind+=1;
                right+=1;
                if (content_child_char_kind == word_char_kind) {
                    result += 1;
                }
            }
            return result;
        }


    }
}
