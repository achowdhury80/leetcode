package comp.prep2019;

public class Prob1026 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @return
	 */
	public int maxAncestorDiff(TreeNode root) {
        int[] result = new int[] {0};
        helper(root, result);
        return result[0];
    }
	
	private int[] helper(TreeNode root, int[] result) {
		if (root == null) return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
		int[] leftMinMax = helper(root.left, result);
		int[] rightMinMax = helper(root.right, result);
		int[] minMax = new int[2];
		minMax[0] = Math.min(Math.min(leftMinMax[0], rightMinMax[0]), root.val);
		minMax[1] = Math.max(Math.max(leftMinMax[1], rightMinMax[1]), root.val);
		if (leftMinMax[0] != Integer.MAX_VALUE) {
			result[0] = Math.max(result[0], Math.max(Math.abs(root.val - leftMinMax[0]), Math.abs(root.val - leftMinMax[1])));
		}
		if (rightMinMax[0] != Integer.MAX_VALUE) {
			result[0] = Math.max(result[0], Math.max(Math.abs(root.val - rightMinMax[0]), Math.abs(root.val - rightMinMax[1])));
		}
		return minMax;
	}
	
	public static void main(String[] args) {
		Prob1026 prob = new Prob1026();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(-5);
		System.out.println(prob.maxAncestorDiff(root));
	}
}
