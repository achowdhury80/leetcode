package com.prep2020.medium;
import java.util.*;
public class Problem1999 {
	/**
	 * O(1) since number of digits in integer.max is fixed
	 * @param k
	 * @param digit1
	 * @param digit2
	 * @return
	 */
	public int findInteger(int k, int digit1, int digit2) {
        if (digit1 == digit2 && digit1 == 0) return -1;
        Queue<Integer> pq = new PriorityQueue<>();
        if (digit1 != 0) pq.offer(digit1);
        if (digit1 != digit2 && digit2 != 0)pq.offer(digit2);
        while(!pq.isEmpty()) {
        	int cur = pq.poll();
        	if (cur > k && cur % k == 0) return cur;
        	long next = (cur * 10l) + digit1;
        	if (next < Integer.MAX_VALUE) pq.offer((int)next);
        	if (digit1 != digit2) next = (cur * 10l) + digit2;
        	if (next < Integer.MAX_VALUE) pq.offer((int)next);
        }
        return -1;
    }
}
