package comp.prep2019.less1000;

import comp.prep2019.TreeNode;

public class Prob285 {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
        	p = p.right;
        	while(p.left != null) p = p.left;
        	return p;
        }
        TreeNode result = null;
        TreeNode cur = root;
        while(cur != p) {
        	if (cur.val > p.val) {
        		result = cur;
        		cur = cur.left;
        	} else {
        		cur = cur.right;
        	}
        }
        return result;
    }
}
