package algorithm.O2;

/**
 * 微服务的集成测试
 * 现在有n个容器服务，服务的启动可能有一定的依赖性(有些服务启动没有依赖)，其次服务自身启动加载会消耗些时间。
 * 给你一个nxn 的二维矩阵 useTime，其中 useTime[i][i]=10 表示服务i自身启动加载需要消耗10s，useTime[i][j]=1 表示服务i 启动依赖服务i 启动完成，useTime[i][k]=0，表示服务i 启动不依赖服务 k其实 0<= i,j，k< n。服务之间启动没有循环依赖(不会出现环)，若想对任意一个服务i进行集成测试(服务追身也需要加载)，求最少需要等待多少时间。
 * 输入描述
 * 第一行输入服务总量 n.
 *
 * 之后的 n 行表示服务启动的依赖关系以及自身启动加载耗时
 *
 * 最后输入 k 表示计算需要等待多少时间后可以对服务 k 进行集成测试
 *
 * 其中 1 <= k <=n. 1<=n<=100
 * 输出描述
 * 最少需要等待多少时间(s)后可以对服务 k 进行集成测试
 *
 * 示例1
 *
 * 输入:
 *
 * 3
 *
 * 5 0 0
 *
 * 1 5 0
 *
 * 0 1 5
 *
 * 3
 * 输出:
 * 15
 */
import java.util.Scanner;
import java.util.*;
public class MicroserviceIntegration {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            in.nextLine();
            Integer[][] service_map = new Integer[n][n];
            for (int i = 0; i < n; i++) {
                service_map[i] = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            }
            int target = in.nextInt() - 1;

            // 每个任务的前置依赖任务
            List<List<Integer>> upstream =new ArrayList<List<Integer>>(n);
            for (int i=0;i<n;i++) {
                upstream.add(new ArrayList<>());
            }

            //初始化前置依赖任务
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j && service_map[i][j] == 1) {
                        upstream.get(i).add(j);
                    }
                }
            }

            // 保存服务列表
            LinkedList<List<Integer>> service_list =new LinkedList<List<Integer>>();
            service_list.add(upstream.get(target));

            //等待时间初始化
            int result = service_map[target][target];

            while (service_list.size() > 0) {
                List<Integer> upstream_tasks = service_list.removeFirst();

                int temp_res = 0;
                ArrayList<Integer> services = new ArrayList<>();
                for (int i=0;i<upstream_tasks.size();i++) {
                    temp_res = Math.max(temp_res, service_map[i][i]);
                    for (int j=0;j<upstream.get(upstream_tasks.get(i)).size();j++) {
                        services.add(upstream.get(upstream_tasks.get(i)).get(j));
                    }
                }
                result += temp_res;
                if (services.size() > 0) {
                    service_list.add(services);
                }

            }

            System.out.println(result);
        }

    }
}
