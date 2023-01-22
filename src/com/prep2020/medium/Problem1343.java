package com.prep2020.medium;

public class Problem1343 {
	/**
	 * O(N)
	 * @param arr
	 * @param k
	 * @param threshold
	 * @return
	 */
	public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        for (int i = 0; i < k - 1; i++) sum += arr[i];
        int result = 0;
        for (int i = k - 1; i < arr.length; i++) {
        	sum = sum - (i >= k ? arr[i - k] : 0) + arr[i];
        	if ((sum + 0.) / k >= threshold) result++;
        }
        return result;
    }
}
