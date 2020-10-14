package comp.prep2019.less1000;
import java.util.*;

import comp.prep2019.TreeNode;

public class Prob102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null) return result;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			int size = q.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				list.add(node.val);
				if (node.left != null) q.offer(node.left);
				if (node.right != null) q.offer(node.right);
			}
			result.add(list);
		}
		return result;
    }
}
