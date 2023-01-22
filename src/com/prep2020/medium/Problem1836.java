package com.prep2020.medium;

import java.util.*;

import com.prep2020.ListNode;

public class Problem1836 {
	/*
	 * o(N)
	 */
	public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Boolean> map = new HashMap<>();
        ListNode cur = head;
        while(cur != null) {
        	if (map.containsKey(cur.val))map.put(cur.val, true);
        	else map.put(cur.val, false);
        	cur = cur.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode dummyCur = dummy;
        cur = head;
        while(cur != null) {
        	if (!map.get(cur.val)) {
        		dummyCur.next = cur;
        		dummyCur = dummyCur.next;
        	}
        	cur = cur.next;
        }
        dummyCur.next = null;
        return dummy.next;
    }
}
