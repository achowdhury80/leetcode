package comp.prep2019;

public class Prob437 {
	/**
	 * O(N) time and O(H) space
	 * find paths including root
	 * find paths on the left without root
	 * find paths on the right without root
	 * @param root
	 * @param sum
	 * @return
	 */
	public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSum(root.left, sum) + pathSum(root.right, sum) + findPathSumincluding(root, sum);
    }
	
	private int findPathSumincluding(TreeNode root, int sum) {
		if (root == null) return 0;
		int result = 0;
		if (root.val == sum) result++;
		return result + findPathSumincluding(root.left, sum - root.val) + findPathSumincluding(root.right, sum - root.val);
	}
}
