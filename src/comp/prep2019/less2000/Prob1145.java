package comp.prep2019.less2000;

import comp.prep2019.TreeNode;

public class Prob1145 {
	public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode xNode = find(root, x);
        int left = subtreeSize(xNode.left);
        if (2 * left > n ) return true;
        int right = subtreeSize(xNode.right);
        if (2 * right > n) return true;
        int xTreeSize = 1 + left + right;
        if (2 * xTreeSize < n) return true;
        return false;
    }
	
	private TreeNode find(TreeNode root, int x) {
		if (root == null || root.val == x) return root;
		TreeNode left = find(root.left, x);
		if (left != null) return left;
		return find(root.right, x);
	}
	
	private int subtreeSize(TreeNode root) {
		if (root == null) return 0;
		return 1 + subtreeSize(root.left) + subtreeSize(root.right);
	}
}
