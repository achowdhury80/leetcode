package comp.prep2019;

import java.util.*;

public class Prob377 {
	public int combinationSum4(int[] nums, int target) {
		if(target == 0 || nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
        	for (int j = 0; j < nums.length; j++) {
        		if (nums[j] > i) break;
        		dp[i] += dp[i - nums[j]];
        	}
        }
        return dp[target];
	}
	public int combinationSum4_1(int[] nums, int target) {
		if(target == 0 || nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        return helper(nums, target, 0, new HashMap<>());
    }
	
	private int helper(int[] nums, int target, int start, Map<String, Integer> map) {
		if (target == 0) return 1;
		String key = start + ":" + target;
		if (map.containsKey(key)) return map.get(key);
		int result = 0;
		for (int i = start; i < nums.length && nums[i] <= target; i++) {
			result += helper(nums, target - nums[i], start, map);
		}
		map.put(key, result);
		return result;
	}
}
