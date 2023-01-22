package com.prep2020.hard;

public class Problem2035 {
	public int minimumDifference(int[] nums) {
        int[] result = new int[] {Integer.MAX_VALUE};
        int sum = 0;
        for (int i : nums) sum += i;
        helper(nums, 0, 0, 0, sum, result);
        return result[0];
    }

	private void helper(int[] nums, int start, int used, int curSum, int sum, int[] result) {
		int n = nums.length / 2;
		int usedNumber = Integer.bitCount(used) ;
		if (usedNumber == n) {
			if(Math.abs((sum - curSum) - curSum) < result[0]) result[0] = Math.abs((sum - curSum) - curSum);
			return;
		}
		if (n - usedNumber > 2 * n - start) return;
		for (int i = start; i < 2 * n; i++) {
			if ((used & (1 << i)) > 0) continue;
			helper(nums, i + 1, used | (1 << i), curSum + nums[i], sum, result);
		}
	}
	
	public static void main(String[] args) {
		Problem2035 problem = new Problem2035();
		System.out.println(problem.minimumDifference(new int[] {2,-1,0,4,-2,-9}));
	}
}
