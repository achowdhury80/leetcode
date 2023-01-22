package com.prep2020.medium;
import java.util.*;

import com.prep2020.TreeNode;
public class Problem1305 {
	/**
	 * O(N1 + N2)
	 * @param root1
	 * @param root2
	 * @return
	 */
	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		BSTIterator itr1 = new BSTIterator(root1), itr2 = new BSTIterator(root2);
		List<Integer> result = new ArrayList<>();
		while(itr1.hasNext() && itr2.hasNext()) {
			if (itr1.peek() <= itr2.peek()) result.add(itr1.next());
			else result.add(itr2.next());
		}
		while(itr1.hasNext()) result.add(itr1.next());
		while(itr2.hasNext()) result.add(itr2.next());
		return result;
    }
	
	class BSTIterator{
		Deque<TreeNode> dq;
		BSTIterator(TreeNode root) {
			dq = new ArrayDeque<>();
			TreeNode cur = root;
			while(cur != null) {
				dq.offerLast(cur);
				cur = cur.left;
			}
		}

		public boolean hasNext() {
			return !dq.isEmpty();
		}

		public int next() {
			TreeNode cur = dq.pollLast();
			int result = cur.val;
			cur = cur.right;
			while(cur != null) {
				dq.offerLast(cur);
				cur = cur.left;
			}
			return result;
		}
		
		public int peek() {
			return dq.peekLast().val;
		}
	}
}
