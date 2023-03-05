package O_D;

/**
 * 基站维护最短距离
 *     小王是一名基站维护工程师，负责某区域的基站维护。某地方有n个基站(1<n<10)，已知各基站之间的距离 s(0<s<500) 并且基站到基站y的距离，与基站y到基站的距离并不一定会相同。小王从基站1出发，途经每个基站1次，然后返回基站1，需要请你为他选择一条距离最短的路。
 * 输入描述
 * 站点数n和各站点之间的距离(均为整数)。
 * 如:
 * 3{站点数}
 * 0 2 1 {站点1到各站点的路程]
 * 1 0 2 {站点2到各站点的路程]
 * 2 1 0 (站点3到各站点的路程
 * 输出描述
 * 最短路Q程的数值
 *
 * 示例1：
 *
 * 输入：
 *
 * 3
 * 0 2 1
 * 1 0 2
 * 2 1 0
 * 输出：
 *
 * 3
 */
import java.util.Scanner;
public class BaseStation {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            //转为数组
            int n = in.nextInt();
            int[][] matrix = new int[n][n];

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    matrix[i][j] = in.nextInt();
                }
            }

            System.out.println(solve(n, matrix));
        }

        public static int solve(int n, int[][] matrix) {
            int MAX=1<<n;
            int[][] dp = new int[n][1<<n];
            for(int i=0;i<n;i++) {
                for(int j=0;j<(1<<n);j++) {
                    dp[i][j]=n*500;
                }
            }
            for(int i=0;i<n;i++) {
                dp[i][1<<i]=matrix[0][i];
            }

            //j为当前状态
            for(int j=0;j<MAX;j++) {
                //i为当前基站
                for(int i=0;i<n;i++) {
                    if((j&(1<<i))==0) {
                        continue;
                    }  //注意运算符优先级
                    //k为下一个基站
                    for(int k=0;k<n;k++) {
                        dp[i][j]=Math.min(dp[i][j], dp[k][j&(~(1<<i))]+matrix[k][i]);
                    }
                }
            }
            return dp[0][MAX-1];
        }

    }
}
