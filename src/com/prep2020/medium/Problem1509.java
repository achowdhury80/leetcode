package com.prep2020.medium;
import java.util.*;
public class Problem1509 {
	public int minDifference(int[] nums) {
        if (nums.length < 5) return 0;
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        for (int k = 0; k <= 3; k++) {
        	result = Math.min(result, nums[nums.length - 4 + k] - nums[k]);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1509 problem = new Problem1509();
		//System.out.println(problem.minDifference(new int[] {1, 5, 0, 10, 14}));
		System.out.println(problem.minDifference(new int[] {82, 81, 95, 75, 20}));
	}
}
