package comp.prep2019.less1000;

import comp.prep2019.TreeNode;

public class Prob617 {
	/**
	 * O(m + N) time
	 * @param t1
	 * @param t2
	 * @return
	 */
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
