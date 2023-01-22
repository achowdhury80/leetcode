package com.prep2020.medium;

import java.util.*;

public class Problem1262 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int maxSumDivThree(int[] nums) {
        Queue<Integer> oneQueue = new PriorityQueue<>((x, y) -> y - x);
        Queue<Integer> twoQueue = new PriorityQueue<>((x, y) -> y - x);
        int sum = 0;
        for (int num : nums) {
        	sum += num;
        	if (num % 3 == 1) {
        		oneQueue.offer(num);
        		if (oneQueue.size() > 2) oneQueue.poll();
        	}
        	if (num % 3 == 2) {
        		twoQueue.offer(num);
        		if (twoQueue.size() > 2) twoQueue.poll();
        	}
        }
        if (sum % 3 == 0) return sum;
        if (sum % 3 == 1) {
        	if (oneQueue.size() > 1) oneQueue.poll();
        	sum = sum - Math.min(
        			oneQueue.size() > 0 ? oneQueue.peek() : Integer.MAX_VALUE, 
        			twoQueue.size() > 1 ? (twoQueue.poll() + twoQueue.poll()) : Integer.MAX_VALUE);
        } else {
        	if (twoQueue.size() > 1) twoQueue.poll();
        	sum = sum - Math.min(
        			twoQueue.size() > 0 ? twoQueue.peek() : Integer.MAX_VALUE, 
        					oneQueue.size() > 1 ? (oneQueue.poll() + oneQueue.poll()) : Integer.MAX_VALUE);
        }
        return sum;
    }
	
	public static void main(String[] args) {
		Problem1262 problem = new Problem1262();
		System.out.println(problem.maxSumDivThree(new int[] {1, 2, 3, 4, 4}));
	}
}
