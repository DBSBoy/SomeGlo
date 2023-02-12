package algorithm.Example;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 动态规划获取二叉树最小深度
 */
public class TreeDeep {
    int minDepth(TreeNode root) {
        if (Objects.isNull(root)) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // root 本身就是一层，depth 初始化为 1
        int depth = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                /* 判断是否到达终点 */
                if (cur.isLeaf())
                    return depth;
                /* 将 cur 的相邻节点加入队列 */
                if (Objects.nonNull(cur.getChildAt(0)))
                    q.offer(cur.getChildAt(0));
                if (Objects.nonNull(cur.getChildAt(1)))
                    q.offer(cur.getChildAt(1));
            }
            /* 这里增加步数 */
            depth++;
        }
        return depth;
    }
}
