package com.prep2020.easy;

import java.util.*;

public class Problem2099 {
	/**
	 * O(nlogk) time and o(k) space
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSubsequence(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>((x, y) -> nums[x] - nums[y]);
        for (int i = 0; i < nums.length; i++) {
        	pq.offer(i);
        	if (pq.size() > k) pq.poll();
        }
        List<Integer> list = new ArrayList<>(pq);
        Collections.sort(list);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) result[i] = nums[list.get(i)];
        return result;
    }
	
	public static void main(String[] args) {
		Problem2099 problem = new Problem2099();
		System.out.println(problem.maxSubsequence(new int[] {2,  1, 3, 3}, 2));
	}
}
