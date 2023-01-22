package com.prep2020.medium;
import java.util.*;
public class Problem1546 {
	public int maxNonOverlapping(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
        	sum += nums[i];
        	dp[i] = i == 0 ? 0 : dp[i - 1];
        	if (map.containsKey(sum - target)) {
        		int lastIndex = map.get(sum - target);
        		dp[i] = Math.max(dp[i], (lastIndex == -1 ? 0 : dp[lastIndex]) + 1);
        	}
        	map.put(sum, i);
        	result = Math.max(result, dp[i]);
        }
        return result;
    }
}
