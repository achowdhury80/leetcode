package comp.prep2019;
public class Prob312 {
	public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[][] dp = new int[n][n];
        for (int left = n - 3; left > -1; left--) {
        	for (int right = left + 2; right < n; right++) {
        		for (int i = left + 1; i < right; i++) {
        			dp[left][right] = Math.max(dp[left][right], 
        					dp[left][i] + (left == 0 ? 1 
        					: nums[left - 1]) * nums[i - 1] * (right == n - 1 ? 1 
        					: nums[right - 1]) + dp[i][right]);
        		}
        	}
        }
        return dp[0][n - 1];
    }
	
	public static void main(String[] args) {
		Prob312 prob = new Prob312();
		System.out.println(prob.maxCoins(new int[] {3, 1, 5, 8}));
	}
}
