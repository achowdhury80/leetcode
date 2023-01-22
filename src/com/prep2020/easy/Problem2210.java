package com.prep2020.easy;

public class Problem2210 {
	public int countHillValley(int[] nums) {
        int prevNonEqualIndex = 0, n = nums.length;
        int i = findNextNonEqualIndex(nums, 0);
        if (i == -1) return 0;
        int result = 0;
         while (i < n) {
        	 int next = findNextNonEqualIndex(nums, i);
        	 if (next == -1) return result;
        	 if ((nums[i] - nums[prevNonEqualIndex]) * (nums[i] - nums[next]) > 0)
        		 result++;
        	 prevNonEqualIndex = i;
        	 i = next;
         }
         return result;
    }
	
	private int findNextNonEqualIndex(int[] nums, int start) {
		for (int i = start + 1; i < nums.length; i++) {
			if (nums[i] != nums[start]) return i;
		}
		return -1;
	}
}
