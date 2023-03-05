package algorithm.O2;

/**
 * 几何平均值最大子数组
 *  从一个长度为N的正数数组numbers中找出长度至少为L且几何平均值最大子数组，并输出其位置和大小。(K个数的几何平均值为K个数的乘积的K次方根)
 *         若有多个子数组的几何平均值均为最大值，则输出长度最小的子数组，
 *         若有多个长度相同的子数组的几何平均值均为最大值，则输出最前面的子数组。
 *
 * 输入描述:
 * 第一行输入为N、L，N表示numbers的大小(1<=N<=100000)，L表示子数组的最小长度(1<=L<=N)之后N行表示numbers中的N个数，每个一行(-10^9<=numbers<=10^9)。
 * 输出描述:
 * 输出子数组的位置(从0开始计数)和大小，中间用一个空格隔开。
 * 补充说明:
 *
 * 用例保证除几何平均值为最大值的子数组外，其他子数组的几何平均值至少比最大值小最大值的1-10倍
 *
 * 示例1：输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 *
 * 3 2
 *
 * 2
 *
 * 2
 *
 * 3
 * 输出:
 *
 * 1 2
 * 说明:
 * 长度至少为2的子数组有3个， [2,2] [2,3] [2,2,3] , 几何平均值最大为[2,3]， 输出其位置1和长度2
 *
 * 示例2：输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 *
 * 10 2
 * 0.2
 * 0.1
 * 0.2
 * 0.2
 * 0.2
 * 0.1
 * 0.2
 * 0.2
 * 0.2
 * 0.2
 * 输出:
 *
 * 2 2
 * 说明:
 * 有多个长度至少为2的子数组的几何平均值为0.2，其中长度最短的为2，也有多个，长度为2月几何平均值为0.2的子数组最前面的那个为从第二个数开始的两个0.2组成的子数组
 */
import java.util.Scanner;
public class AverageValue {
    static class Main {
        public static int sub_arr_pos = 0;
        public static int sub_arr_size = 0;
        public static int N;
        public static int L;
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            N = in.nextInt();
            L = in.nextInt();

            // 最大 / 最小值 / 乘积
            double min_num = Integer.MAX_VALUE;
            double max_num = Integer.MIN_VALUE;
            double result = 1;

            double[] nums = new double[N];
            for (int i = 0; i < N; i++) {
                nums[i] = in.nextDouble();
                min_num = Math.min(min_num, nums[i]);
                max_num = Math.max(max_num, nums[i]);
                if (i<L) {
                    result *= nums[i];
                }
            }

            //二分法找几何平均数，注意double数相等的判断方法,leetcode是10^-5次方
            while (max_num - min_num >= Math.pow(10, -5)) {
                double mid_num = (min_num + max_num) / 2;

                if (cal(result, nums, mid_num)) {
                    min_num = mid_num;
                } else {
                    max_num = mid_num;
                }
            }
            System.out.print(sub_arr_pos);
            System.out.print(" ");
            System.out.print(sub_arr_size);
        }

        public static boolean cal(double result,double[] nums, double mid_num) {
            // 利用中间值来进行几何平均值计算
            result = result / Math.pow(mid_num, L);

            //如果大于1，说明[0~L-1]已经大于这个临时的最大几何平均值mid_num, 可以直接返回。
            if (result >= 1) {
                sub_arr_pos = 0;
                sub_arr_size = L;
                return true;
            }

            //否则需要往后延长，继续增加长度，用前缀的方式来保存前面的子数组的乘积
            double pre_result = 1;
            double min_pre_result = Integer.MAX_VALUE;
            int min_pre_result_pos = 0;

            for (int i = L; i < N; i++) {
                result *= nums[i] / mid_num;
                pre_result *= nums[i - L] / mid_num;

                if (pre_result < min_pre_result) {
                    min_pre_result = pre_result;
                    min_pre_result_pos = i - L;
                }

                if (result / min_pre_result >= 1) {
                    sub_arr_pos = min_pre_result_pos + 1;
                    sub_arr_size = i - min_pre_result_pos;
                    return true;
                }
            }

            return false;
        }


    }
}
