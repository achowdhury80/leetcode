package comp.prep2019;
import java.util.*;
public class Prob1469 {
	/**
	 * O(N) time and O(H) space
	 * n = number of node, and h = height
	 * @param root
	 * @return
	 */
	public List<Integer> getLonelyNodes(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		helper(root, result);
		return result;
    }
	
	private void helper(TreeNode root, List<Integer> result) {
		if (root == null) return;
		if (root.left != null && root.right == null) result.add(root.left.val);
		if (root.right != null && root.left == null) result.add(root.right.val);
		helper(root.left, result);
		helper(root.right, result);
	}
}
