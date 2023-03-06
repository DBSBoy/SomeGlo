package od2;

import java.util.*;

/**
 * 服务启动
 */
public class ServerStart {
        private static boolean loop_flag = false;
        //保存结果中的编号
        private static Set<Integer> dependency_numbers;
        private static int m;
        public static void main(String[] args) {
            //处理输入
            Scanner in=new Scanner(System.in);
            int n = Integer.parseInt(in.nextLine());
            m = Integer.parseInt(in.nextLine());
            //保存节点间的依赖关系
            List<Integer>[] dependencys = new List[n];
            for(int i = 0; i < n; i++){
                dependencys[i] = new ArrayList<>();
                String[] strs = in.nextLine().split(",");
                int k = Integer.parseInt(strs[0]);
                for(int j = 1; j <= k; j++)
                    dependencys[i].add(Integer.parseInt(strs[j]));
            }

            dependency_numbers = new TreeSet<>();
            dfs(dependencys, m, new boolean[n]);
            if(loop_flag)
                System.out.println(-1);
            else{
                Integer[] res = dependency_numbers.toArray(new Integer[0]);
                System.out.print(res[0]);
                for(int i = 1; i < res.length; i++)
                    System.out.print("," + res[i]);
            }
        }

        private static void dfs(List<Integer>[] dependencys, int i, boolean[] visited){
            // visited 是否访问过了 -> 有环
            if(visited[i] == true){
                loop_flag = true;
                return;
            }
            if(!loop_flag){
                if(m != i)
                    dependency_numbers.add(i);
                visited[i] = true;
                for(int j : dependencys[i])
                    dfs(dependencys, j, visited);
                visited[i] = false;
            }

        }
}
