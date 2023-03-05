package O_D;

/**
 * 数字加减游戏
 *
 * 小明在玩一个数字加减游戏，只使用加法或者减法，将一个数字s变成数字t。
 * 每个回合，小明可以用当前的数字加上或减去一个数字。
 * 现在有两种数字可以用来加减，分别为a,b(a!=b)，其中b没有使用次数限制。
 * 请问小明最少可以用多少次a，才能将数字s变成数字t。
 * 题目保证数字s一定能变成数字t。
 * 输入描述
 * 输入的唯一一行包含四个正整数s,t,a,b(1<=s,t,a,b<=105)，并且a!=b.
 *
 * 输出描述
 * 输出的唯一一行包含一个整数，表示最少需要使用多少次a才能将数字s变成数字t.
 *
 * 示例1
 * 输入:
 * 1 10 5 2
 * 输出:
 *
 * 1
 */
import java.util.Scanner;
public class AddAndSubtractGame {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int s = in.nextInt();
            int t = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();

            int res = 0;
            int add = s;
            int sub = s;
            while (true){
                if((t - add)%b == 0){
                    break;
                }
                if((t - sub)%b == 0){
                    break;
                }
                add += a;
                sub -= a;
                res++;
            }

            System.out.println(res);
        }
    }
}
