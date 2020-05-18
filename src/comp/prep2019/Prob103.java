package comp.prep2019;
import java.util.*;
public class Prob103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		boolean reverse = false;
		while(!q.isEmpty()) {
			int size = q.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				list.add(node.val);
				if(node.left != null) q.offer(node.left);
				if(node.right != null) q.offer(node.right);
			}
			if (reverse) Collections.reverse(list);
			reverse = !reverse;
			result.add(list);
		}
		return result;
    }
}
