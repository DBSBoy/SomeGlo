package O_D;

/**
 * 密室逃生
 *
 * 小强增在参加《密室逃生》游戏，当前关卡要求找到符合给定密码K（升序的不重复小写字母组成）的箱子，
 * 并给出箱子编号，箱子编号为1~N。
 * 每个箱子中都有一个字符串s，字符串由大写字母、小写字母、数字、标点符号、空格组成，
 * 需要在这些字符串中找到所有的字母，忽略大小写后排列出对应的密码串儿，并返回匹配密码的箱子序号。
 * 提示：
 * 满足条件的箱子不超过1个
 * 输入描述
 * 第一行为key的字符串，
 * 第二行为箱子boxes，为数组样式，以逗号分隔箱子N数量满足1≤N≤10000,
 * s长度满足0≤s.length≤50，
 * 密码为仅包含小写字母的升序字符串，且不存在重复字母，密码K长度K.length，1≤K.length≤26
 * 输出描述
 * 返回对应箱子编号
 * 如不存在符合要求的密码箱，则返回-1
 * 示例一
 * 输入
 *
 * abc
 * s,sdf134 A2c4b
 * 输出
 *
 * 2
 * 说明
 * 第2个箱子中的Abc，符合密码abc
 * 示例二
 * 输入
 *
 * abc
 * s,sdf134 A2c4bd 523[]
 *
 * 输出
 *
 * -1
 */
import java.util.Scanner;
import java.util.*;
public class EscapeRoom {
    static class Main {

        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            String key =in.nextLine();
            String[] boxes=in.nextLine().substring(2).split(" ");

            for (int i = 0; i < boxes.length; i++) {
                //先全部转为小写字母
                String lower = boxes[i].toLowerCase();
                TreeSet<Character> chars = new TreeSet<>();
                for (char c : lower.toCharArray()) {
                    if (c >= 'a' && c <= 'z') {
                        chars.add(c);
                    }
                }
                if (chars.size() == key.length()) {
                    StringBuilder builder = new StringBuilder();
                    for (Character c : chars) {
                        builder.append(c);
                    }
                    if (builder.toString().equals(key)) {
                        System.out.println(i+1);
                        return;
                    }
                }
            }
            System.out.println(-1);

        }

    }
}
