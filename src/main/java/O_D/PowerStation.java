package O_D;

/**
 * 荒地建设电站
 * 祖国西北部有一片大片荒地，其中零星的分布着一些湖泊，保护区，矿区.整体上常年光照良好，但是也有一些地区光照不太好。某电力公司希望在这里建设多个光伏电站，生产清洁能源对每平方公里的土地进行了发电评估，其中不能建设的区域发电量为0kw，可以发电的区域根据光照，地形等给出了每平方公里年发电量x千瓦。我们希望能够找到其中集中的矩形区域建设电站，能够获得良好的收益.
 * 输入描述
 * 第一行输入为调研的地区长，宽，以及准备建设的电站【长宽相等，为正方形】的边长最低要求的发电量
 *
 * 之后每行为调研区域每平方公里的发电量
 * 输出描述
 * 输出为这样的区域有多少个
 *
 * 示例1：
 *
 * 输入
 * 2 5 2 6
 * 1 3 4 5 8
 * 2 3 6 7 1
 *
 * 输出
 *
 * 4
 * 输入说明
 * 调研的区域大小为长2宽5的矩形，我们要建设的电站的边长为2，建设电站最低发电量为6.
 * 输出说明
 *
 * 长宽为2的正方形满足发电量大于等于6的区域有4个
 *
 * 示例2：
 *
 * 输入
 *
 * 2 5 1 6
 * 1 3 4 5 8
 * 2 3 6 7 1
 * 输出
 * 3
 */
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
public class PowerStation {


    public static class Main {
        public static void main(String[] args) {
            //处理输入
            Scanner in=new Scanner(System.in);
            List<Integer> params =Arrays.stream(in.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            int n = params.get(0);
            int m = params.get(1);
            int c = params.get(2);
            int k = params.get(3);

            int[][] matrix = new int [n][m];
            for (int i=0;i<n;i++) {
                String[] num_strs =in.nextLine().split(" ");
                for (int j=0;j<m;j++) {
                    matrix[i][j] = Integer.parseInt(num_strs[j]);
                }
            }

            System.out.println(get_area_count(matrix, k, c));
        }

        public static int get_area_count(int[][] mat, int threshold, int c) {
            int n = mat.length;
            int m = mat[0].length;
            int[][] s = new int [n+1][m+1];
            //1、生成前缀和子矩阵
            for (int i = 1; i <= n; ++i){
                for (int j = 1; j <= m; ++j) {
                    //s[i][j]表示以[i,j]作为矩阵最右下角的最大矩阵的前缀和
                    //解释：以点[i,j]作为作为最右下角的最大矩阵的前缀和需要加上点[i-1,j]和点[i,j-1]的前缀和，然而会重复多加一个点[i-1][j-1]的前缀和，所以要减一个
                    s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + mat[i - 1][j - 1];
                }
            }
            int ans = 0;
            //2、遍历前缀和矩阵，获得边长等于c的矩阵
            for (int i = c; i <= n; ++i) {
                for (int j = c; j <= m; ++j) {
                    //重点理解：减去点[i-c][j]和点[i][j-c]的矩阵前缀和，剩下来的为一个边长为c正方形，注意点[i-c][j-c]减了两次，需要加一个回来
                    if (s[i][j] - s[i - c][j] - s[i][j - c] + s[i - c][j - c] >= threshold)
                        ans += 1;
                }
            }
            return ans;
        }

    }
}
