package O_D;

/**
 * 开放日活动
 *
 * 某部门开展Family Day开放日活动，其中有个从桶里取球的游戏，游戏规则如下:有N个容量一样的小桶等距排开，且每个小桶都默认装了数量不等的小球，
 * 每个小桶装的小球数量记录在数组 bucketBallNums 中,游戏开始时，要求所有桶的小球总数不能超过 SUM，
 * 如果小球总数超过 SUM，则需对所有的小桶统一设置一个容量最大值 maxcapacity并需将超过容量最大值的小球拿出来，直至小桶里的小球数量小于 maxcapacity;请您根据输入的数据，计算从每个小桶里拿出的小球数量，
 *
 * 限制规则一:
 * 所有所有小桶的小球总和小于 SUM，则无需设置容量值，并且无需从小桶中拿球出来，返回结果[];
 *
 * 限制规则二:
 * 如果所有小桶的小球总和大于 SUM，则需设置容量最大值 maxcapacity并且需从小桶中拿球出来，返回从每个小桶拿出的小球数量组成的数组;
 * 输入描述
 *
 * 第一行输入2个正整数，数字之间使用空格隔开，其中第一个数字表示 SUM ，第二个数字表示 bucketBallNums 数组长度:第二行输入N个正整数，数字之间使用空格隔开，表示 bucketBallNums 的每一项:
 * 输出描述
 *
 * 数组剩余小球。
 *
 * 示例一
 *
 * 输入
 *
 * 14 7
 * 2 3 2 5 5 1 4
 *
 * 输出
 * [0,1,0,3,3,0,2]
 */
import java.util.Scanner;
import java.util.*;
public class OpenDay {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int sum = in.nextInt();
            int nums = in.nextInt();
            int[] balls = new int[nums];
            for (int i = 0; i < nums; i++) {
                balls[i] = in.nextInt();
            }

            int total =  Arrays.stream(balls).sum();
            if (total <= sum) {
                System.out.println("[]");
                return;
            }
            int[] tmp = new int[balls.length];
            int[] result = new int[balls.length];
            // i 表示的就是最大容量
            for (int i = sum; true; i--) {
                for (int k = 0; k < balls.length; k++) {
                    if (balls[k] > i) {
                        result[k] = balls[k] - i;
                        tmp[k] = i;
                    } else {
                        result[k] = 0;
                        tmp[k] = balls[k];
                    }
                }
                if (Arrays.stream(tmp).sum() <= sum) {
                    System.out.println(Arrays.toString(result).replaceAll(" ", ""));
                    break;
                }
            }
        }

    }
}
