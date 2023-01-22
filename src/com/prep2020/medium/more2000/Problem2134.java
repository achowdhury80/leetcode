package com.prep2020.medium.more2000;

public class Problem2134 {
	/**
	 * O(n)
	 * @param nums
	 * @return
	 */
	public int minSwaps(int[] nums) {
        int count = 0, n = nums.length;
        for (int i : nums) count += i == 1 ? 1 : 0;
        if (count == n) return 0;
        int windowCount = 0;
        for (int i = 0; i < count; i++) windowCount += nums[i] == 1 ? 1 : 0;
        int result = count - windowCount;
        for (int i = 1; i < n; i++) {
        	windowCount -= nums[i - 1] == 1 ? 1 : 0;
        	windowCount += nums[(i + count - 1) % n] == 1 ? 1 : 0;
        	result = Math.min(result, count - windowCount);
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		Problem2134 problem = new Problem2134();
		System.out.println(problem.minSwaps(new int[] {0,1,0,1,1,0,0}));
	}
}
