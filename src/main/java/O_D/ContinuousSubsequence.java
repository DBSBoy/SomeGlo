package O_D;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 最多等和不相交连续子序列
 * 去除文本多余空格，但不去除配对单引号之间的多余空格。给出关键词的起始和结束下标，去除多余空格后刷新关键词的起始和结束下标。
 * 输入描述:
 * 输入为两行字符串:
 * 第一行: 待去除多余空格的文本，用例保证如果有单引号，则单引号成对出现，且单引号可能有多对.第二行: 关键词的开始和结束坐标，关键词间以逗号区分，关键词内的开始和结束位置以单空格区分
 * 例如:
 * Life is painting a picture, not doing 'a sum'
 * 8 15,20 26,43 45
 * 关键单词为: painting picture sum
 * 输出描述:
 * 输出为两行字符串:
 * 第一行: 去除多余空格后的文本
 * 第二行: 去除多余空格后的关键词的坐标开始和结束位置，为数组方式输出
 * 例如:
 * Life is painting a  picture, not doing 'a sum'
 *
 * [8,15][19, 25][42, 44]
 *
 * 条件约束:
 * 1，不考虑关键词起始和结束位置为空格的场景
 * 2，单词的的开始和结束下标保证涵盖一个完整的单词，即一个坐标对开始和结束下标之间不会有多余的空格:
 * 3，如果有单引号，则用例保证单引号成对出现:
 * 4，关键词可能会重复:
 * 5，文本字符长度length取值范围: [0,100000]:
 *
 * 示例1
 * 输入
 * Life is painting a  picture, not doing 'a sum'  (a和picture之间有两个空格)
 *
 * 8 15,20 26,43 45
 * 输出:
 * Life is painting a picture, not doing 'a sum'
 *
 * [8,15][19,25][42, 44]
 */
public class ContinuousSubsequence {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int N = in.nextInt();
            in.nextLine();
            List<Integer> nums =Arrays.stream(in.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            Map<Integer, List<int[]>> map = new HashMap<>();

            //两个for循环遍历所有的连续子数组
            for(int i=0; i<N; i++){
                int count = nums.get(i);
                for (int j=i; j<N; j++){
                    int[] temp = {i, j};   //首坐标i，尾座标j
                    if(i != j){
                        count +=  nums.get(j);
                    }
                    if(map.containsKey(count)){
                        map.get(count).add(temp);
                    }else {
                        List<int[]> tempList = new ArrayList<>();
                        tempList.add(temp);
                        map.put( count, tempList);
                    }
                }
            }

            int res = 0;
            for (List<int[]> list : map.values()){
                res = Math.max(res, removeIntersect(list));
            }

            System.out.println(res);
        }

        // 排除有交集的连续子数组情况
        public static int removeIntersect(List<int[]> list){
            int max = 0;
            for(int i=0; i<list.size(); i++){
                List<int[]> tempList = new ArrayList<>();
                tempList.add(list.get(i));
                int right = list.get(i)[1]; //第一个序列的最后一个元素下标
                for(int j=0; j<list.size(); j++){
                    if(i != j){
                        int left = list.get(j)[0];
                        if(left > right) {  //没有交集
                            tempList.add(list.get(j));
                            right = list.get(j)[1];
                        }
                    }
                }
                max = Math.max( max, tempList.size());
            }

            return max;
        }

    }
}
