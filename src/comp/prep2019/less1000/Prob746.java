package comp.prep2019.less1000;

public class Prob746 {
	/**
	 * O(N)
	 * @param cost
	 * @return
	 */
	public int minCostClimbingStairs(int[] cost) {
		int n;
	    if(cost == null || (n = cost.length) < 2) return 0;
	    int[] dp = new int[2];
	    for (int i = 2; i <= n; i++) {
	    	int min = Math.min(dp[0] + cost[i - 2], dp[1] + cost[i - 1]);
	    	dp[0] = dp[1];
	    	dp[1] = min;
	    }
	    return dp[1];
    }
}
