package O_D;

/**
 * 学校选址
 * 为了解新学期学生暴涨的问题,小乐村要建立所新学校
 * 考虑到学生上学安全问题,需要所有学生家到学校的距离最短.
 * 假设学校和所有学生家都走在一条直线之上,请问学校建立在什么位置,
 * 能使得到学校到各个学生家的距离和最短
 * 输入描述
 * 第一行:整数n取值范围[1,1000],表示有n户家庭。
 * 第二行:一组整数m取值范围[0,10000]，表示每户家庭的位置，所有家庭的位置都不相同。
 * 输出描述
 * 一个整数,确定的学校的位置，如果有多个位置,则输出最小的。
 * 示例一
 * 输入
 *
 * 5
 * 0 20 40 10 30
 * 输出
 *
 * 20
 */
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
public class School {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int count = Integer.parseInt(in.nextLine());
            List<Integer> nodes =Arrays.stream(in.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            Collections.sort(nodes);
            if (count % 2 == 0) {
                System.out.println(nodes.get((count-1)/2));
            } else {
                System.out.println(nodes.get(count/2));
            }


        }

    }
}
