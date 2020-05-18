package comp.prep2019;
import java.util.*;
public class Prob285 {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != p) {
        	stack.push(cur);
        	if (cur.val < p.val) cur = cur.right;
        	else cur = cur.left;
        }
        stack.push(cur);
        if (cur.right != null) {
        	cur = cur.right;
        	while(cur.left != null) cur = cur.left;
        	return cur;
        }
        while(!stack.isEmpty()) {
        	TreeNode parent = stack.pop();
        	if (parent.left == cur) return parent;
        	cur = parent;
        }
        return null;
    }
}
