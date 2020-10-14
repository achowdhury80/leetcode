package comp.prep2019;
import java.util.*;
public class Prob637 {
	/**
	 * O(N) time and O(m) space m means max node at any level
	 * @param root
	 * @return
	 */
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> result = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			int size = q.size();
			double sum = 0;
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				sum += node.val;
				if (node.left != null) q.offer(node.left);
				if (node.right != null) q.offer(node.right);
			}
			result.add(sum / size);
		}
		return result;
    }
}
