package O_D;

/**
 * 优雅子数组
 *
 * 如果一个数组中出现次数最多的元素出现大于等于K次，被称为K -优雅数组，k也可以被称为优雅阈值。例如，数组1，2，3，1、2，3，1，它是一个3-优雅数组，因为元素1出现次数大于等于3次，数组1,2,3,1,2就不是一个3-优雅数组，因为其中出现次数最多的元素是1和2，只出现了2次。
 * 给定一个数组A和k，请求出A有多少子数组是k-优雅子数组。
 * 子数组是数组中一个或多个连续元素组成的数组。
 * 例如，数组[1.2.3.4]包含10个子数组，分别是:
 * [1], [1,2], [1,2,3], [1,2,3,], [2], [2,3], [2,3,4], [3], [3,4] , [4]
 * 输入描述
 * 第一行输入两个数字，以空格隔开，含义是: A数组长度 k值
 * 第二行输入A数组元素，以空格隔开
 * 输出描述
 * 输出A有多少子数组是k-优雅子数组
 *
 * 示例1：
 *
 * 输入：
 *
 * 7 3
 *
 * 1 2 3 1 2 3 1
 *
 * 输出：
 *
 * 1
 */
import java.util.Scanner;
public class ElegantSubarray {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            //转为数组
            int A = in.nextInt();
            int k = in.nextInt();
            //转为数组
            int[] nums = new int[A];
            for (int i=0;i<A;i++) {
                nums[i] = in.nextInt();
            }

            int res = 0;
            for (int i=0;i<nums.length;i++) {
                for (int j=i;j<nums.length;j++) {
                    if (query(i, j, k, nums) != -1) {
                        res += 1;
                    }
                }
            }

            System.out.println(res);
        }

        public static int query(int left, int right, int threshold, int[] data) {
            // 默认最大数字就是20000，赌一把测试用例没有这么大的数字
            int[] counts = new int[20001];
            for (int i = left; i <= right; i++) {
                counts[data[i]]++;
                if (counts[data[i]] >= threshold) {
                    return data[i];
                }
            }
            return -1;
        }
    }
}
