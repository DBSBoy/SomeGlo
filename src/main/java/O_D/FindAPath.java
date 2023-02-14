package O_D;

/**
 * 寻找路径
 * 二叉树也可以用数组来存储，给定一个数组，树的根节点的值储存在下标1，
 * 对于储存在下标n的节点，他的左子节点和右子节点分别储存在下标2*n和2*n+1，
 * 并且我们用-1代表一个节点为空。
 * 给定一个数组存储的二叉树，试求从根节点到最小的叶子节点的路径，路径由节点的值组成。
 * 输入描述
 * 输入一行为数组的内容，数组的每个元素都是正整数，元素间用空格分割。
 * 注意第一个元素即为根节点的值，即数组的第n元素对应下标n。下标0在树的表示中没有使用，所以我们省略了。
 * 输入的树最多为7层。
 * 输出描述
 * 输出从根节点到最小叶子节点的路径上各个节点的值由空格分割用例保证最小叶子节点只有一个
 * 示例一
 * 输入
 *
 * 3 5 7 -1 -1 2 4
 * 输出
 *
 * 3 7 2
 *
 * 示例二
 * 输入
 *
 * 5 9 8 -1 -1 7 -1 -1 -1 -1 -1 6
 * 输出
 *
 * 5 8 7 6
 */
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
public class FindAPath {
    static class Main {

        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            List<Integer> nodes =Arrays.stream(in.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            int[] ints = new int[nodes.size() + 1];
            int minValue = Integer.MAX_VALUE;
            int minPos = 0;

            for (int i = 1; i < ints.length; i++) {
                ints[i] = nodes.get(i - 1);
                // 找到最小叶子节点对应的索引
                if (i > 1 && ints[i] != -1 && ints[i] < minValue) {
                    minValue = ints[i];
                    minPos = i;
                }
            }
            //往上遍历
            List<Integer> path = new ArrayList<>();
            while (minPos >= 1) {
                path.add(ints[minPos]);
                minPos /= 2;
            }

            for (int i = path.size() - 1; i >= 0; i--) {
                System.out.print(path.get(i));
                if (i != 0) {
                    System.out.print(" ");
                }
            }
        }

    }
}
