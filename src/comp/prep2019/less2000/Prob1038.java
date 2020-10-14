package comp.prep2019.less2000;

import comp.prep2019.TreeNode;

public class Prob1038 {
	public TreeNode bstToGst(TreeNode root) {
        helper(root, new int[] {0});
        return root;
    }
	
	private void helper(TreeNode root, int[] sum) {
        if (root.right != null) {
        	helper(root.right, sum);
        }
        sum[0] += root.val;
        root.val = sum[0];
        if (root.left != null) {
        	helper(root.left, sum);
        }
    }
}
