package O_D;

/**
 * 分奖金
 * 公司老板做了一笔大生意，想要给每位员工分配一些奖金，想通过游戏的方式来决定每个人分多少钱。按照员工的工号顺序，每个人随机抽取一个数字。按照工号的顺序往后排列，遇到第一个数字比自己数字大的，那么，前面的员工就可以获得“距离*数字差值”的奖金。如果遇不到比自己数字大的，就给自己分配随机数数量的奖金。例如，按照工号顺序的随机数字是: 2,10.3。那么第2个员工的数字10比第1个员工的数字2大，所以，第1个员工可以获得1*(10-2) =8。第2个员工后面没有比他数字更大的员工，所以，他获得他分配的随机数数量的奖金，就是10。第3个员工是最后一个员工，后面也没有比他更大数字的员工，所以他得到的奖金是3。
 * 请帮老板计算一下每位员工最终分到的奖金都是多少钱
 *
 * 输入描述:
 * 第一行n表示员工数量 (包含最后一个老板)
 * 第二是每位员工分配的随机数字
 * 例如
 * 3
 * 2 10 3
 * 输出描述:
 * 最终每位员工分到的奖金数量
 * 例如
 * 8 10 3
 */
import java.util.Scanner;
import java.util.*;
public class SplitBonus {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int N = in.nextInt();

            int[] nums = new int[N];
            for(int i=0; i<N; i++){
                nums[i] = in.nextInt();
            }

            int[] res = findMax(nums);
            for (int i=0;i<N;i++) {
                if (res[i] == -1) {
                    System.out.print(nums[i]);
                } else {
                    System.out.print(res[i]);
                }
                if (i!=N-1) {
                    System.out.print(" ");
                }
            }


        }

        public static int[] findMax(int[] array) {
            int len =array.length;
            Stack<Integer> st = new Stack<Integer>();
            int res[]=new int[len];
            int i=0;
            while(i<len) {
                if(st.isEmpty()||array[i]<=array[st.peek()]) {
                    st.push(i);
                    i++;
                }else {
                    res[st.peek()]=(array[i] - array[st.peek()]) * (i-st.peek());
                    st.pop();

                }
            }
            while(!st.isEmpty()) {
                res[st.pop()]=-1;
            }
            return res;
        }
    }
}
