package comp.prep2019;

public class Prob983 {
	/**
	 * O(N) time and space
	 * @param days
	 * @param costs
	 * @return
	 */
	public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        int idx = 0;
        for (int i = 1; i <= days[days.length - 1]; i++) {
        	if (i == days[idx]) {
        		dp[i] = dp[i - 1] + costs[0];
        		int withWeeklyPass = costs[1] + ((i < 7) ? 0 : dp[i - 7]);
        		if (withWeeklyPass < dp[i]) dp[i] = withWeeklyPass;
        		int withMonthlyPass = costs[2] + ((i < 30) ? 0 : dp[i - 30]);
        		if (withMonthlyPass < dp[i]) dp[i] = withMonthlyPass;
        		idx++;
        	} else dp[i] = dp[i - 1];
        }
        return dp[days[days.length - 1]];
    }
}
