package com.leet.algo;

public class Prob871 {
	/**
	 * https://leetcode.com/problems/minimum-number-of-refueling-stops/solution/
	 * O(N^2), O(N)
	 * dp[t] is the max miles covered with t stops
	 * start dp[0] with start fuel
	 * add each station one at a time
	 * if ith station added then you can have max i stops
	 * find dp[t + 1] if dp[t] >= stations[i] for each t <= i
	 * @param target
	 * @param startFuel
	 * @param stations
	 * @return
	 */
	public int minRefuelStops(int target, int startFuel, int[][] stations) {
	   int n = stations.length;
       long[] dp = new long[n + 1];
       dp[0] = startFuel;
       for (int i = 0; i < n; i++) {
    	  for (int t = i; t >= 0; t--) {
    		  if(dp[t] >= stations[i][0]) {
    			  dp[t + 1] = Math.max(dp[t + 1], dp[t] + stations[i][1]);
    		  }
    	  }
       }
       for (int i = 0; i <= n; i++) {
    	   if (dp[i] >= target) return i;
       }
       return -1;
       
    }
}
