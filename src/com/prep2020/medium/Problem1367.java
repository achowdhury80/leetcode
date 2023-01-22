package com.prep2020.medium;

import com.prep2020.ListNode;
import com.prep2020.TreeNode;

public class Problem1367 {
	/*
	 * O(N) - dfs
	 */
	public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        if (hasPathStartingFromRoot(head, root)) return true;
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }
	
	private boolean hasPathStartingFromRoot(ListNode head, TreeNode root) {
		if (head == null) return true;
		if(root == null) return false;
		if (head.val != root.val) return false;
		return hasPathStartingFromRoot(head.next, root.left) 
				|| hasPathStartingFromRoot(head.next, root.right);
	}
}
