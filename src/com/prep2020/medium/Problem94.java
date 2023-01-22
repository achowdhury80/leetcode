package com.prep2020.medium;
import java.util.*;

import com.prep2020.TreeNode;
public class Problem94 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur != null) {
        	dq.offerLast(cur);
        	cur = cur.left;
        }
        while (!dq.isEmpty()) {
        	TreeNode node = dq.pollLast();
        	result.add(node.val);
        	cur = node.right;
        	while(cur != null) {
            	dq.offerLast(cur);
            	cur = cur.left;
            }
        }
        return result;
    }
}
