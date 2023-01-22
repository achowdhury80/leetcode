package com.prep2020.medium;
import java.util.*;
public class Problem1696 {
	/**
	 * O(N) time and O(N) space
	 * @param nums
	 * @param k
	 * @return
	 */
	public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] score = new int[n];
        score[0] = nums[0];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(0);
        for (int i = 1; i < n; i++) {
            // pop the old index
            while (!dq.isEmpty() && dq.peekFirst() < i - k) dq.pollFirst();
            score[i] = score[dq.peekFirst()] + nums[i];
            // pop the smaller value
            while (!dq.isEmpty() && score[i] >= score[dq.peekLast()]) dq.pollLast();
            dq.offerLast(i);
        }
        return score[n - 1];
    }
}
