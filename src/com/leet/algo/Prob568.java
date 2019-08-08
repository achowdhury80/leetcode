package com.leet.algo;

public class Prob568 {
	/**
	 * O(N^2 * K) time and O(NK) space
	 * dp[i][w] = total vacation from starting from ith city and starting from wth week
	 * dp[i][w] = max of (days[i][w] + dp[i][w + 1] -- staying in the same city or days[j][w] + days[j][w+1] where j is the city connected to i.
	 * The idea behind this approach is as follows. The maximum number of vacations that can be taken given we start from the i^{th}i 
th
  city in the j^{th}j 
th
  week is not dependent on the the vacations that can be taken in the earlier weeks. It only depends on the number of vacations that can be taken in the upcoming weeks and also on the connections between the various cities(flightsflights).
  
	 * @param flights
	 * @param days
	 * @return
	 */
	public int maxVacationDays(int[][] flights, int[][] days) {
        int[][] dp = new int[flights.length][days.length + 1];
        for (int w = days[0].length - 1; w > -1; w--) {
        	for (int city = 0; city < flights.length; city++) {
        		dp[city][w] = dp[city][w + 1] + days[city][w];
        		// compute max vacation for dp[newCity][w + 1] provided there exist a flight between city to new city
        		for (int i = 0; i < flights[city].length; i++) {
        			if (flights[city][i] == 1) {
        				dp[city][w] = Math.max(dp[city][w], days[i][w] + dp[i][w + 1]);
        			}
        		}
        	}
        }
        return dp[0][0];
    }
}
