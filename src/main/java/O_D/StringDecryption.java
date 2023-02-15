package O_D;

/**
 * 字符串解密
 * 给定两个字符串string1和string2。
 * string1是一个被加扰的字符串。string1由小写英文字母('a'~'z')和数字字符('0'~'9')组成，而加扰字符串由'0'~'9'、'a'~'f'组成。string1里面可能包含0个或多个加扰子串，剩下可能有0个或多个有效子串，这些有效子串被加扰子串隔开。
 * string2是一个参考字符串，仅由小写英文字母('a'~'z')组成。
 * 你需要在string1字符串里找到一个有效子串，这个有效子串要同时满足下面两个条件:
 * (1)这个有效子串里不同字母的数量不超过且最接近于string2里不同字母的数量，即小于或等于string2里不同字母的数量的同时且最大。
 * (2)这个有效子串是满足条件(1)里的所有子串(如果有多个的话)里字典序，最大的一个。
 * 如果没有找到合适条件的子串的话，请输出"Not Found"
 *
 * 示例:
 * 输入字符串string1为"thisisanewday111forme"，输入字符串string2为"good"。
 *
 * string1里有效子串和加扰子串分割后可表示为:"thisis"+"a"+"n"+"e"+"w"+"da"+"y"+"111f"+"orm"+"e"，去除加扰子串("a"、"e"、"da"、"111f"、"e")后的有效子串候选为("thisis"，"n"，"w""y"，"orm")。
 *
 * 输入字符串string2里不同字母的数量为3('g'、'o'、'd')，从有效子串候选里可以找出"orm"满足要求，其不同字母的数量为3，最接近于string2不同字母的数量。
 *
 * 输入描述:
 * input_string1 input_string2
 * 说明:输入为两个字符串，第1行是题目里的string1(被加扰的字符串)，第2行是题目里的strinq2(参考字符串)
 * 输出描述:
 * output_string
 */
import java.util.*;
public class StringDecryption {
    static class Main {
        public static void main(String[] args) {
            // 输入处理
            Scanner in = new Scanner(System.in);
            String[] valids = in.nextLine().split("[0-9a-f]+");
            int count = distinct_length(in.nextLine());

            String[] res_list = Arrays.stream(valids).filter(valid -> !"".equals(valid) && distinct_length(valid) <= count).toArray(String[]::new);

            //按相应长度排序
            Arrays.sort(res_list, (a,b)->{
                int c1 = distinct_length(a);
                int c2 = distinct_length(b);
                return c1 != c2 ? c2 - c1 : b.compareTo(a);
            });

            System.out.println(res_list.length == 0 ? "Not Found" : res_list[0]);
        }

        // 字符串去重后个数
        public static int distinct_length(String s){
            Set<Character> set = new HashSet<>();
            for(char c : s.toCharArray()){
                set.add(c);
            }

            return set.size();
        }


    }
}
