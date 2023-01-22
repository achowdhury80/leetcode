package com.prep2020.medium;
public class Problem974 {
	/**
	 * O(N)
	 * @param nums
	 * @param k
	 * @return
	 */
	public int subarraysDivByK(int[] nums, int k) {
        int[] arr = new int[k];
        arr[0] = 1;
        int sum = 0, result = 0;
        for (int num : nums) {
        	sum += num;
        	result += arr[(sum % k + k) % k]++;
        }
        return result;
    }
}
