package com.prep2020.medium;
import java.util.*;

import com.prep2020.ListNode;
public class Problem817 {
	/**
	 * O(N)
	 * @param head
	 * @param G
	 * @return
	 */
	public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int g : G) set.add(g);
        int result = 0;
        ListNode cur = head;
        while(cur != null) {
        	if (set.contains(cur.val)) {
        		result++;
        		while (cur != null && set.contains(cur.val)) {
            		set.remove(cur.val);
            		cur = cur.next;
            	}
        	} else cur = cur.next;
        }
        return result;
    }
}
