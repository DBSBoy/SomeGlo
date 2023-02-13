package O_D;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;

/**
 * 处理器问题
 * 某公司研发了一款高性能AI处理器。每台物理设备具备8颗AI处理器，编号分别为0、1、2、3、4、5、6、7。
 *
 * 编号0-3的处理器处于同一个链路中，编号4-7的处理器处于另外一个链路中，不同链路中的处理器不能通信。
 *
 * 现给定服务器可用的处理器编号数组array，以及任务申请的处理器数量num，找出符合下列亲和性调度原则的芯片组合。
 *
 * 如果不存在符合要求的组合，则返回空列表。
 *
 * 亲和性调度原则：
 *
 * -如果申请处理器个数为1，则选择同一链路，剩余可用的处理器数量为1个的最佳，其次是剩余3个的为次佳，然后是剩余2个，最后是剩余4个。
 *
 * -如果申请处理器个数为2，则选择同一链路剩余可用的处理器数量2个的为最佳，其次是剩余4个，最后是剩余3个。
 *
 * -如果申请处理器个数为4，则必须选择同一链路剩余可用的处理器数量为4个。
 *
 * -如果申请处理器个数为8，则申请节点所有8个处理器。
 *
 * 提示：
 *
 * 任务申请的处理器数量只能是1、2、4、8。
 * 编号0-3的处理器处于一个链路，编号4-7的处理器处于另外一个链路。
 * 处理器编号唯一，且不存在相同编号处理器。
 * 输入描述
 *
 * 输入包含可用的处理器编号数组array，以及任务申请的处理器数量num两个部分。
 *
 * 第一行为array，第二行为num。例如：
 *
 * [0, 1, 4, 5, 6, 7]
 *
 * 表示当前编号为0、1、4、5、6、7的处理器可用。任务申请1个处理器。
 *
 * 0 <= array.length <= 8
 *
 * 0 <= array[i] <= 7
 *
 * num in [1, 2, 4, 8]
 *
 * 输出描述
 *
 * 输出为组合列表，当array=[0，1，4，5，6，7]，num=1 时，输出为[[0], [1]]。
 *
 * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * [0, 1, 4, 5, 6, 7]
 *
 * 输出
 *
 * [[0], [1]]
 *
 * 说明
 *
 * 根据第一条亲和性调度原则，在剩余两个处理器的链路（0, 1, 2, 3）中选择处理器。
 *
 * 由于只有0和1可用，则返回任意一颗处理器即可。
 */
public class Processor {


    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            Integer[] cores = Arrays.stream(in.nextLine().split("[\\[\\]\\,\\s]"))
                    .filter(str -> !"".equals(str))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            int target = in.nextInt();

            //初始化两个链路剩余可用的处理器
            ArrayList<Integer> processors_1 = new ArrayList<>();
            ArrayList<Integer> processors_2 = new ArrayList<>();

            Arrays.sort(cores, (a, b) -> a - b);
            for (Integer core : cores) {
                if (core < 4) {
                    processors_1.add(core);
                } else {
                    processors_2.add(core);
                }
            }

            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            int length_1 = processors_1.size();
            int length_2 = processors_2.size();

            switch (target) {
                case 1:
                    if (length_1 == 1 || length_2 == 1) {
                        if (length_1 == 1) dfs(processors_1, 0, 1, new ArrayList<>(), result);
                        if (length_2 == 1) dfs(processors_2, 0, 1, new ArrayList<>(), result);
                    } else if (length_1 == 3 || length_2 == 3) {
                        if (length_1 == 3) dfs(processors_1, 0, 1, new ArrayList<>(), result);
                        if (length_2 == 3) dfs(processors_2, 0, 1, new ArrayList<>(), result);
                    } else if (length_1 == 2 || length_2 == 2) {
                        if (length_1 == 2) dfs(processors_1, 0, 1, new ArrayList<>(), result);
                        if (length_2 == 2) dfs(processors_2, 0, 1, new ArrayList<>(), result);
                    } else if (length_1 == 4 || length_2 == 4) {
                        if (length_1 == 4) dfs(processors_1, 0, 1, new ArrayList<>(), result);
                        if (length_2 == 4) dfs(processors_2, 0, 1, new ArrayList<>(), result);
                    }
                    break;
                case 2:
                    if (length_1 == 2 || length_2 == 2) {
                        if (length_1 == 2) dfs(processors_1, 0, 2, new ArrayList<>(), result);
                        if (length_2 == 2) dfs(processors_2, 0, 2, new ArrayList<>(), result);
                    } else if (length_1 == 4 || length_2 == 4) {
                        if (length_1 == 4) dfs(processors_1, 0, 2, new ArrayList<>(), result);
                        if (length_2 == 4) dfs(processors_2, 0, 2, new ArrayList<>(), result);
                    } else if (length_1 == 3 || length_2 == 3) {
                        if (length_1 == 3) dfs(processors_1, 0, 2, new ArrayList<>(), result);
                        if (length_2 == 3) dfs(processors_2, 0, 2, new ArrayList<>(), result);
                    }
                    break;
                case 4:
                    if (length_1 == 4 || length_2 == 4) {
                        if (length_1 == 4) result.add(processors_1);
                        if (length_2 == 4) result.add(processors_2);
                    }
                    break;
                case 8:
                    if (length_1 == 4 && length_2 == 4) {
                        result.add(
                                Stream.concat(processors_1.stream(), processors_2.stream())
                                        .collect(Collectors.toCollection(ArrayList<Integer>::new)));
                    }
                    break;
            }
            System.out.println(result.toString());
        }

        public static void dfs(ArrayList<Integer> cores,int index,int level,ArrayList<Integer> path,ArrayList<ArrayList<Integer>> res) {
            if (path.size() == level) {
                res.add((ArrayList<Integer>) path.clone());
                return;
            }

            for (int i = index; i < cores.size(); i++) {
                path.add(cores.get(i));
                // 逐个往后找合适的组合
                dfs(cores, i + 1, level, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
}
