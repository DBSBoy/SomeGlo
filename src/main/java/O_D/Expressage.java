package O_D;

/**
 * 计算快递业务主站点
 * 快递业务范围有N个站点，A站点与B站点可以中转快递，则认为A-B站可达，如果A-B可达，B-C可达，则A-C达。现在给N个站点编号0、1、...n-1，用s[i][j] 表示i-j是否可达，s[i][j] =1表示i-j可达，s[i][j] =0表示i-j不可达。现用二维数组给定N个站点的可达关系，请计算至少选择从几个主站点出发，才能可达所有站点(覆盖所有站点业)
 * 说明: s[i][j] 与s [j][i] 取值相同
 * 输入描述:
 * 第一行输入为N，N表示站点个数之后N行表示站点之间的可达关系，第i行第i个数值表示编号为i和之间是否可达输出描述:
 * 输出站点个数，表示至少需要多少个主站点
 * 补充说明:
 * 1<N<10000
 *
 * 示例1
 * 输入:
 * 4
 * 1 1 1 1
 * 1 1 1 0
 * 1 1 1 0
 * 1 0 0 1
 * 输出:
 *
 * 1
 * 说明:
 * 选择0号站点作为主站点，0站点可达其他所有站点，所以至少选择1个站点作为主站才能覆盖所有站点业务。
 *
 */
import java.util.Scanner;
import java.util.*;
public class Expressage {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int N = in.nextInt();

            int[][] matrix = new int[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    matrix[i][j] = in.nextInt();
                }
            }
            //已经有连通的站点
            Set<Integer> site_set = new HashSet<>();
            //需要遍历的次数
            int res = 0;
            for(int i=0; i<N; i++){
                //当前站点已经可以达到
                if(site_set.contains(i)){
                    continue;
                }
                Set<Integer> temp = new HashSet<>();
                temp.add(i);
                check(temp, i, matrix);
                site_set.addAll(temp);
                res ++;
            }

            System.out.println(res);

        }

        public static void check(Set<Integer> site_set, int n, int[][] matrix){

            for(int i=0; i<matrix.length; i++){
                if(site_set.contains(i)){
                    continue;
                }
                if(n != i && matrix[n][i] == 1){
                    site_set.add(i);
                    check(site_set, i,matrix);
                }
            }

        }
    }
}
