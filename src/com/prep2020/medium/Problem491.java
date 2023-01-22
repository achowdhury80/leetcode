package com.prep2020.medium;

import java.util.*;

public class Problem491 {
	/**
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> findSubsequences(int[] nums) {
		int n = nums.length;
        Set<List<Integer>>[] dp = new Set[n];
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < n; i++) {
        	dp[i] = new HashSet<>();
        	dp[i].add(Arrays.asList(nums[i]));
        	for (int j = i - 1; j > -1; j--) {
        		if (nums[i] >= nums[j]) {
        			for (List<Integer> list : dp[j]) {
        				List<Integer> l = new ArrayList(list);
        				l.add(nums[i]);
        				dp[i].add(l);
        				result.add(l);
        			}
        		}
        	}
        }
        return new ArrayList<>(result);
    }
}
