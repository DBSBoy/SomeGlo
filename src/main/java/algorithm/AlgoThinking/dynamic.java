package algorithm.AlgoThinking;

import javax.xml.soap.Node;
import java.util.*;

public class dynamic {
    // 计算从起点 start 到终点 target 的最近距离
    int BFS(Node start, Node target) {
        Queue<Node> q = null; // 核心数据结构
        Set<Node> visited = null; // 避免走回头路

        q.offer(start); // 将起点加入队列
        visited.add(start);
        int step = 0; // 记录扩散的步数

        // 延伸每个节点，看他周围节点是不是target
        // while是纵向,for是横向
        // 第一个for:出队一个检查是不是target
        // 第二个for:将周围没有visited的节点加入队列
        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                /* 划重点：这里判断是否到达终点 */
                if (cur == target)
                return step;
                /* 将 cur 的相邻节点加入队列 */
                for (Node x : adj(cur)) {
                    if (visited.contains(x)) {
                        q.offer(x);
                        visited.add(x);
                    }
                }
            }
            /* 划重点：更新步数在这里 */
            step++;
        }
        return step;
    }

    public List<Node> adj(Node node){
        return new ArrayList<>();
    }
}
