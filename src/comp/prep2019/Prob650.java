package comp.prep2019;

public class Prob650 {
	public int minSteps(int n) {
		int[] dp = new int[n + 1];
		for (int i = 2; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;
			for(int j = i / 2; j > 0; j--) {
				if (i % j == 0) {
					dp[i] = Math.min(dp[i], dp[j] + (i / j));
					break;
				}
			}
		}
		return dp[n];
    }
}
