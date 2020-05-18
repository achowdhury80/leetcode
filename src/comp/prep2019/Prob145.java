package comp.prep2019;
import java.util.*;
public class Prob145 {
	/**
	 * the tree will modified
	 * to keep the tree intact, create a separate class to include node  and a flag to
	 * determine whether it was explored previously
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) return result;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()) {
        	TreeNode cur = s.pop();
        	if (cur.left == null && cur.right == null) {
        		result.add(cur.val);
        		continue;
        	}
        	s.push(cur);
        	if (cur.right != null) {
        		s.push(cur.right);
        		cur.right = null;
        	}
        	if (cur.left != null) {
        		s.push(cur.left);
        		cur.left = null;
        	}
        }
        return result;
    }
}
