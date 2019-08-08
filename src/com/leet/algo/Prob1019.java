package com.leet.algo;
import java.util.*;
public class Prob1019 {
	public int[] nextLargerNodes(ListNode head) {
		List<Integer> A = new ArrayList<>();
		for (ListNode node = head; node != null; node = node.next)
            A.add(node.val);
		int[] res = new int[A.size()];
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < A.size(); i++) {
			while(!s.isEmpty() && A.get(s.peek()) < A.get(i)) res[s.pop()] = A.get(i);
			s.push(i);
		}
		return res;
    }
}
