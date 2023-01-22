package com.prep2020.medium;
import java.util.*;
public class Problem1673 {
	public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int start = n - k;
        for (int i = start; i > -1; i--) {
        	if (!dq.isEmpty() && nums[i] > dq.peekFirst()) continue;
        	dq.offerFirst(nums[i]);
        }
        int[] result = new int[k];
        int idx = 0;
        for (int i = 0; i < k; i++) {
        	result[idx++] = dq.pollFirst();
        	start++;
        	if (start < n) {
        		while (!dq.isEmpty() && dq.peekLast() > nums[start]) dq.pollLast();
            	dq.offerLast(nums[start]);
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1673 problem = new Problem1673();
		System.out.println(problem.mostCompetitive(new int[] {3, 5, 2, 6}, 2));
	}
}
