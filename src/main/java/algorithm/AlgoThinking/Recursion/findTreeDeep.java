package algorithm.AlgoThinking.Recursion;

import javax.swing.tree.TreeNode;

public class findTreeDeep {
        public int minDepth(TreeNode root) {
            if(root == null) return 0;
            int m1 = minDepth(root.getChildAt(0));
            int m2 = minDepth(root.getChildAt(1));
            //1.如果左孩子和右孩子有为空的情况，直接返回m1+m2+1
            //2.如果都不为空，返回较小深度+1
            return root.getChildAt(0) == null || root.getChildAt(1) == null ? m1 + m2 + 1 : Math.min(m1,m2) + 1;
        }
}
