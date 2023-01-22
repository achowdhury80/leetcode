package com.prep2020.medium;

public class Problem1997 {
	public int firstDayBeenInAllRooms(int[] nextVisit) {
        int[] dp = new int[nextVisit.length];
        int M = 1000000007;
        for (int i = 1; i < dp.length; i++) {
            int steps = 2 * dp[i-1] - dp[nextVisit[i-1]] + 2;
            dp[i] = steps < 0 ? (steps + M) % M : steps % M;

        }
        return dp[dp.length-1];
    }
}
