package O_D;

/**
 * 快速开租建站
 * 当前IT部门支撑了子公司颗粒化业务，该部门需要实现为子公司快速开租建站的能力，建站是指在一个全新的环境部署一套IT服务。
 * １：每个站点开站会由一系列部署任务项构成，每个任务项部署完成时间都是固定和相等的，设为1.
 * ２：部署任务项之间可能存在依赖，假如任务2依赖任务1，那么等任务1部署完，任务2才能部署。
 * ３：任务有多个依赖任务则需要等所有依赖任务都部署完该任务才能部署。
 * ４：没有依赖的任务可以并行部署，优秀的员工们会做到完全并行无等待的部署。
 * 给定一个站点部署任务项和它们之间的依赖关系，请给出一个站点的最短开站时间。
 * 输入描述
 * 第一行是任务数taskNum,
 *
 * 第二行是任务的依赖关系数relationsNum接下来 relationsNum 行，每行包含两个id，描述一个依赖关系，格式为: IDi　IDj，表示部署任务部署完成了，部署任务自容署，IDi 和 IDj值的范围为: [0,taskNum)
 * 注: 输入保证部署任务之间的依赖不会存在环。
 *
 * 输出描述
 * 1个整数，表示一个站点的最短开站时间。
 * 备注
 * 1 < taskNum ≤ 100
 * 1 ≤ relationsNum ≤ 5000
 *
 * 示例1：
 *
 * 输入
 * 5
 *
 * 5
 * 0 4
 * 1 2
 * 1 3
 *
 * 2 3
 *
 * 2 4
 * 输出
 * 3
 */
import java.util.Scanner;
import java.util.*;
public class BuildStation {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int taskNum = in.nextInt();
            int relationsNum = in.nextInt();

            int[][] relation_ids = new int[relationsNum][2];
            for (int i = 0; i < relationsNum; i++) {
                relation_ids[i][0] = in.nextInt();
                relation_ids[i][1] = in.nextInt();
            }

            // 每个任务的前置依赖任务个数，也就是拓扑排序中的入度
            int[] upstream = new int[taskNum];
            // 每个任务的下游任务， 也就是拓扑排序中的出度
            List<List<Integer>> downstream =new ArrayList<List<Integer>>(taskNum);
            for (int i=0;i<taskNum;i++) {
                downstream.add(new ArrayList<>());
            }

            //初始化入度、出度
            for (int[] relation_id : relation_ids) {
                downstream.get(relation_id[0]).add(relation_id[1]);
                upstream[relation_id[1]]+=1;
            }

            //队列中保存当前入度为0 的任务id
            LinkedList<Integer[]> queue = new LinkedList<>();
            int result = 1;

            for (int i = 0; i < taskNum; i++) {
                //将所有入度为零的任务入队, 默认耗时为1
                if (upstream[i] == 0) {
                    queue.add(new Integer[] {i, result});
                }
            }

            while (queue.size() > 0) {
                Integer[] current_task = queue.removeFirst();
                int task = current_task[0];
                int time = current_task[1];

                for (Integer downstream_task : downstream.get(task)) {
                    // 当前任务的入度减小到0时，放入queue中
                    if (--upstream[downstream_task] == 0) {
                        result = time + 1;
                        queue.add(new Integer[] {downstream_task, result});
                    }
                }

            }

            System.out.println(result);

        }

    }
}
