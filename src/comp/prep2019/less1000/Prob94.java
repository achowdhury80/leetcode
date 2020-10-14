package comp.prep2019.less1000;
import java.util.*;

import comp.prep2019.TreeNode;
public class Prob94 {
	/**
	 * O(N) time and o(H) space
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null) {
        	stack.push(cur);
        	cur = cur.left;
        }
        while (!stack.isEmpty()) {
        	cur = stack.pop();
        	list.add(cur.val);
        	if (cur.right != null) {
        		cur = cur.right;
                while(cur != null) {
                	stack.push(cur);
                	cur = cur.left;
                }
        	}
        }
        return list;
    }
}
