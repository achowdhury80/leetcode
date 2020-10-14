package comp.prep2019;

public class Prob124 {
	public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        long[] result = helper(root);
        return (int)Math.max(result[0], result[1]);
    }
	
	/**
	 * result[0] - max path with terminal node being subtree root
	 * result[1] max path in the subtree
	 * @param root
	 * @return
	 */
	private long[] helper(TreeNode root) {
		long[] leftVals = root.left == null ? new long[] {Integer.MIN_VALUE, 
				Integer.MIN_VALUE} : helper(root.left);
		long[] rightVals = root.right == null ? new long[] {Integer.MIN_VALUE, 
				Integer.MIN_VALUE} : helper(root.right);
		long[] result = new long[2];
		result[0] = Math.max(root.val, Math.max(0l + root.val + leftVals[0], 0l 
				+ root.val + rightVals[0]));
		result[1] = Math.max(Math.max(leftVals[1], rightVals[1]), 
				0l + leftVals[0] + root.val + rightVals[0]);
		result[1] = Math.max(result[1], result[0]);
		return result;
	}
	
	public static void main(String[] args) {
		Prob124 prob = new Prob124();
		TreeNode root = new TreeNode(-2);
		root.left = new TreeNode(1);
		System.out.println(prob.maxPathSum(root));
	}
}
