package comp.prep2019.less1000;
import java.util.*;

import comp.prep2019.TreeNode;
public class Prob199 {
	/**
	 * O(N)
	 * @param root
	 * @return
	 */
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root == null) return result;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			int size = q.size();
			int right = Integer.MIN_VALUE;
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				right = node.val;
				if (node.left != null) q.offer(node.left);
				if(node.right != null) q.offer(node.right);
			}
			result.add(right);
		}
		return result;
    }
}
