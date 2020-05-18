package comp.prep2019;

public class Prob530 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @return
	 */
	public int getMinimumDifference(TreeNode root) {
        return helper(root)[0];
    }
	
	/**
	 * arr[0] - min diff for the subtree
	 * arr[1] - min value of subtree
	 * arr[2] - max value of subtree
	 * @param root
	 * @return
	 */
	private int[] helper(TreeNode root) {
		int[] arr = new int[] {Integer.MAX_VALUE, root.val, root.val};
		if (root.left == null && root.right == null) return arr;
		if (root.left != null) {
			int[] left = helper(root.left);
			arr[1] = left[1];
			arr[0] = Math.min(left[0], root.val - left[2]);
		}
		if (root.right != null) {
			int[] right = helper(root.right);
			arr[2] = right[2];
			arr[0] = Math.min(arr[0], Math.min(right[0], right[1] - root.val));
		}
		return arr;
	}
}
