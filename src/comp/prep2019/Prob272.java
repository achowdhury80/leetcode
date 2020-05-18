package comp.prep2019;
import java.util.*;
public class Prob272 {
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		Queue<Integer> q = new PriorityQueue<>((x, y) -> (int)(Math.abs(y - target) - Math.abs(x - target)));
		helper(root, target, k, q);
		return new ArrayList<>(q);
    }
	/**
	 * if one side(left or right) data is collected, and later we try to add root.
	 * if root does not get added, then the other side data will not be added
	 * @param root
	 * @param target
	 * @param k
	 * @param q
	 */
	private void helper(TreeNode root, double target, int k, Queue<Integer> q) {
		if (root == null) return;
		boolean rootAdded = false, leftTraversed = false, rightTraversed = false;
		if (root.val < target) {
			helper(root.right, target, k, q);
			rightTraversed = true;
		}
		else if (root.val > target) {
			helper(root.left, target, k, q);
			leftTraversed = true;
		}
		double diffWithRoot = Math.abs(root.val - target);
		if (q.size() < k || Math.abs(q.peek() - target) > diffWithRoot) {
			q.offer(root.val);
			rootAdded = true;
			if (q.size() > k) q.poll();
		}
		if (rootAdded) {
			if (!leftTraversed) helper(root.left, target, k, q);
			if (!rightTraversed) helper(root.right, target, k, q);
		}
	}
}
