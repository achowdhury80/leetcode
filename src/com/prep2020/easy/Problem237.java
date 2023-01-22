package com.prep2020.easy;

import com.prep2020.ListNode;

public class Problem237 {
	/**
	 * O(1)
	 * @param node
	 */
	public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
