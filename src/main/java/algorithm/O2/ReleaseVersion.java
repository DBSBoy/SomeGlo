package algorithm.O2;

/**
 * Linux发行版的数量
 * 输入描述:
 * 第一行输入发行版的总数量N，之后每行表示各发行版间是否直接相关
 * 输出描述:
 * 输出最大的发行版集中发行版的数量
 * 补充说明:
 * 1 <= N <= 200
 *
 * 示例1
 *
 * 输入:
 * 4
 * 1 1 0 0
 *
 * 1 1 1 0
 *
 * 0 1 1 0
 *
 * 0 0 0 1
 *
 * 输出:
 * 3
 */
import java.util.Scanner;
import java.util.*;
public class ReleaseVersion {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();

            int[][] matrix = new int[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    matrix[i][j] = in.nextInt();
                }
            }

            //关联过的linux版本
            Set<Integer> linux_version = new HashSet<>();
            int result = 0;
            for(int i=0; i<n; i++){
                if(!linux_version.contains(i)){
                    //当前版本集
                    Set<Integer> current_version_set = new HashSet<>();
                    check(current_version_set, i, matrix);
                    result = Math.max(result, current_version_set.size());
                    linux_version.addAll(current_version_set);
                }
            }

            System.out.println(result);
        }

        public static void check(Set<Integer> current_version_set, int n, int[][] matrix){

            for(int i=0; i<matrix.length; i++){
                if(current_version_set.contains(i)){
                    continue;
                }
                if(n != i && matrix[n][i] == 1){
                    current_version_set.add(i);
                    check(current_version_set, i,matrix);
                }
            }

        }

    }
}
