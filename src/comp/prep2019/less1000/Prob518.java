package comp.prep2019.less1000;

import java.util.Arrays;

public class Prob518 {
	public int change(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
        	for (int j = 1; j <= amount; j++) {
        		if (j >= coins[i]) dp[j] += dp[j - coins[i]];
        	}
        }
        return dp[amount];
    }
	
	public static void main(String[] args) {
		Prob518 prob = new Prob518();
		System.out.println(prob.change(5, new int[] {1, 2, 5}));
	}
}
