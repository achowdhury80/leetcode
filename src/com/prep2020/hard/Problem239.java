package com.prep2020.hard;
import java.util.*;
public class Problem239 {
	/**
	 * O(N)- since each element is processed atmost twice, once added and once removed
	 * O(N) space
	 * maintain a decreasing stack. 
	 * if first element in dq outside the sliding window range, remove it
	 * answer will be the max element of dq for each sliding window
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
        	while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.pollLast();
        	dq.offerLast(i);
        	if (!dq.isEmpty() && dq.peek() <= i - k) dq.pollFirst();
        	if (i + 1 >= k) result[idx++] = nums[dq.peekFirst()];
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem239 problem = new Problem239();
		int[] result = problem.maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
		System.out.println(result);
	}
}
