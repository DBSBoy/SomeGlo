package O_D;

/**
 * 最差产品
 * 题目描述:
 * A公司准备对他下面的N个产品评选最差奖，评选的方式是首先对每个产品进行评分，然后根据评分区间计算相邻几个产品中最差的产品。评选的标准是依次找到从当前产品开始前M个产品中最差的产品，请给出最差产品的评分序列。
 * 输入描述:
 * 第一行，数字M，表示评分区间的长度，取值范围是0<M<10000第二行，产品的评分序列，比如[12,3,8,6,5]，产品数量N范围是-10000<N<10000
 * 输出描述:
 * 评分区间内最差产品的评分序列
 *
 * 示例1
 * 输入:
 * 3
 * 12,3,8,6,5
 * 输出:
 * 3,3,5
 * 说明:
 * 12.3.8 最差的是3
 * 3.8,6 中最差的是3
 * 8.6.5 中最差的是5
 */
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
import java.math.BigInteger;
public class WorstProduct {


    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int M = in.nextInt();
            in.nextLine();
            List<Integer> nums =Arrays.stream(in.nextLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            Deque<Integer> dq=new LinkedList<>();
            for(int i = 0; i < nums.size(); i++) {
                if(i >= M) {
                    // 输出单调队列队首元素，该元素即为移动前滑动窗口的最小值
                    System.out.print(dq.peekFirst());
                    System.out.print(",");
                    // 如果移动到当前滑动窗口位置后，出去的元素恰好是单调队列最小元素，则出队它
                    if(nums.get(i - M) == dq.peekFirst()) {
                        dq.pollFirst();
                    }
                }
                // 队列不为空且队列中最后的元素大于当前元素
                // 将队列最后元素出队
                // 因为它不可能成为最小元素了
                while(!dq.isEmpty() && dq.peekLast() > nums.get(i)) {
                    dq.pollLast();
                }
                // 当前元素入队
                dq.addLast(nums.get(i));
            }
            System.out.print(dq.peekFirst());

        }

    }
}
