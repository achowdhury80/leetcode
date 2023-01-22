package com.prep2020.easy;
import java.util.*;
public class Problem628 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int maximumProduct(int[] nums) {
        Queue<Integer> minQ = new PriorityQueue<>(), 
        		maxQ = new PriorityQueue<>((x, y) -> y - x);
        for (int num : nums) {
        	minQ.offer(num);
        	if (minQ.size() > 3) minQ.poll();
        	maxQ.offer(num);
        	if (maxQ.size() > 2) maxQ.poll();
        }
        int prod1 = minQ.poll() * minQ.poll();
        int prod2 = maxQ.poll() * maxQ.poll();
        return Math.max(minQ.peek() * prod1, minQ.peek() * prod2);
    }
}
