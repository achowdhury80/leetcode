package com.prep2020.medium;

public class Problem1031 {
	/**
	 * O(N)
	 * @param nums
	 * @param firstLen
	 * @param secondLen
	 * @return
	 */
	public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
		int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) sum[i + 1] = sum[i] + nums[i];
        int[] maxForward = new int[n], maxBackward = new int[n];
        for (int i = 0; i < n; i++) {
        	if (i < secondLen - 1) {
        		maxForward[i] = Integer.MIN_VALUE;
        		maxBackward[n - i - 1] = Integer.MIN_VALUE;
        	}
        	else if (i == secondLen - 1) {
        		maxForward[i] = sum[i + 1];
        		maxBackward[n - i - 1] = sum[n] - sum[n - i - 1];
        	}
        	else {
        		maxForward[i] = Math.max(maxForward[i - 1], sum[i + 1] - sum[i + 1 - secondLen]);
        		maxBackward[n - i - 1] = Math.max(maxBackward[n - i], sum[n - i - 1 + secondLen] - sum[n - i - 1]);
        	}
        }
        int result = Integer.MIN_VALUE;
        for (int i = firstLen - 1; i < n; i++) {
        	int leftEnd = i - firstLen, rightEnd = i + 1;
        	int left = leftEnd < 0 ? Integer.MIN_VALUE : maxForward[leftEnd];
        	int right = rightEnd == n ? Integer.MIN_VALUE : maxBackward[rightEnd];
        	int firstSum = sum[i + 1] - sum[i + 1 - firstLen];
        	result = Math.max(result, firstSum + Math.max(left, right));
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1031 problem = new Problem1031();
		System.out.println(problem.maxSumTwoNoOverlap(new int[] {0,6,5,2,2,5,1,9,4}, 1, 2));
	}
}
