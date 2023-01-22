package com.prep2020.medium;

import com.prep2020.ListNode;
import java.util.*;

public class Problem1171 {
	public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> sumToFarthestNodeMap = new HashMap<>();
        int sum = 0;
        ListNode cur = head;
        ListNode result = new ListNode(-1);
        result.next = head;
        // create a map of sum to the farthest node with that sum starting from oth index
        while(cur != null) {
        	sum += cur.val;
        	// if sum is zero, remove all the nodes till that node
        	if (sum == 0) {
        		result.next = cur.next;
        		sumToFarthestNodeMap.clear();
        	} else {
        		sumToFarthestNodeMap.put(sum, cur);
        	}
        	cur = cur.next;
        }
        
        sum = 0;
        cur = result.next;
        while(cur != null) {
        	sum += cur.val;
        	if (sumToFarthestNodeMap.get(sum) != cur) {
        		cur.next = sumToFarthestNodeMap.get(sum).next;
        	}
        	cur = cur.next;
        }
        return result.next;
    }
}
