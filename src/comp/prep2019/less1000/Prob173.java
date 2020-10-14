package comp.prep2019.less1000;
import java.util.*;

import comp.prep2019.TreeNode;
public class Prob173 {
	/**
	 * O(1) amortized
	 */
	private Stack<TreeNode> stack;
	public Prob173(TreeNode root) {
        TreeNode cur = root;
        stack = new Stack<>();
        while(cur != null) {
        	stack.push(cur);
        	cur = cur.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
    	TreeNode cur = stack.pop();
    	int result = cur.val;
    	cur = cur.right;
    	while(cur != null) {
    		stack.push(cur);
    		cur = cur.left;
    	}
    	return result;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
