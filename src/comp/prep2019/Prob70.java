package comp.prep2019;

public class Prob70 {
	/**
	 * O(N) time and O(1) space
	 * nth step is reached by adding ways of reaching n - 1 step and n - 2 steps
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {
		if (n == 1) return 1;
		int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
        	int temp = dp[1] + dp[0];
        	dp[0] = dp[1];
        	dp[1] = temp;
        }
        return dp[1];
    }
}
