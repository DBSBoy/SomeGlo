package algorithm.O2;

/**
 * 服务中心选址
 *  一家快递公司希望在一条街道建立新的服务中心。公司统计了该街道中所有区域在地图上的位置，并希望能够以此为依据为新的服务中心选址：使服务中心到所有区域的距离的总和最小。
 *
 *         给你一个数组 positions ，其中 positions []=[ left , right ]表示第1个区域在街道上的位置，其中 left 代表区域的左侧的起点， right 表示区域的右侧终点，设择服务中心的位置为 location ,
 *
 *         如果第1个区城的右侧起点 right 满足 right < location ，则第1个区域到服务中心的距离为 location - right ; ．如果第 i 个区域的左侧起点 left 满足 left > location ，则第 i 个区城到服务中心的距离为 left - location ;
 *
 *         如果第 i 个区域的两侧 left , right 满足 left <= location <= right ，则第1个区域到 服务中心的距离为0; 选择最佳的服务中心的位置为 location ，请返回最佳的服务中心位置到所有区域的距离总和的最小值。
 *
 * 输入描述：
 * 第一行，一个整数N表示区域个数。
 * 后面N行，每行两个整数，表示区域的左右起点终点。
 * 输出描述：
 *
 * 运行结果输出一个整数，表示服务中心位置到所有区域的距离总和的最小值
 *
 * 示例1：输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 3
 *
 * 1 2
 *
 * 3 4
 *
 * 10 20
 *
 * 输出
 *
 * 8
 */
import java.util.Scanner;
import java.util.*;
public class ServiceCenter {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            //转为数组
            // 处理输入
            int n = in.nextInt();

            //转化为点
            int[] points = new int[n];
            for(int i = 0;i<n;i++){
                int a = in.nextInt();
                int b = in.nextInt();
                if (i==0) {
                    points[i] = b;
                } else if (i==n-1) {
                    points[i] = a;
                } else {
                    if (i<n/2) {
                        points[i] = b;
                    } else {
                        points[i] = a;
                    }
                }
            }
            // 按照点大小排序
            Arrays.sort(points);

            // 最佳位置
            int pos = -1;
            if(n%2==0) {
                pos =  (n-1)/2;
            } else {
                pos = n/2;
            }

            //计算距离
            int result =0;
            for (int i=0;i<n;i++) {
                if (i!=pos) {
                    result += Math.abs(points[i]-points[pos]);
                }
            }

            System.out.println(result);
        }
    }
}
