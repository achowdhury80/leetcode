package comp.prep2019;

import java.util.Arrays;

public class Prob322 {
	public int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) dp[i] = Integer.MAX_VALUE;
        for (int i = 1; i <= amount; i++) {
        	for (int j = 0; j < coins.length; j++) {
        		if (coins[j] > i) break;
        		if (dp[i - coins[j]] == Integer.MAX_VALUE) continue;
        		dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
        		
        	}
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
	
	public static void main(String[] args) {
		Prob322 prob = new Prob322();
		//System.out.println(prob.coinChange(new int[] {1, 2, 5}, 11));
		System.out.println(prob.coinChange(new int[] {2}, 3));
	}
}
