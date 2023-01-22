package com.prep2020.hard;

public class Problem330 {
	public int minPatches(int[] nums, int n) {
        long soFar = 0;
        int result = 0, i = 0;
        while(soFar < n) {
        	if (i == nums.length || soFar + 1 < nums[i]) {
        		soFar += (soFar + 1);
        		result++;
        		continue;
        	} else if (i < nums.length && soFar + 1 >= nums[i]) {
        		soFar += nums[i];
        		i++;
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem330 problem = new Problem330();
		System.out.println(problem.minPatches(new int[] {1, 3}, 6));
		System.out.println(problem.minPatches(new int[] {1, 5, 10}, 20));
		System.out.println(problem.minPatches(new int[] {1, 2, 2}, 5));
	}
}
