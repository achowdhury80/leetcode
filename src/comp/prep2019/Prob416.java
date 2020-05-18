package comp.prep2019;

public class Prob416 {
	public boolean canPartition(int[] nums) {
		int n = nums.length;
        if (n < 2) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        boolean[][] dp = new boolean[target + 1][n + 1];
        for (int i = 0; i <= n; i++) dp[0][i] = true;
        for (int i = 1; i <= target; i++) dp[i][0] = false;
        for (int i = 1; i <= target; i++) {
        	for (int j = 1; j <= n; j++) {
        		dp[i][j] = dp[i][j - 1];
        		if (!dp[i][j]) {
        			if (i >= nums[j - 1] ) {
        				dp[i][j] = dp[i - nums[j - 1]][j - 1];
        			}
        		}
        	}
        }
        return dp[target][n];
    }
}
