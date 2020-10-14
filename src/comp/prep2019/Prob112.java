package comp.prep2019;

public class Prob112 {
	/**
	 * O(N)
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum == root.val;
        return hasPathSum(root.left, sum - root.val) 
        		|| hasPathSum(root.right, sum - root.val);
    }
}
