package algorithm.O2;

/**
 * 跳格子游戏
 */
import java.util.*;
public class JumpGrid {
    static class Main {
        private static final int NOT_VISITED = 0;
        private static final int VISITED = 1;
        private static final int VISIT_FINISHED = 2;
        static int[] visitStatus;
        static List<List<Integer>> edges;
        static boolean stepAllGrids;

        public static void dfs(int node) {
            visitStatus[node] = VISITED;

            for(int neighbor : edges.get(node)) {
                if(visitStatus[neighbor] == NOT_VISITED) {
                    dfs(neighbor);

                    if(!stepAllGrids) {
                        return;
                    }
                }else if(visitStatus[neighbor] == VISITED){
                    stepAllGrids = false;
                    return;
                }
            }

            visitStatus[node] = VISIT_FINISHED;
        }

        public static void main(String[] args) {
            // 输入处理
            Scanner in = new Scanner(System.in);
            int N = Integer.parseInt(in.nextLine());

            // 初始化边
            edges = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                edges.add(new ArrayList<>());
            }

            stepAllGrids = true;
            while(in.hasNext()) {
                String line = in.nextLine();
                if (line == "") {
                    break;
                }
                String[] strs = line.split(" ");
                //System.out.println(line);
                edges.get(Integer.parseInt(strs[1])).add(Integer.parseInt(strs[0]));
            }

            visitStatus = new int[N];

            for(int i = 0; i < N && stepAllGrids; i++) {
                if(visitStatus[i] == NOT_VISITED) {
                    dfs(i);
                }
            }

            if (stepAllGrids) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }


        }
    }
}
