package com.prep2020.medium;
import java.util.*;
import com.prep2020.TreeNode;

public class Problem285 {
	/**
	 * O(H)
	 * @param root
	 * @param p
	 * @return
	 */
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
        	p = p.right;
        	while(p.left != null) p = p.left;
        	return p;
        }
        if (p == root) return null;
        TreeNode cur = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(cur != p) {
        	stack.push(cur);
        	if (p.val > cur.val) cur = cur.right;
        	else cur = cur.left;
        }
        TreeNode parent = stack.pop();
        cur = p;
        while(parent.left != cur) {
        	cur = parent;
        	if (stack.isEmpty()) return null;
        	parent = stack.pop();
        }
        return parent;
        
    }
}
