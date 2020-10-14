package comp.prep2019.less2000;
import java.util.*;

import comp.prep2019.TreeNode;
public class Prob144 {
	/**
	 * O(N) time and space
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) return result;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode cur =stack.pop();
			result.add(cur.val);
			if (cur.right != null) stack.push(cur.right);
			if (cur.left != null) stack.push(cur.left);
			
		}
		return result;
    }
}
