package comp.prep2019;

public class Prob1080 {
	public TreeNode sufficientSubset(TreeNode root, int limit) {
        return helper(root, limit, 0);
    }
	
	private TreeNode helper(TreeNode root, int limit, int preSum) {
		if(root == null) return null;
		if (root.left == null && root.right == null) {
        	if (preSum + root.val < limit) return null;
        	else return root;
        }
		preSum += root.val;
		TreeNode left = helper(root.left, limit, preSum);
		TreeNode right = helper(root.right, limit, preSum);
		root.left = left;
		root.right = right;
		if (root.left == null && root.right == null) return null;
		return root;
	}
	
	
}
