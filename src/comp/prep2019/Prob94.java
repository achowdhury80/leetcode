package comp.prep2019;
import java.util.*;
public class Prob94 {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while(cur != null) {
        	stack.push(cur);
        	cur = cur.left;
        }
        while(!stack.isEmpty()) {
        	TreeNode node = stack.pop();
        	result.add(node.val);
        	if (node.right != null) {
        		cur = node.right;
        		while(cur != null) {
                	stack.push(cur);
                	cur = cur.left;
                }
        	}
        }
        return result;
    }
}
