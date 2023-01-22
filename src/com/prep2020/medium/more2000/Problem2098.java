package com.prep2020.medium.more2000;

import java.util.Arrays;

public class Problem2098 {
	/**
	 * O(nlogn)
	 * @param nums
	 * @param k
	 * @return
	 */
	public long largestEvenSum(int[] nums, int k) {
        Arrays.sort(nums);
        long result = 0;
        int n = nums.length;
        int[] minEvenOdd = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int i = 0; i < k; i++) {
        	result += nums[n - i - 1];
        	if (nums[n - i - 1] % 2 == 0) minEvenOdd[0] = nums[n - i - 1];
        	else minEvenOdd[1] = nums[n - i - 1];
        }
        if (result % 2 == 0) return result;
        int[] maxEvenOdd = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int i = n - k - 1; i > -1 && (maxEvenOdd[0] == Integer.MIN_VALUE 
        		|| maxEvenOdd[1] == Integer.MIN_VALUE); i--) {
        	if (nums[i] % 2 == 0) maxEvenOdd[0] = Math.max(maxEvenOdd[0], nums[i]);
        	else maxEvenOdd[1] = Math.max(maxEvenOdd[1], nums[i]);
        }
        long temp = result;
        result = Integer.MIN_VALUE;
        if (minEvenOdd[0] != Integer.MAX_VALUE && maxEvenOdd[1] != Integer.MIN_VALUE) {
        	result = (temp - minEvenOdd[0]) + maxEvenOdd[1];
        }
        if (minEvenOdd[1] != Integer.MAX_VALUE && maxEvenOdd[0] != Integer.MIN_VALUE) {
        	result = Math.max(result, (temp - minEvenOdd[1]) + maxEvenOdd[0]);
        }
        return result == Integer.MIN_VALUE ? -1 : result;
    }
	
	public static void main(String[] args) {
		Problem2098 problem = new Problem2098();
		/*System.out.println(problem.largestEvenSum(new int[] {8,3,3,17,4,8},
				3));*/
		System.out.println(problem.largestEvenSum(new int[] {1, 5, 5, 5, 4},
				4));
	}
}
