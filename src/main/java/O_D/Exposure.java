package O_D;

/**
 * 自动曝光
 * 一个图像有n个像素点，存储在一个长度为n的数组img里，每个像素点的取值范围[0,255]的正整数。
 * 请你给图像每个像素点值加上一个整数k（可以是负数），得到新图newImg，使得新图newImg的所有像素平均值最接近中位值128。
 * 请输出这个整数k。
 * 输入描述
 *
 * n个整数，中间用空格分开
 *
 * 例如
 *
 * 0 0 0 0
 *
 * 4个数值，中间用空格分开
 *
 * 输出描述
 *
 * 一个整数k
 *
 * 补充说明
 *
 * • 1 <= n <= 100
 * • 如有多个整数k都满足，输出小的那个k；
 * • 新图的像素值会自动截取到[0,255]范围。当新像素值<0，其值会更改为0；当新像素值>255，其值会更改为255；
 *
 * 例如newImg=”-1 -2 256″,会自动更改为”0 0 255″
 *
 * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 0 0 0 0
 *
 * 输出
 *
 * 128
 */
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
public class Exposure {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            //转为数组
            List<Integer> nums =Arrays.stream(in.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            double offset = 128 - nums.stream().reduce(Integer::sum).orElse(0) * 1.0 / nums.size();
            offset = fixOffset(nums, offset, getCount(nums, offset));
            offset = offset - Math.floor(offset) <= 0.5 ? Math.floor(offset) : Math.ceil(offset);
            System.out.println((int) offset);
        }

        public static int getCount(List<Integer> nums, double offset) {
            int count = 0;
            for (Integer num : nums) {
                double temp = num + offset;
                if (temp < 0 || temp > 255) {
                    count++;
                }
            }
            return count;
        }

        public static double fixOffset(List<Integer> nums, double offset, int count) {
            if (count == 0) {
                return offset;
            }
            double offsetOld = offset;
            for (Integer num : nums) {
                double temp = num + offsetOld;
                if (temp < 0) {
                    offset += temp / (nums.size() - count);
                } else if (temp > 255) {
                    offset += (temp - 255) / (nums.size() - count);
                }
            }
            return fixOffset(nums, offset, getCount(nums, offset) - count);
        }

    }
}
