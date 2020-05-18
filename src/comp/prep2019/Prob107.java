package comp.prep2019;
import java.util.*;
public class Prob107 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			int size = q.size();
			List<Integer> list = new ArrayList<>(size);
			for (int i = 0; i < size; i++) {
				TreeNode cur = q.poll();
				list.add(cur.val);
				if (cur.left != null) q.offer(cur.left);
				if (cur.right != null) q.offer(cur.right);
			}
			result.add(0, list);
		}
		return result;
    }
}
