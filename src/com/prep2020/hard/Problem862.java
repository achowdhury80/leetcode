package com.prep2020.hard;
import java.util.*;
public class Problem862 {
	public int shortestSubarray(int[] nums, int k) {
        int n = nums.length, result = Integer.MAX_VALUE;
        long[] sum = new long[n + 1];
        sum[0] = nums[0];
        for (int i = 0; i < n; i++) {
        	sum[i + 1] = sum[i] + nums[i];
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for (int y = 0; y <= n; y++) {
        	while(!dq.isEmpty() && sum[y] <= sum[dq.peekLast()]) dq.pollLast();
        	while(!dq.isEmpty() && sum[y] >= sum[dq.peekFirst()] + k) result = Math.min(result, y - dq.removeFirst());
        	dq.offerLast(y);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
	
	public static void main(String[] args) {
		Problem862 problem = new Problem862();
		System.out.println(problem.shortestSubarray(new int[] {84,-37,32,40,95}, 167));
	}
}
