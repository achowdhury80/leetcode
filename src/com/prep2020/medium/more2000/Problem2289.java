package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2289 {
	public int totalSteps(int[] nums) {
		Deque<int[]> dq = new ArrayDeque<>();
		int n = nums.length, result = 0;
		for (int i = n - 1; i > -1; i--) {
			int[] cur = new int[] {nums[i], 0};
			while (!dq.isEmpty() && dq.peek()[0] < cur[0]) {
				int[] last = dq.pollFirst();
				cur[1] = Math.max(1 + cur[1], last[1] == 0 ? 1 : last[1]);
				result = Math.max(result, cur[1]);
			}
			dq.offerFirst(cur);
		}
        return result;
    }
	
	public static void main(String[] args) {
		Problem2289 problem = new Problem2289();
		System.out.println(problem.totalSteps(new int[] {5,3,4,4,7,3,6,11,8,5,11}));
		System.out.println(problem.totalSteps(new int[] {10,1,2,3,4,5,6,1,2,3}));
		System.out.println(problem.totalSteps(new int[] {10, 6, 5, 10, 15}));
	}
}
