package O_D;

/**
 * 给定两个数组a，b，若a[i] == b[j] 则称 [i, j] 为一个二元组，求在给定的两个数组中，二元组的个数。
 *
 * 输入描述：
 * 第一行输入 m
 * 第二行输入m个数，表示第一个数组
 *
 * 第三行输入 n
 * 第四行输入n个数，表示第二个数组
 *
 * 输出描述：
 *
 * 二元组个数。
 *
 * 示例1：
 *
 * 输入：
 *
 * 4
 *
 * 1 2 3 4
 *
 * 1
 *
 * 1
 *
 * 输出：
 *
 * 1
 */
import java.util.Scanner;
import java.util.*;
public class LongestPwd {
    static class Main {
        public static int min_times;
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            String[] strs = in.nextLine().split(" ");

            // 将所有字符串放入哈希集合
            HashSet<String> word_set=new HashSet<>();
            for (String s : strs) {
                word_set.add(s);
            }

            // 真正的密码
            String true_pass_word="";

            //按顺序检查每一个词
            for (String s : strs) {
                // 条件1：检查这个词所有以索引0开头的子串在数组中是否都有
                boolean flag=true;
                for(int i=1;i<s.length();i++){
                    // 以索引0开头的子串
                    String sub_str=s.substring(0,i);
                    if(!word_set.contains(sub_str)){
                        flag=false;
                        break;
                    }
                }

                if(flag){
                    // 条件2：比较密码长度
                    if(s.length()>true_pass_word.length())
                        true_pass_word=s;
                    // 条件3：比较密码字典排序
                    if(s.length()==true_pass_word.length()&&s.compareTo(true_pass_word)>0){
                        true_pass_word=s;
                    }
                }
            }

            System.out.println(true_pass_word);
        }
    }
}
