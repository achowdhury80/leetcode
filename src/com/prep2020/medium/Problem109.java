package com.prep2020.medium;

import com.prep2020.ListNode;
import com.prep2020.TreeNode;

public class Problem109 {
	public TreeNode sortedListToBST(ListNode head) {
        int len = findLength(head);
        if (len == 0) return null;
        if (len == 1) return new TreeNode(head.val);
        ListNode parentOfMiddle = findParentOfMiddle(head, len);
        TreeNode root = new TreeNode(parentOfMiddle.next.val);
        root.right = sortedListToBST(parentOfMiddle.next.next);
        parentOfMiddle.next = null;
        root.left = sortedListToBST(head);
        return root;
    }
	
	private int findLength(ListNode head) {
		if (head == null) return 0;
		int count = 0;
		while(head != null) {
			count++;
			head = head.next;
		}
		return count;
	}
	
	private ListNode findParentOfMiddle(ListNode head, int len) {
		int nodeToMove = len / 2;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode cur = dummy;
		for (int i = 0; i < nodeToMove; i++) {
			cur = cur.next;
		}
		return cur;
	}
}
