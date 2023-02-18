package O_D;

/**
 * 找等值元素
 * 给一个二维数组nums，对于每一个元素num[i]，找出距离最近的且值相等的元素，输出横纵坐标差值的绝对值之和，如果没有等值元素，则输出-1。
 * 例如:
 * 输入数组nums为
 * 0 3 5 4 2
 * 2 5 7 8 3
 * 2 5 4 2 4
 * 对于 num[0][0] = 0，不存在相等的值。
 * 对于 num[0][1] = 3，存在一个相等的值，最近的坐标为num[1][4]，最小距离为4.
 * 对于 num[0][2] = 5，存在两个相等的值，最近的坐标为num[1][1]，故最小距离为2.
 * 对于 num[1][1] = 5，存在两个相等的值，最近的坐标为num[2][1]，故最小距离为1。
 * 故输出为
 * -1 4 2 3 3
 * 1 1 -1 -1 4
 * 1 1 2 3 2
 *
 * 输入描述:
 * 输入第一行为二维数组的行，输入第二行为二维数组的列输入的数字以空格隔开。
 * 输出描述:
 * 数组形式返回所有坐标值。
 * 补充说明:
 * 1.针对数组num[i][j]，满足0<i<=100: 0<i<=100.
 * 2.对于每个数字，最多存在100个与其相等的数字
 *
 * 示例1
 * 输入:
 * 3
 * 5
 * 0 3 5 4 2
 * 2 5 7 8 3
 * 2 5 4 2 4
 * 输出:
 * [-1, 4, 2, 3, 3], [1, 1, -1, -1, 4], [1, 1, 2, 3, 2]]
 */
import java.util.Scanner;
import java.util.*;
public class Equivalent {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();

            int[][] matrix = new int[n][m];
            Map<Integer, List<int[]>> num_map = new HashMap<>();
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    int num = in.nextInt();
                    matrix[i][j] = num;
                    //将坐标转化为数组
                    int[] pos = new int[]{i,j};
                    List<int[]> tempList;
                    if(num_map.containsKey(num)){
                        tempList = num_map.get(num);
                    }else {
                        tempList = new ArrayList<>();
                    }
                    tempList.add(pos);
                    num_map.put(num, tempList);
                }
            }

            List<List<Integer>> resList = new ArrayList<>();
            for(int i=0; i<n; i++){
                List<Integer> temp_list = new ArrayList<>();
                for(int j=0; j<m; j++){
                    int num = matrix[i][j];
                    List<int[]> pos_list = num_map.get(num);
                    //无相等值
                    if(pos_list.size() == 1){
                        temp_list.add(-1);
                        continue;
                    }

                    int min_distance = Integer.MAX_VALUE;
                    for(int k=0; k<pos_list.size(); k++){
                        int[] pos = pos_list.get(k);
                        int distance = Math.abs(pos[0]-i) + Math.abs(pos[1]-j);
                        //距离为0则跳过
                        if(distance == 0){
                            continue;
                        }
                        min_distance = Math.min(min_distance, distance);
                    }

                    temp_list.add(min_distance);
                }
                resList.add(temp_list);
            }

            System.out.println(resList);
        }
    }
}
