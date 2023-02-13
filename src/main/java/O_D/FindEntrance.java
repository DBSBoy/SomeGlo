package O_D;

/**
 * 查找单入口空闲区域
 * 题目描述:
 * 给定一个 m xn 的矩阵，由若干字符  和0构成，X表示该处已被占据，0"表示该处空闲，请找到最大的单入口空闲区域.
 * 解释:
 * 空闲区域是由连通的O组成的区域，位于边界的0可以构成入口，单入口空闲区域即有目只有一个位于边界的0作为入口的由连通的'O"组成的区域。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“连通”的。
 *
 * 输入描述:
 * 第一行输入为两个数字，第一个数字为行数m，第二个数字列数n，两个数字以空格分隔，1 <= m,n <= 200,剩余各行为矩阵各行元素，元素为'X' 或O，各元素间以空格分隔。
 * 输出描述
 * 若有唯一符合要求的最大单入口空闲区域，输出三个数字，第一个数字为入口行坐标(范围为0-行数-1)，第二个数字为入口列坐标(范围为0~列数-1) ，第三个数字为区域大小，三个数字以空格分隔;若有多个符合要求的最大单入口空闲区域，输出一个数字，代表区域的大小;若没有，输出NULL。
 *
 * 示例1
 * 输入:
 * 4 4
 * X X X X
 *
 * X O O X
 * X O O X
 * X O X X
 * 输出:
 * 3 15
 */
import java.util.Scanner;
import java.util.*;
public class FindEntrance {
    static class Main {
        public static int[] entrances = new int[2];
        public static int count = 0;

        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int m = in.nextInt();
            int n = in.nextInt();

            String[][] matrix = new String[m][n];
            in.nextLine();

            for(int i=0;i<m;i++){
                String[] strs = in.nextLine().split(" ");
                for(int j=0;j<n;j++){
                    matrix[i][j] = strs[j];
                }
            }

            //最大的区域大小
            int result = 0;
            List<int[]> empty_zones = new ArrayList<>();
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(matrix[i][j].equals("O")){
                        matrix[i][j] = "X";
                        List<int[]> coords = new ArrayList<>();    //空闲区域中的坐标集合
                        coords.add(new int[]{i,j});
                        find_zone(m,n, i, j, coords, matrix);

                        if(count == 1){
                            if(result == coords.size()){  //有大小相同的单入口空闲区域，只需要大小，无需坐标
                                empty_zones.clear();
                            }else if(result < coords.size()){
                                empty_zones.clear();
                                empty_zones.add(new int[]{entrances[0], entrances[1], coords.size()});
                                result = coords.size();
                            }
                        }
                        count = 0;  //重置入口数量
                        entrances = new int[2];  //重置入口坐标
                    }
                }
            }

            //输出
            if(empty_zones.size() == 1){
                int[] res = empty_zones.get(0);
                System.out.println(res[0] + " " + res[1] + " " + res[2]);
            }else if(result != 0){
                System.out.println(result);
            }else {
                System.out.println("NULL");
            }

        }

        public static void find_zone(int m, int n, int x,int y,List<int[]> coords, String[][] matrix){

            // 边界
            if(x==0 || x == m-1 || y ==0 || y == n-1){
                count++;  //入口的数量计数
                entrances[0] = x;
                entrances[1] = y;
            }

            // 往右或往下遍历
            if(x<m-1){
                if(matrix[x+1][y].equals("O")){
                    matrix[x+1][y] = "X";
                    coords.add(new int[]{x+1,y});
                    find_zone(m,n, x+1, y, coords, matrix);
                }
            }
            if(y<n-1){
                if(matrix[x][y+1].equals("O")){
                    matrix[x][y+1] = "X";
                    coords.add(new int[]{x,y+1});
                    find_zone(m,n, x, y+1, coords, matrix);
                }
            }
        }

    }
}
