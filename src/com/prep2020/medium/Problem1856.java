package com.prep2020.medium;
import java.util.*;
public class Problem1856 {
	public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        Queue<Integer> pq = new PriorityQueue<>((x, y) -> nums[x] - nums[y]);
        for (int i = 0; i < n; i++) {
        	sum[i + 1] = nums[i] + sum[i];
        	pq.offer(i);
        }
        long result = 0l;
        TreeSet<Integer> used = new TreeSet<>();
        while(!pq.isEmpty()) {
        	int idx = pq.poll();
        	int left = 0, right = n - 1;
        	if (used.floor(idx) != null) left = used.floor(idx) + 1;
        	if (used.ceiling(idx) != null) right = used.ceiling(idx) - 1;
        	long curSum = sum[right + 1] - sum[left];
        	result = Math.max(result, curSum * nums[idx]);
        	used.add(idx);
        }
        return (int)(result % (long)(1e9 + 7));
    }
	
	public static void main(String[] args) {
		Problem1856 problem = new Problem1856();
		System.out.println(problem.maxSumMinProduct(new int[] {1, 2, 3, 2}));
	}
}
