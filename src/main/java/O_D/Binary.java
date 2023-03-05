package O_D;

/**
 * 二进制
 * 对于任意两个正整数A和B，定义它们之间的差异值和相似值：
 * 差异值：A、B转换成二进制后，对于二进制的每一位，对应位置的bit值不相同则为1，否则为0；
 * 相似值：A、B转换成二进制后，对于二进制的每一位，对应位置的bit值都为1则为1，否则为0；
 * 现在有n个正整数A0到A（n-1），问有多少(i, j)0<=i<j<n），Ai和Aj的差异值大于相似值。
 * 假设A=5，B=3；则A的二进制表示101；B的二进制表示011；
 * 则A与B的差异值二进制为110；
 * 相似值二进制为001；
 * A与B的差异值十进制等于6，相似值十进制等于1，满足条件。
 *
 * 输入描述
 *
 * 输入
 *
 * 一个n接下来n个正整数
 *
 * 数据范围：1<=n<=10^5，1<=A[i]<2^30
 *
 * 输出描述
 *
 * 输出
 *
 * 满足差异值大于相似值的对数
 *
 * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 4
 * 4 3 5 2
 *
 * 输出
 *
 * 4
 */
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
public class Binary {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int n = Integer.parseInt(in.nextLine());
            //转为数组
            List<Integer> nums =Arrays.stream(in.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            int res = 0;
            for (int i=0;i<n;i++) {
                for (int j=i+1;j<n;j++) {
                    if ((nums.get(i) ^ nums.get(j)) > (nums.get(i) & nums.get(j))) {
                        res += 1;
                    }
                }
            }


            System.out.print(res);

        }

    }
}
