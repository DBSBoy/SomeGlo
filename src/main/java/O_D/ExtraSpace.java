package O_D;
import java.util.Scanner;
import java.util.*;

/**
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
public class ExtraSpace {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            String input_str = in.nextLine();
            String[] keywords = in.nextLine().split(",");

            List<int[]> coords = new ArrayList<>();
            int count = 0;  //空格个数

            for(String keyword : keywords){
                String[] keyword_coord = keyword.split(" ");
                int start = Integer.parseInt(keyword_coord[0]);
                int end = Integer.parseInt(keyword_coord[1]);
                int left_space_count = 0;
                int right_space_count = 0;
                int[] coord = new int[2];
                if(!check(start, input_str)){
                    left_space_count = left_space_count(start, input_str);
                    right_space_count = right_space_count(end, input_str);
                }

                coord[0] = start - count - left_space_count;
                coord[1] = end - count - left_space_count;
                count += left_space_count + right_space_count;    //记录总共去除的空格数
                coords.add(coord);
            }

            String res = "";
            for(int[] coord : coords){
                res += coord[0] + " " + coord[1] + ",";
            }

            System.out.println(res.substring(0, res.length()-1));
        }

        public static int left_space_count(int index, String input_str){
            int count = 0;
            if(index == 0){
                return count;
            }else {
                while (true){
                    index --;
                    if(index >= 0 && input_str.charAt(index) == ' '){
                        count ++;
                    }else {
                        break;
                    }
                }
            }
            return count > 1 ? count - 1 : 0;   //空格数小于等于1时，多余空格数为0
        }

        public static int right_space_count(int index, String input_str){
            int count = 0;
            if(index == 0){
                return count;
            }else {
                while (true){
                    index ++;
                    if(index < input_str.length() && input_str.charAt(index) == ' '){
                        count ++;
                    }else {
                        break;
                    }
                }
            }
            return count > 1 ? count - 1 : 0;
        }

        public static boolean check(int start ,String input_str){
            String str1 = input_str.substring( 0, start);
            int count = 0;
            //判断左侧是否有奇数个单引号出现
            for(int i=0; i<str1.length(); i++){
                if(str1.charAt(i) == '\''){
                    count ++;
                }
            }

            return count%2 == 0 ? false : true;
        }

    }
}
