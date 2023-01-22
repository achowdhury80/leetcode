package com.prep2020.medium;
import java.util.*;
public class Problem907 {
	/**
	 * https://leetcode.com/problems/sum-of-subarray-minimums/discuss/170750/
	 * o(N)
	 * @param arr
	 * @return
	 */
	public int sumSubarrayMins(int[] arr) {
		int n = arr.length, left[] = new int[n], right[] = new int[n];
		Deque<int[]> stack = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
        	int count = 1;
        	while(!stack.isEmpty() && stack.peek()[0] > arr[i]) count += stack.pop()[1];
        	stack.push(new int[] {arr[i], count});
        	left[i] = count;
        }
        stack.clear();
        for (int i = n - 1; i > -1; i--) {
        	int count = 1;
        	while(!stack.isEmpty() && stack.peek()[0] >= arr[i]) count += stack.pop()[1];
        	stack.push(new int[] {arr[i], count});
        	right[i] = count;
        }
        int result = 0, mod = (int)(1e9 + 7);
        for (int i = 0; i < n; i++) {
        	result = (int)(((1l * left[i] * right[i] * arr[i]) % mod + result) % mod);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem907 problem = new Problem907();
		System.out.println(problem.sumSubarrayMins(new int[] {3, 1, 2, 4}));
	}
}
