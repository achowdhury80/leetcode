package comp.prep2019.less1000;
import java.util.*;

import comp.prep2019.TreeNode;

public class Prob515 {
	/**
	 * O(N) time and space
	 * @param root
	 * @return
	 */
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root == null) return result;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			int size = q.size();
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				max = Math.max(max, node.val);
				if (node.left != null) q.offer(node.left);
				if(node.right != null) q.offer(node.right);
			}
			result.add(max);
		}
		return result;
    }
}
