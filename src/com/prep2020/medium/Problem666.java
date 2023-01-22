package com.prep2020.medium;

import java.util.*;

public class Problem666 {
	/**
	 * O(nlogN)
	 * @param nums
	 * @return
	 */
	public int pathSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = nums.length - 1; i > -1; i--) {
        	String level = "" + (nums[i] / 10);
        	int curMultiplier = map.getOrDefault(level, 1);
        	sum += curMultiplier * (nums[i] % 10);
        	int pos = (nums[i] % 100) / 10;
        	String parentLevel = "" + ((nums[i] / 100) - 1) + ((pos + 1) / 2);
        	map.put(parentLevel, map.getOrDefault(parentLevel, 0) + curMultiplier);
        }
        return sum;
    }
	
	public static void main(String[] args) {
		Problem666 problem = new Problem666();
		//System.out.println(problem.pathSum(new int[] {113, 215, 221}));
		System.out.println(problem.pathSum(new int[] {113, 229, 349, 470, 485}));
	}
}
