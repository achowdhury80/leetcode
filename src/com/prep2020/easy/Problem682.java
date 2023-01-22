package com.prep2020.easy;
import java.util.*;
public class Problem682 {
	/**
	 * O(N) time and space
	 * @param ops
	 * @return
	 */
	public int calPoints(String[] ops) {
        Deque<Integer> dq = new ArrayDeque<>();
        int result = 0;
        for (String op : ops) {
        	if (op.equals("+")) {
        		int last = dq.pollLast();
        		int secondLast = dq.peekLast();
        		dq.offer(last);
        		dq.offer(last + secondLast);
        		result += dq.peekLast();
        	} else if (op.equals("D")) {
        		dq.offer(2 * dq.peekLast());
        		result += dq.peekLast();
        	} else if (op.equals("C")) {
        		result -= dq.pollLast();
        	} else {
        		dq.offerLast(Integer.parseInt(op));
        		result += dq.peekLast();
        	}
        }
        return result;
    }
}
