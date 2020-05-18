package comp.prep2019;

import java.util.Arrays;

public class Prob377 {
	public int combinationSum4(int[] nums, int target) {
		if(target == 0 || nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) dp[i] = -1;
        for (int i = 1; i <= target; i++) {
        	for (int j = 0; j < nums.length; j++) {
        		if (nums[j] <= i) {
        			if (dp[i - nums[j]] != -1) {
        				if (dp[i] == -1) dp[i] = 0;
        				dp[i] += dp[i - nums[j]];
        			}
        		} else break;
        	}
        }
        return dp[target] == -1 ? 0 : dp[target];
    }
	
	public static void main(String[] args) {
		Prob377 prob = new Prob377();
		System.out.println(prob.combinationSum4(new int[] {1, 2, 3}, 4));
	}
}
