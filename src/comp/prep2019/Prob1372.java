package comp.prep2019;

public class Prob1372 {
	public int longestZigZag(TreeNode root) {
        int[] result = new int[1];
        helper(root, result);
        return result[0];
    }
	
	private int[] helper(TreeNode root, int[] result) {
		if (root.left == null && root.right == null) return new int[] {0, 0};
		int[] res = new int[2];
		if (root.left != null) res[0] = 1 + helper(root.left, result)[1];
		if (root.right != null) res[1] = 1 + helper(root.right, result)[0];
		result[0] = Math.max(result[0], Math.max(res[0], res[1]));
		return res;
	}
}
