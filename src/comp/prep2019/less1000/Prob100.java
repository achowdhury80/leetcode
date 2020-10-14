package comp.prep2019.less1000;

import comp.prep2019.TreeNode;

public class Prob100 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) 
        		&& isSameTree(p.right, q.right);
    }
}
