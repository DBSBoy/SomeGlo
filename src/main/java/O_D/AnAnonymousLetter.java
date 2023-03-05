package O_D;

/**
 * 匿名信
 * 电视剧《分界线》里面有一个片段，男主为了向警察透露案件细节，且不暴露自己，于是将报刊上的字减下来，剪拼成匿名信。
 * 现在又一名举报人，希望借鉴这种手段，使用英文报刊完成举报操作。
 * 但为了增加文章的混淆度，只需满足每个单词中字母数量一致即可，不关注每个字母的顺序。解释：单词on允许通过单词no进行替代。
 * 报纸代表newspaper,匿名信代表anonymousLetter,求报纸内容是否可以拼成匿名信。
 * 输入描述
 * 第一行输入newspaper内容，包括1-N个字符串，用空格分开
 * 第二行输入anonymousLetter内容，包括1-N个字符串，用空格分开
 * .newspaper和anonymousLetter的字符串由小写英文字母组成，且每个字母只能使用一次
 * .newspaper内容中的每个字符串字母顺序可以任意调整，但必须保证字符串的完整性（每个字符串不能有多余字母）
 * .1 < N < 100,
 * 1 <= newspaper.length,anonymousLetter.length <= 10^4
 *
 * 输出描述
 * 如果报纸可以拼成匿名信返回true，否则返回false
 * 示例一
 * 输入
 *
 * ab cd
 * ab
 * 输出
 *
 * true
 *
 * 示例二
 * 输入
 *
 * ab ef
 * aef
 * 输出
 *
 * false
 */
import java.util.Scanner;
import java.util.*;
public class AnAnonymousLetter {
    static class Main {

        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            String newspaper = in.nextLine();
            String anonymousLetter = in.nextLine();
            List<String> newspaperList = sort_string(newspaper);
            List<String> anonymousLetterList = sort_string(anonymousLetter);

            for (String s : anonymousLetterList) {
                if (!newspaperList.contains(s)) {
                    System.out.println(false);
                }
            }
            System.out.println(true);

        }

        // 对string本身字符进行排序
        public static List<String> sort_string(String newspaper) {
            List<String> strings = new ArrayList<>();
            String[] split = newspaper.split(" ");
            for (String s : split) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                strings.add(new String(chars));
            }
            return strings;
        }

    }
}
