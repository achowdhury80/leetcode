package comp.prep2019;

public class Prob270 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @param target
	 * @return
	 */
	public int closestValue(TreeNode root, double target) {
		if (root.val == target) return root.val;
		int result = root.val;
        if (target > root.val && root.right != null) {
        	int i = closestValue(root.right, target);
        	if (Math.abs(target - i) < Math.abs(target - result)) result = i;
        } else if (target < root.val && root.left != null) {
        	int i = closestValue(root.left, target);
        	if (Math.abs(target - i) < Math.abs(target - result)) result = i;
        }
        return result;
    }
}
